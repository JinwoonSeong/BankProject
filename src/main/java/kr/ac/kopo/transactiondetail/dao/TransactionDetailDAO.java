package kr.ac.kopo.transactiondetail.dao;

import java.util.List;

import kr.ac.kopo.transactiondetail.vo.TransactionDetailVO;

public interface TransactionDetailDAO {
	void insertTransaction(TransactionDetailVO transaction);
	
	void save(TransactionDetailVO transaction) throws Exception;
    List<TransactionDetailVO> findByAccountNum(String accountNum) throws Exception;
}
