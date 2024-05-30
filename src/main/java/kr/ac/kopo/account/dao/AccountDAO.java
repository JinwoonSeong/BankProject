package kr.ac.kopo.account.dao;

import kr.ac.kopo.account.vo.AccountVO;

public interface AccountDAO {
	
	void accountRegister(AccountVO account) throws Exception;
    
}
