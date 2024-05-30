package kr.ac.kopo.account.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.account.vo.AccountVO;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void accountRegister(AccountVO account) throws Exception{
		 sqlSession.insert("dao.AccountDAO.accountRegister", account);
		
	}

}
