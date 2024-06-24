package kr.ac.kopo.account.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.account.dao.AccountDAO;
import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.transactiondetail.service.TransactionDetailService;
import kr.ac.kopo.transactiondetail.vo.TransactionDetailVO;

@Repository
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDAO accountDao;
	@Autowired
    private TransactionDetailService transactiondetailService;
	
	@Override
	public AccountVO accountRegister(AccountVO account) {
		try {
			accountDao.accountRegister(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	
	@Override
    public boolean deposit(String accountNum, int amount) {
        try {
        	AccountVO account = accountDao.findById(accountNum);
            accountDao.deposit(accountNum, amount);
            TransactionDetailVO transaction = new TransactionDetailVO();
            transaction.setAccountNum(accountNum);
            transaction.setTransaction_type("입금");
            transaction.setAmount(amount);
            transaction.setTransactionDate(new Date());
            transaction.setDepositorName(account.getCustomer_id());
            transaction.setToAccount(accountNum);
            transactiondetailService.recordTransaction(transaction);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
	@Override
    public boolean withdraw(String accountId, String password, int amount) {
        AccountVO account = accountDao.findById(accountId);
        if (account != null && account.getAccount_password().equals(password) && account.getAccount_money() >= amount) {
            account.setAccount_money(account.getAccount_money() - amount);
            accountDao.update(account);
            
            TransactionDetailVO transaction = new TransactionDetailVO();
            transaction.setAccountNum(accountId);
            transaction.setTransaction_type("출금");
            transaction.setAmount(-amount);
            transaction.setTransactionDate(new Date());
            transaction.setDepositorName(account.getCustomer_id());
            transaction.setFromAccount(accountId);
            transactiondetailService.recordTransaction(transaction);

            return true;
        }
        return false;
    }
	
	@Override
    public List<AccountVO> getAllAccounts() {
        return accountDao.getAllAccounts();
    }

    @Override
    public AccountVO getAccountById(String accountId) {
        return accountDao.getAccountById(accountId);
    }

    @Override
    public List<TransactionDetailVO> getTransactionsByAccountId(String accountId) {
        return accountDao.getTransactionsByAccountId(accountId);
    }
    
    @Override
    public List<AccountVO> getAccountsByCustomerId(String customerId) {
        return accountDao.getAccountsByCustomerId(customerId);
    }
    @Override
    public AccountVO getAccountByIdAndCustomerId(String accountId, String customerId) {
        return accountDao.getAccountByIdAndCustomerId(accountId, customerId);
    }
    
    @Override
    public boolean closeAccount(String accountId, String password) {
        AccountVO account = accountDao.getAccountById(accountId);
        if (account != null && account.getAccount_password().equals(password)) {
            accountDao.closeAccount(accountId);
            return true;
        } else {
            return false;
        }
    }
	

}
