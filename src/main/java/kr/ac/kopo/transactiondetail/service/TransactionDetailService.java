package kr.ac.kopo.transactiondetail.service;

import kr.ac.kopo.transactiondetail.vo.TransactionDetailVO;

public interface TransactionDetailService {
    void deposit(TransactionDetailVO transaction);
    void withdraw(TransactionDetailVO transaction);
    void transfer(TransactionDetailVO transaction);
    void loan(TransactionDetailVO transaction);
    void recordTransaction(TransactionDetailVO transaction);
}