package kr.ac.kopo.savings.service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.savings.dao.RandomSavingsAccountNumberGenerator;
import kr.ac.kopo.savings.dao.SavingsAccountDAO;
import kr.ac.kopo.savings.vo.SavingsAccountVO;
import kr.ac.kopo.transactiondetail.vo.TransactionDetailVO;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService {

    @Autowired
    private SavingsAccountDAO savingsAccountDAO;

    @Autowired
    private RandomSavingsAccountNumberGenerator accountNumberGenerator;

    @Scheduled(cron = "*/30 * * * * *")
    @Transactional
    @Override
    public void applyInterest() {
        System.out.println("적금양 증가!!!");
        try {
            savingsAccountDAO.updateAllSavingsAccounts();
        } catch (Exception e) {
            throw new RuntimeException("적금 계좌 이자 적용 중 오류 발생: " + e.getMessage(), e);
        }
    }

    @Override
    public SavingsAccountVO savingsAccountRegister(SavingsAccountVO savingsAccount) {
        try {
            savingsAccountDAO.savingsAccountRegister(savingsAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savingsAccount;
    }

    @Override
    public boolean savingsDeposit(String savingsAccountNum, int amount) {
        try {
            savingsAccountDAO.savingsDeposit(savingsAccountNum, amount);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateSavingsAccount(SavingsAccountVO savingsAccount) {
        try {
            savingsAccountDAO.updateSavingsAccount(savingsAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSavingsAccountByType(String depositType) {
        try {
            savingsAccountDAO.deleteSavings(depositType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SavingsAccountVO> findAllSavingsAccounts() {
        try {
            return savingsAccountDAO.findAllSavingsAccounts();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SavingsAccountVO findSavingsAccountByNumber(String savingsAccountNum) {
        try {
            return savingsAccountDAO.findSavingsAccountByNumber(savingsAccountNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 적금 상품 CRUD 메소드
    @Override
    public SavingsAccountVO createSavings(SavingsAccountVO savingsAccount) {
        try {
            savingsAccountDAO.createSavings(savingsAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savingsAccount;
    }

    @Override
    public SavingsAccountVO readSavings(String savingsAccountNum) {
        try {
            return savingsAccountDAO.readSavings(savingsAccountNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateSavings(SavingsAccountVO savingsAccount) {
        try {
            savingsAccountDAO.updateSavingsAccount(savingsAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSavings(String depositType) {
        try {
            savingsAccountDAO.deleteSavings(depositType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String generateUniqueSavingsAccountNumber(int productNumber) throws Exception {
        String accountNumber;
        do {
            accountNumber = accountNumberGenerator.generateRandomAccountNumber(productNumber);
        } while (savingsAccountDAO.isAccountNumberExists(accountNumber));
        return accountNumber;
    }

    @Override
    public List<String> getAllDepositTypes() throws Exception {
        return savingsAccountDAO.getAllDepositTypes();
    }

    @Override
    public int getProductNumber(String depositType) throws Exception {
        System.out.println("Getting product number for deposit type: " + depositType);
        return savingsAccountDAO.getProductNumber(depositType);
    }

    @Override
    public List<SavingsAccountVO> getAccountsByCustomerId(String customerId) {
        return savingsAccountDAO.getAccountsByCustomerId(customerId);
    }

    @Override
    public List<TransactionDetailVO> getTransactionsByAccountId(String accountId) {
        return savingsAccountDAO.getTransactionsByAccountId(accountId);
    }

    @Override
    public SavingsAccountVO getAccountById(String accountId) throws Exception {
        return savingsAccountDAO.findByAccountNum(accountId);
    }
    @Override
    public SavingsAccountVO getAccountById2(String accountId) throws Exception {
    	return savingsAccountDAO.findByAccountNum(accountId);
    }
    
    
    
    private int generateTransactionId() {
        Random random = new Random();
        return random.nextInt(1000000);
    }
    
    @Override
    @Transactional
    public void terminateSavingsAccount(String accountId, String password, String targetAccountId) throws Exception {
        SavingsAccountVO account = getAccountById(accountId);
        if (account != null && account.getSavings_account_password().equals(password)) {
            // 잔액을 이체
            savingsAccountDAO.updateAccountBalance(targetAccountId, account.getAmount());

            // 거래 내역 삽입
            TransactionDetailVO transactionHistory = new TransactionDetailVO();
            
            int toTransactionId = generateTransactionId();
            transactionHistory.setTransactionId(toTransactionId);
            transactionHistory.setAccountNum(targetAccountId);
            transactionHistory.setAmount(account.getAmount());
            transactionHistory.setTransactionDate(new Date());
            transactionHistory.setToAccount(targetAccountId);
            transactionHistory.setFromAccount(accountId);
            transactionHistory.setDepositorName(account.getCustomer_id());
            savingsAccountDAO.insertTransactionHistory(transactionHistory);

            // 계좌 삭제
            savingsAccountDAO.deleteAccount(accountId);
        } else {
            throw new IllegalArgumentException("없는 계좌 번호 거나 적금 계좌 비밀번호가 틀렸습니다.");
        }
    }

    
}
