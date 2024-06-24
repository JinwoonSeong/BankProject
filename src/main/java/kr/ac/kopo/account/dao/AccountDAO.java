package kr.ac.kopo.account.dao;

import java.util.List;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.transactiondetail.vo.TransactionDetailVO;

public interface AccountDAO {
	
	void accountRegister(AccountVO account) throws Exception;
	AccountVO findAccountByNumber(String accountNum) throws Exception; 
    void updateAccount(AccountVO account) throws Exception; 
    void deposit(String accountNum, int amount) throws Exception;
	
	AccountVO findById(String accountId);
    void update(AccountVO account);
    
    List<AccountVO> getAllAccounts();
    AccountVO getAccountById(String accountId);
    List<TransactionDetailVO> getTransactionsByAccountId(String accountId);
    
    List<AccountVO> getAccountsByCustomerId(String customerId);

    AccountVO getAccountByIdAndCustomerId(String accountId, String customerId);
    void closeAccount(String accountId);
   
    
}
