package kr.ac.kopo.transaction.service;

import kr.ac.kopo.transaction.vo.TransactionVO;


public interface TransactionService {
	void transfer(TransactionVO transaction);
}
