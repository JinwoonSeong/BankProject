package kr.ac.kopo.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.kopo.loan.dao.LoanDAO;
import kr.ac.kopo.loan.vo.LoanVO;

@Service
public class LoanServiceImpl implements LoanService{
	
	@Autowired
    private LoanDAO loanDAO;

    public void applyLoan(LoanVO loan) throws Exception {
        loanDAO.insertLoan(loan);
        loanDAO.updateAccountBalance(loan.getAccountId(), loan.getAmount());
        System.out.println("씨발");
    }
    @Override
    public LoanVO getLoanById(String customerId) throws Exception {
        return loanDAO.findById(customerId);
    }

}
