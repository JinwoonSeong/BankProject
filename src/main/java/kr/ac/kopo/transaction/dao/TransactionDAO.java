package kr.ac.kopo.transaction.dao;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.transaction.vo.TransactionVO;

public interface TransactionDAO {
	
    void decreaseBalance(TransactionVO transaction) throws Exception;
    void increaseBalance(TransactionVO transaction) throws Exception;
    AccountVO getAccountByAccountNum(String accountNum) throws Exception;
    void insertTransactionDetail(TransactionVO transaction) throws Exception;
}
