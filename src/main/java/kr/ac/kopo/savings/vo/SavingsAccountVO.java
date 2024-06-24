package kr.ac.kopo.savings.vo;

public class SavingsAccountVO {
    private String savings_account_num; // 적금 계좌 번호
    private String account_holder;     // 계좌 소유자
    private String deposit_type;       // 예금 종류
    private double amount;            // 금액
    private double interest_rate;      // 이자율
    private String savings_account_password; // 비밀번호
    private String customer_id;
	public String getSavings_account_num() {
		return savings_account_num;
	}
	public void setSavings_account_num(String savings_account_num) {
		this.savings_account_num = savings_account_num;
	}
	public String getAccount_holder() {
		return account_holder;
	}
	public void setAccount_holder(String account_holder) {
		this.account_holder = account_holder;
	}
	public String getDeposit_type() {
		return deposit_type;
	}
	public void setDeposit_type(String deposit_type) {
		this.deposit_type = deposit_type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getInterest_rate() {
		return interest_rate;
	}
	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}
	public String getSavings_account_password() {
		return savings_account_password;
	}
	public void setSavings_account_password(String savings_account_password) {
		this.savings_account_password = savings_account_password;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	@Override
	public String toString() {
		return "SavingsAccountVO [savings_account_num=" + savings_account_num + ", account_holder=" + account_holder
				+ ", deposit_type=" + deposit_type + ", amount=" + amount + ", interest_rate=" + interest_rate
				+ ", savings_account_password=" + savings_account_password + ", customer_id=" + customer_id + "]";
	}
	public SavingsAccountVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    
}

