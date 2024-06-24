package kr.ac.kopo.savings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.ac.kopo.savings.dao.SavingsAccountDAO;
import kr.ac.kopo.savings.vo.SavingsAccountVO;

import java.util.List;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService {

    @Autowired
    private SavingsAccountDAO savingsAccountDAO;

    @Scheduled(cron = "0 0 0 1 * ?")
    @Transactional
    @Override
    public void applyInterest() {
        try {
            List<SavingsAccountVO> savingsAccounts = savingsAccountDAO.findAllSavingsAccounts();
            for (SavingsAccountVO account : savingsAccounts) {
                double dailyInterestRate = account.getInterest_rate() / 365;
                double newBalance = account.getAmount() * (1 + dailyInterestRate);
                account.setAmount(newBalance);
                savingsAccountDAO.updateSavings(account);
            }
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
            savingsAccountDAO.updateSavings(savingsAccount);
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
            savingsAccountDAO.updateSavings(savingsAccount);
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
}
