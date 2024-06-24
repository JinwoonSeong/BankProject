package kr.ac.kopo.transaction.service;

import java.util.Date;
import java.util.Random;

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
            // fromAccount 값을 가져옴
            String from_Account = transaction.getFrom_Account();
            
            // 현재 날짜 설정
            Date now = new Date();
            java.sql.Date sqlDate = new java.sql.Date(now.getTime());
            transaction.setTransactionDate(sqlDate);

            // 거래 타입 설정
            transaction.setTransactionType("이체");

            // 출금 계좌의 거래 금액을 음수로 설정
            transaction.setAmount(-transaction.getAmount());
            transaction.setAccount_Num(from_Account);

            // 출금 및 입금 처리
            transactionDao.decreaseBalance(transaction);

            // 출금 내역을 Transaction_details 테이블에 삽입
            int fromTransactionId = generateTransactionId();
            transaction.setTransactionId(fromTransactionId);
            transactionDao.insertTransactionDetail(transaction);

            // 입금 계좌의 거래 금액을 양수로 설정
            transaction.setAmount(-transaction.getAmount()); // 양수로 변경
            transaction.setAccount_Num(transaction.getTo_Account());
            transactionDao.increaseBalance(transaction);

            // 입금 내역을 Transaction_details 테이블에 삽입
            int toTransactionId = generateTransactionId();
            transaction.setTransactionId(toTransactionId);
            transactionDao.insertTransactionDetail(transaction);

        } catch (Exception e) {
            // 예외 발생 시 전체 트랜잭션을 롤백
            throw new RuntimeException("계좌 이체 중 오류 발생: " + e.getMessage(), e);
        }
    }

    private int generateTransactionId() {
        Random random = new Random();
        return random.nextInt(1000000);
    }
}
