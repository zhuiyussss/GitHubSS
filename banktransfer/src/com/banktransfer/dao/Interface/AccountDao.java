package com.banktransfer.dao.Interface;

import java.util.List;

import com.banktransfer.Entity.Account;

public interface AccountDao {
	Account findAccount(String cardNo,String password);
	Account findAccount(int id);
	Account findAccount(String cardNo);
	int update(int id,String cardNo,float transactionAmount);
	//int updatede(String cardNo,float transactionAmount);
	int updatepwd(String cardNo,String newspassword);
}
