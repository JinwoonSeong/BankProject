package kr.ac.kopo.account.service;

import java.util.List;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.transactiondetail.vo.TransactionDetailVO;

public interface AccountService {
    AccountVO accountRegister(AccountVO account);
    boolean deposit(String accountNum, int amount);
    boolean withdraw(String accountId, String password, int amount);
    List<AccountVO> getAllAccounts();
    AccountVO getAccountById(String accountId);
    List<TransactionDetailVO> getTransactionsByAccountId(String accountId);
    List<AccountVO> getAccountsByCustomerId(String customerId);
    boolean closeAccount(String accountId, String password);
    AccountVO getAccountByIdAndCustomerId(String accountId, String customerId);

}