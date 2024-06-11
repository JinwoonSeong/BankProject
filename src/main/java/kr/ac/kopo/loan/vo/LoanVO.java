package kr.ac.kopo.loan.vo;

public class LoanVO {
    private String Loan_num;
    private String borrower;
    private String customerId;
    private String loan_type;

	private String accountId;
    private double amount;
    private String startDate;
    private String endDate;
    private double interestRate;
    private int Repayment_status;

    // Getters and Setters
    public String getLoan_num() {
        return Loan_num;
    }

    public int getRepayment_status() {
		return Repayment_status;
	}

	public void setRepayment_status(int repayment_status) {
		Repayment_status = repayment_status;
	}

	public String getLoan_type() {
		return loan_type;
	}
	
	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}
	public void setLoan_num(String Loan_num) {
        this.Loan_num = Loan_num;
    }
    public String getBorrower() {
    	return borrower;
    }
    
    public void setBorrower(String borrower) {
    	this.borrower = borrower;
    }

    public String getcustomerId() {
        return customerId;
    }

    public void setcustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getAccountId() {
    	return accountId;
    }
    
    public void setAccountId(String accountId) {
    	this.accountId = accountId;
    }


	public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
