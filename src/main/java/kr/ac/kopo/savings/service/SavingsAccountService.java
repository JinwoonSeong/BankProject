package kr.ac.kopo.savings.service;


import kr.ac.kopo.savings.vo.SavingsAccountVO;
import kr.ac.kopo.transactiondetail.vo.TransactionDetailVO;

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
    
    // 추가 메소드
    String generateUniqueSavingsAccountNumber(int productNumber) throws Exception;
    // 상품 종류 가져오기
    List<String> getAllDepositTypes() throws Exception;
    // 상품 번호 가져오기
    int getProductNumber(String depositType) throws Exception;
    List<SavingsAccountVO> getAccountsByCustomerId(String customerId);
	List<TransactionDetailVO> getTransactionsByAccountId(String accountId);
	SavingsAccountVO getAccountById(String accountId) throws Exception;
    boolean checkPassword(String savingsAccountNum, String password) throws Exception;
    boolean terminateSavingsAccount(String savingsAccountNum, String password) throws Exception;
    boolean terminateSavingsAccount(String savingsAccountNum, String password, String transferAccountNum) throws Exception;
    
}
