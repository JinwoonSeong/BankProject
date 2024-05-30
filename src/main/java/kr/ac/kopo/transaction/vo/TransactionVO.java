package kr.ac.kopo.transaction.vo;

import java.math.BigDecimal;
import java.sql.Date;

public class TransactionVO {
	private int transactionId;
	private String from_Account;
	public TransactionVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TransactionVO [transactionId=" + transactionId + ", from_Account=" + from_Account + ", to_Account="
				+ to_Account + ", account_Num=" + account_Num + ", transactionType=" + transactionType + ", amount="
				+ amount + ", transactionDate=" + transactionDate + ", depositorName=" + depositorName + "]";
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getFrom_Account() {
		return from_Account;
	}
	public void setFrom_Account(String from_Account) {
		this.from_Account = from_Account;
	}
	public String getTo_Account() {
		return to_Account;
	}
	public void setTo_Account(String to_Account) {
		this.to_Account = to_Account;
	}
	public String getAccount_Num() {
		return account_Num;
	}
	public void setAccount_Num(String account_Num) {
		this.account_Num = account_Num;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDepositorName() {
		return depositorName;
	}
	public void setDepositorName(String depositorName) {
		this.depositorName = depositorName;
	}
	private String to_Account;
    private String account_Num;
    private String transactionType;
    private BigDecimal amount;
    private Date transactionDate;
    private String depositorName;
   
}
