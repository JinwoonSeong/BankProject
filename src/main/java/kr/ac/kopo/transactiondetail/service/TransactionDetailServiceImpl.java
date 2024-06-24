package kr.ac.kopo.transactiondetail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.kopo.transactiondetail.dao.TransactionDetailDAO;
import kr.ac.kopo.transactiondetail.vo.TransactionDetailVO;

@Service
public class TransactionDetailServiceImpl implements TransactionDetailService {
	
	@Autowired
    private TransactionDetailDAO transactiondetailDAO;

    @Override
    public void deposit(TransactionDetailVO transaction) {
        transaction.setTransactionId(generateRandomTransactionId());
        transactiondetailDAO.insertTransaction(transaction);
    }

    @Override
    public void withdraw(TransactionDetailVO transaction) {
        transaction.setTransactionId(generateRandomTransactionId());
        transactiondetailDAO.insertTransaction(transaction);
    }

    @Override
    public void transfer(TransactionDetailVO transaction) {
        transaction.setTransactionId(generateRandomTransactionId());
        transactiondetailDAO.insertTransaction(transaction);
    }

    @Override
    public void loan(TransactionDetailVO transaction) {
        transaction.setTransactionId(generateRandomTransactionId());
        transactiondetailDAO.insertTransaction(transaction);
    }
    @Override
    public void recordTransaction(TransactionDetailVO transaction) {
        transaction.setTransactionId(generateRandomTransactionId());
        transactiondetailDAO.insertTransaction(transaction);
    }

    private int generateRandomTransactionId() {
        return (int) (Math.random() * 100000000);
    }

}
