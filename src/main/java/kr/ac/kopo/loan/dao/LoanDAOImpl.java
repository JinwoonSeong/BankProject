package kr.ac.kopo.loan.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.loan.vo.LoanVO;

@Repository
public class LoanDAOImpl implements LoanDAO {
	
		@Autowired
	    private SqlSessionTemplate sqlSession;

		@Override
	    public void insertLoan(LoanVO loan) throws Exception {
	    	sqlSession.insert("dao.LoanDAO.insertLoan", loan);
	    	System.out.println("개씨발");
	    }

		@Override
	    public LoanVO findById(String customerId) throws Exception {
	        return sqlSession.selectOne("dao.LoanDAO.findById", customerId);
	    }
		
		@Override
	    public void updateAccountBalance(String accountId, double amount) throws Exception {
	        Map<String, Object> params = new HashMap<>();
	        params.put("accountId", accountId);
	        params.put("amount", amount);
	        sqlSession.update("dao.LoanDAO.updateAccountBalance", params);
	    }
		

}
  