package kr.ac.kopo.transaction.dao;

import kr.ac.kopo.transaction.vo.TransactionVO;

public interface TransactionDAO {
	
    void decreaseBalance(TransactionVO transaction) throws Exception;
    void increaseBalance(TransactionVO transaction) throws Exception;
}
