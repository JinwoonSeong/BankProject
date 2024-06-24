package kr.ac.kopo.savings.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.ac.kopo.savings.vo.SavingsAccountVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SavingsAccountDAOImpl implements SavingsAccountDAO {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<SavingsAccountVO> findAllSavingsAccounts() throws Exception {
        return sqlSession.selectList("dao.SavingsAccountDAO.findAllSavingsAccounts");
    }

    @Override
    public void savingsAccountRegister(SavingsAccountVO savingsAccount) throws Exception {
        sqlSession.insert("dao.SavingsAccountDAO.savingsAccountRegister", savingsAccount);
    }

    @Override
    public void savingsDeposit(String savingsAccountNum, int amount) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("savings_account_num", savingsAccountNum);
        params.put("amount", amount);
        sqlSession.update("dao.SavingsAccountDAO.savingsDeposit", params);
    }

    @Override
    public void createSavings(SavingsAccountVO account) throws Exception {
        sqlSession.insert("dao.SavingsAccountDAO.createSavings", account);
    }

    @Override
    public SavingsAccountVO readSavings(String savingsAccountNum) throws Exception {
        return sqlSession.selectOne("dao.SavingsAccountDAO.findSavingsAccountByNumber", savingsAccountNum);
    }

    @Override
    public void updateSavings(SavingsAccountVO account) throws Exception {
        sqlSession.update("dao.SavingsAccountDAO.updateSavingsAccount", account);
    }

    @Override
    public void deleteSavings(String depositType) throws Exception {
        sqlSession.delete("dao.SavingsAccountDAO.deleteSavings", depositType);
    }

    @Override
    public void applyInterest(SavingsAccountVO account) throws Exception {
        double dailyInterestRate = account.getInterest_rate() / 365;
        double newBalance = account.getAmount() * (1 + dailyInterestRate);
        account.setAmount(newBalance);
        sqlSession.update("dao.SavingsAccountDAO.updateSavingsAccount", account);
    }

	@Override
	public SavingsAccountVO findSavingsAccountByNumber(String savingsAccountNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
