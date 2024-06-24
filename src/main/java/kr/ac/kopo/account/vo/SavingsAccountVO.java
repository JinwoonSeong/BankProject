package kr.ac.kopo.account.vo;

import java.util.Date;

public class SavingsAccountVO {
    private String savings_account_num;
    private String savings_account_password;
    public String getSavings_account_password() {
		return savings_account_password;
	}

	public void setSavings_account_password(String savings_account_password) {
		this.savings_account_password = savings_account_password;
	}

	private String customer_id;
    private String account_holder;
    private String deposit_type;
    private int amount;
    private float interest_rate;
    private Date open_date;
    private Date expiration_date;

    public String getSavings_account_num() {
        return savings_account_num;
    }

    public void setSavings_account_num(String savings_account_num) {
        this.savings_account_num = savings_account_num;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(float interest_rate) {
        this.interest_rate = interest_rate;
    }

    public Date getOpen_date() {
        return open_date;
    }

    public void setOpen_date(Date open_date) {
        this.open_date = open_date;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

   

    @Override
	public String toString() {
		return "SavingsAccountVO [savings_account_num=" + savings_account_num + ", savings_account_password="
				+ savings_account_password + ", customer_id=" + customer_id + ", account_holder=" + account_holder
				+ ", deposit_type=" + deposit_type + ", amount=" + amount + ", interest_rate=" + interest_rate
				+ ", open_date=" + open_date + ", expiration_date=" + expiration_date + "]";
	}

	public SavingsAccountVO() {
        super();
    }
}
