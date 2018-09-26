package com.banktransfer.Entity;

public class Account {
	private int id;
	private String cardNo;
	private String password;
	private float balance;
	private int status;
	public Account(String cardNo, float balance) {
		super();
		this.cardNo = cardNo;
		this.balance = balance;
	}
	public Account(int id, float balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	public Account(String cardNo, String password) {
		super();
		this.cardNo = cardNo;
		this.password = password;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String cardNo, String password, float balance, int status) {
		super();
		this.cardNo = cardNo;
		this.password = password;
		this.balance = balance;
		this.status = status;
	}
	public Account(int id, String cardNo, String password, float balance,
			int status) {
		super();
		this.id = id;
		this.cardNo = cardNo;
		this.password = password;
		this.balance = balance;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
