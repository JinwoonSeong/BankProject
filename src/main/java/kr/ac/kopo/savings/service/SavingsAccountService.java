package kr.ac.kopo.savings.service;

import kr.ac.kopo.savings.vo.SavingsAccountVO;

import java.util.List;

public interface SavingsAccountService {
    void applyInterest();
    SavingsAccountVO savingsAccountRegister(SavingsAccountVO savingsAccount);
    boolean savingsDeposit(String savingsAccountNum, int amount);
    void updateSavingsAccount(SavingsAccountVO savingsAccount);
    void deleteSavingsAccountByType(String depositType);
    List<SavingsAccountVO> findAllSavingsAccounts();
    SavingsAccountVO findSavingsAccountByNumber(String savingsAccountNum);
    
    // 적금 상품 CRUD 메소드
    SavingsAccountVO createSavings(SavingsAccountVO savingsAccount);
    SavingsAccountVO readSavings(String savingsAccountNum);
    void updateSavings(SavingsAccountVO savingsAccount);
    void deleteSavings(String depositType);
}
