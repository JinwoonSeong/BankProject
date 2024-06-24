package kr.ac.kopo.transactiondetail.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.ac.kopo.transactiondetail.vo.TransactionDetailVO;

@Repository
public class TransactionDetailDAOImpl implements TransactionDetailDAO {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public void insertTransaction(TransactionDetailVO transaction) {
        sqlSession.insert("dao.TransactionDetailDAO.insertTransaction", transaction);
    }
}
