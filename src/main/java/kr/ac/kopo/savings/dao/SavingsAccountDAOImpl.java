package kr.ac.kopo.savings.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.savings.vo.SavingsAccountVO;
import kr.ac.kopo.transactiondetail.vo.TransactionDetailVO;

@Repository
public class SavingsAccountDAOImpl implements SavingsAccountDAO {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<SavingsAccountVO> findAllSavingsAccounts() throws Exception {
        return sqlSession.selectList("kr.ac.kopo.savings.dao.SavingsAccountDAO.findAllSavingsAccounts");
    }

    @Override
    public void savingsAccountRegister(SavingsAccountVO savingsAccount) throws Exception {
        sqlSession.insert("kr.ac.kopo.savings.dao.SavingsAccountDAO.savingsAccountRegister", savingsAccount);
    }

    @Override
    public void savingsDeposit(String savingsAccountNum, int amount) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("savings_account_num", savingsAccountNum);
        params.put("amount", amount);
        sqlSession.update("kr.ac.kopo.savings.dao.SavingsAccountDAO.savingsDeposit", params);
    }

    @Override
    public void createSavings(SavingsAccountVO account) throws Exception {
        sqlSession.insert("kr.ac.kopo.savings.dao.SavingsAccountDAO.createSavings", account);
    }

    @Override
    public SavingsAccountVO readSavings(String savingsAccountNum) throws Exception {
        return sqlSession.selectOne("kr.ac.kopo.savings.dao.SavingsAccountDAO.findSavingsAccountByNumber", savingsAccountNum);
    }

    @Override
    public void updateSavingsAccount(SavingsAccountVO account) throws Exception {
        sqlSession.update("kr.ac.kopo.savings.dao.SavingsAccountDAO.updateSavingsAccount", account);
    }

    @Override
    public void deleteSavings(String depositType) throws Exception {
        sqlSession.delete("kr.ac.kopo.savings.dao.SavingsAccountDAO.deleteSavings", depositType);
    }

    @Override
    public void applyInterest(SavingsAccountVO account) throws Exception {
        double dailyInterestRate = account.getInterest_rate() / 365;
        double newBalance = account.getAmount() * (1 + dailyInterestRate);
        account.setAmount(newBalance);
        sqlSession.update("kr.ac.kopo.savings.dao.SavingsAccountDAO.updateSavingsAccount", account);
    }

    @Override
    public SavingsAccountVO findSavingsAccountByNumber(String savingsAccountNum) throws Exception {
        return sqlSession.selectOne("kr.ac.kopo.savings.dao.SavingsAccountDAO.findSavingsAccountByNumber", savingsAccountNum);
    }

    @Override
    public int getProductNumber(String depositType) throws Exception {
        System.out.println("DAO - Getting product number for deposit type: " + depositType); // 로그 추가
        Integer productNumber = sqlSession.selectOne("kr.ac.kopo.savings.dao.SavingsAccountDAO.getProductNumber", depositType);
        System.out.println("DAO - Product number retrieved: " + productNumber); // 로그 추가
        return productNumber != null ? productNumber : 0; // null 체크 후 기본 값 반환
    }




    @Override
    public boolean isAccountNumberExists(String accountNumber) throws Exception {
        int count = sqlSession.selectOne("kr.ac.kopo.savings.dao.SavingsAccountDAO.isAccountNumberExists", accountNumber);
        return count > 0;
    }

    @Override
    public List<String> getAllDepositTypes() throws Exception {
        return sqlSession.selectList("kr.ac.kopo.savings.dao.SavingsAccountDAO.getAllDepositTypes");
    }
    
    @Override
    public void updateAllSavingsAccounts() throws Exception {
        sqlSession.update("kr.ac.kopo.savings.dao.SavingsAccountDAO.updateAllSavingsAccounts");
    }
    
    @Override
    public List<SavingsAccountVO> getAccountsByCustomerId(String customerId) {
        return sqlSession.selectList("kr.ac.kopo.savings.dao.SavingsAccountDAO.getAccountsByCustomerId", customerId);
    }
    
    @Override
    public SavingsAccountVO getAccountById(String accountId) {
        return sqlSession.selectOne("dao.AccountDAO.getAccountById", accountId);
    }

    @Override
    public List<TransactionDetailVO> getTransactionsByAccountId(String accountId) {
        return sqlSession.selectList("dao.AccountDAO.getTransactionsByAccountId", accountId);
    }
    
    // 계좌 중복되지 않고 생성하게 하는 메소드
    @Override
    public int countBySavingsAccountNumber(String accountNumber) {
        return sqlSession.selectOne("kr.ac.kopo.savings.dao.SavingsAccountDAO.countBySavingsAccountNumber", accountNumber);
    }
    
    @Override
    public SavingsAccountVO findByAccountNum(String accountNum) {
        return sqlSession.selectOne("kr.ac.kopo.savings.dao.SavingsAccountDAO.findByAccountNum", accountNum);
    }

    @Override
    public SavingsAccountVO getAccountById2(String accountId) {
        return sqlSession.selectOne("kr.ac.kopo.savings.dao.SavingsAccountDAO.getAccountById", accountId);
    }

    @Override
    public void deleteAccount(String accountId) {
        sqlSession.delete("kr.ac.kopo.savings.dao.SavingsAccountDAO.deleteAccount", accountId);
    }

    @Override
    public void insertTransactionHistory(TransactionDetailVO transactionHistory) {
        sqlSession.insert("kr.ac.kopo.savings.dao.SavingsAccountDAO.insertTransactionHistory", transactionHistory);
    }

    @Override
    public void updateAccountBalance(String targetAccountId, double amount) {
        Map<String, Object> params = new HashMap<>();
        params.put("targetAccountId", targetAccountId);
        params.put("amount", amount);
        sqlSession.update("kr.ac.kopo.savings.dao.SavingsAccountDAO.updateAccountBalance", params);
    }



}
