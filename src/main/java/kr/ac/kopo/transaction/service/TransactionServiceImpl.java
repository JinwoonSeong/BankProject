package kr.ac.kopo.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.transaction.dao.TransactionDAO;
import kr.ac.kopo.transaction.vo.TransactionVO;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDAO transactionDao;

    @Transactional
    @Override
    public void transfer(TransactionVO transaction) {
        try {
            transactionDao.decreaseBalance(transaction);
            transactionDao.increaseBalance(transaction);
        } catch (Exception e) {
            // 예외 발생 시 전체 트랜잭션을 롤백
            throw new RuntimeException("계좌 이체 중 오류 발생: " + e.getMessage(), e);
        }
    }
}
