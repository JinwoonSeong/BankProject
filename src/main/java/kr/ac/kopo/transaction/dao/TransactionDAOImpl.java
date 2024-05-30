package kr.ac.kopo.transaction.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
}
