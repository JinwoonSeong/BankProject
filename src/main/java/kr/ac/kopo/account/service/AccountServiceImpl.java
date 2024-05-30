package kr.ac.kopo.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.account.dao.AccountDAO;
import kr.ac.kopo.account.vo.AccountVO;

@Repository
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDAO accountDao;
	
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

}
