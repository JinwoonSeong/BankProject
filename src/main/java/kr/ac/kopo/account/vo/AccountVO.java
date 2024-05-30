package kr.ac.kopo.account.vo;

import java.util.Date;

public class AccountVO {
    private String account_num;
    private String customer_id;
    private String name;
    private String account_password;
    private int account_money;
    private Date open_date;
    private String bank_code;
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount_password() {
		return account_password;
	}
	public void setAccount_password(String account_password) {
		this.account_password = account_password;
	}
	public int getAccount_money() {
		return account_money;
	}
	public void setAccount_money(int account_money) {
		this.account_money = account_money;
	}
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	@Override
	public String toString() {
		return "AccountVO [account_num=" + account_num + ", customer_id=" + customer_id + ", name=" + name
				+ ", account_password=" + account_password + ", account_money=" + account_money + ", open_date="
				+ open_date + ", bank_code=" + bank_code + "]";
	}
	public AccountVO() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}
