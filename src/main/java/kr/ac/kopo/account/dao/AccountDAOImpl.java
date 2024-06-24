package kr.ac.kopo.account.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.transactiondetail.vo.TransactionDetailVO;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void accountRegister(AccountVO account) throws Exception{
		 sqlSession.insert("dao.AccountDAO.accountRegister", account);
		
	}
	
	@Override
    public AccountVO findAccountByNumber(String accountNum) throws Exception {
        return sqlSession.selectOne("dao.AccountDAO.findAccountByNumber", accountNum);
    }

    @Override
    public void updateAccount(AccountVO account) throws Exception {
        sqlSession.update("dao.AccountDAO.updateAccount", account);
    }

    @Override
    public void deposit(String accountNum, int amount) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("account_num", accountNum);
        params.put("amount", amount);
        sqlSession.update("dao.AccountDAO.deposit", params);
    }
	
	 @Override
	    public AccountVO findById(String accountId) {
	        return sqlSession.selectOne("dao.AccountDAO.findById", accountId);
	    }

	    @Override
	    public void update(AccountVO account) {
	        sqlSession.update("dao.AccountDAO.update", account);
	    }
	    
	    @Override
	    public List<AccountVO> getAllAccounts() {
	        return sqlSession.selectList("dao.AccountDAO.getAllAccounts");
	    }

	    @Override
	    public AccountVO getAccountById(String accountId) {
	        return sqlSession.selectOne("dao.AccountDAO.getAccountById", accountId);
	    }

	    @Override
	    public List<TransactionDetailVO> getTransactionsByAccountId(String accountId) {
	        return sqlSession.selectList("dao.AccountDAO.getTransactionsByAccountId", accountId);
	    }
	    @Override
	    public List<AccountVO> getAccountsByCustomerId(String customerId) {
	        return sqlSession.selectList("dao.AccountDAO.getAccountsByCustomerId", customerId);
	    }
	    @Override
	    public AccountVO getAccountByIdAndCustomerId(String accountId, String customerId) {
	        Map<String, String> params = new HashMap<>();
	        params.put("accountId", accountId);
	        params.put("customerId", customerId);
	        return sqlSession.selectOne("dao.AccountDAO.getAccountByIdAndCustomerId", params);
	    }
	    
	    @Override
	    public void closeAccount(String accountId) {
	        sqlSession.delete("dao.AccountDAO.closeAccount", accountId);
	    }

}
