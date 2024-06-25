package kr.ac.kopo.savings.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            accountNumber = RandomSavingsAccountNumberGenerator.generateRandomAccountNumber(productNumber);
        } while (savingsAccountDAO.isAccountNumberExists(accountNumber));
        return accountNumber;
    }

    @Override
    public List<String> getAllDepositTypes() throws Exception {
        return savingsAccountDAO.getAllDepositTypes();
    }

    @Override
    public int getProductNumber(String depositType) throws Exception {
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
    public boolean checkPassword(String savingsAccountNum, String password) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("savingsAccountNum", savingsAccountNum);
        params.put("password", password);
        int count = savingsAccountDAO.checkPassword(params);
        return count > 0;
    }

    @Override
    @Transactional
    public boolean terminateSavingsAccount(String savingsAccountNum, String password) throws Exception {
        if (!checkPassword(savingsAccountNum, password)) {
            return false;
        }

        SavingsAccountVO savingsAccount = savingsAccountDAO.findByAccountNum(savingsAccountNum);
        if (savingsAccount == null || savingsAccount.getAmount() <= 0) {
            return false;
        }

        savingsAccountDAO.delete(savingsAccountNum);
        return true;
    }

    @Override
    @Transactional
    public boolean terminateSavingsAccount(String savingsAccountNum, String password, String transferAccountNum) throws Exception {
        if (!checkPassword(savingsAccountNum, password)) {
            return false;
        }

        SavingsAccountVO savingsAccount = savingsAccountDAO.findByAccountNum(savingsAccountNum);
        if (savingsAccount == null) {
            return false;
        }

        double amount = savingsAccount.getAmount();
        boolean transferSuccess = savingsAccountDAO.transfer(savingsAccountNum, transferAccountNum, amount);
        if (!transferSuccess) {
            return false;
        }

        TransactionDetailVO transaction = new TransactionDetailVO();
        transaction.setAccountNum(transferAccountNum);
        transaction.setAmount(amount);
        transaction.setTransactionDate(new java.util.Date());
        transaction.setTransaction_type("입금");
        savingsAccountDAO.saveTransaction(transaction);

        savingsAccountDAO.delete(savingsAccountNum);
        return true;
    }
}
