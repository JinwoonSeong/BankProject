package kr.ac.kopo.loan.service;

import kr.ac.kopo.loan.vo.LoanVO;

public interface LoanService {

	void applyLoan(LoanVO loan) throws Exception;

	LoanVO getLoanById(String customerId) throws Exception;

}
