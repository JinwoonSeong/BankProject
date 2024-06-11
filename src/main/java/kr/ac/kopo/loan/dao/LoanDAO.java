package kr.ac.kopo.loan.dao;

import kr.ac.kopo.loan.vo.LoanVO;

public interface LoanDAO {
	
	void insertLoan(LoanVO loan) throws Exception;
    LoanVO findById(String customerId) throws Exception;
    void updateAccountBalance(String accountId, double amount) throws Exception;
}
