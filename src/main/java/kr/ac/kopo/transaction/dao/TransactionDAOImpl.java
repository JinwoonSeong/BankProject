package kr.ac.kopo.transaction.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.transaction.vo.TransactionVO;

@Repository
public class TransactionDAOImpl implements TransactionDAO {
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public void decreaseBalance(TransactionVO transaction) throws Exception {
        sqlSession.update("dao.TransferDAO.decreaseBalance", transaction);
    }

    @Override
    public void increaseBalance(TransactionVO transaction) throws Exception {
        sqlSession.update("dao.TransferDAO.increaseBalance", transaction);
    }
    
    @Override
    public AccountVO getAccountByAccountNum(String accountNum) {
        return sqlSession.selectOne("dao.TransferDAO.getAccountByAccountNum", accountNum);
    }
    @Override
    public void insertTransactionDetail(TransactionVO transaction) throws Exception {
        sqlSession.insert("dao.TransferDAO.insertTransactionDetail", transaction);
    }
    
}
