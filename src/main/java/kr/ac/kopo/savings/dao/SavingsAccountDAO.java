package kr.ac.kopo.savings.dao;

import java.util.List;
import java.util.Map;

import kr.ac.kopo.savings.vo.SavingsAccountVO;
import kr.ac.kopo.transactiondetail.vo.TransactionDetailVO;

public interface SavingsAccountDAO {
    void savingsAccountRegister(SavingsAccountVO savingsAccount) throws Exception;
    void savingsDeposit(String savingsAccountNum, int amount) throws Exception;
    SavingsAccountVO findSavingsAccountByNumber(String savingsAccountNum) throws Exception;
    List<SavingsAccountVO> findAllSavingsAccounts() throws Exception;

    // 적금 상품 CRUD 메소드
    void createSavings(SavingsAccountVO account) throws Exception;
    SavingsAccountVO readSavings(String savingsAccountNum) throws Exception;
    void updateSavingsAccount(SavingsAccountVO savingsAccount)throws Exception;
    void deleteSavings(String depositType) throws Exception;
    
    // 적금 계좌에 이자율을 적용하여 잔액을 업데이트하는 메소드
    void applyInterest(SavingsAccountVO account) throws Exception;

    // 적금 금액 실행 쿼리
    void updateAllSavingsAccounts() throws Exception;

    // 추가 메소드
    int getProductNumber(String depositType) throws Exception;
    boolean isAccountNumberExists(String accountNumber) throws Exception;
    List<String> getAllDepositTypes() throws Exception;
	List<SavingsAccountVO> getAccountsByCustomerId(String customerId);
	List<TransactionDetailVO> getTransactionsByAccountId(String accountId);
	SavingsAccountVO getAccountById(String accountId);
	SavingsAccountVO findByAccountNum(String accountNum);
	SavingsAccountVO getAccountById2(String accountId);
	void deleteAccount(String accountId);

    void insertTransactionHistory(TransactionDetailVO transactionHistory);

    void updateAccountBalance(String targetAccountId, int amount);
	
    
	// 계좌번호중복방지 메소드
    int countBySavingsAccountNumber(String accountNumber);
}
