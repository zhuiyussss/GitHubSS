package com.banktransfer.dao.Impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.banktransfer.Entity.Account;
import com.banktransfer.dao.Interface.AccountDao;
import com.banktransfer.dao.Support.SqlSessionFactoryTemplate;

@Component("accountdao")
public class AccountDaoImpl extends SqlSessionFactoryTemplate implements
		AccountDao {

	@Override
	public Account findAccount(String cardNo,String password) {
		// TODO Auto-generated method stub
		Account account=null;
		try {
			account=super.CurrentSession(true).selectOne("com.banktransfer.Mapping.BanktransferMapper.findAccount",new Account(cardNo,password));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.CloseSession();
		}
		return account;
	}

	@Override
	public Account findAccount(int id) {
		// TODO Auto-generated method stub
		Account account=null;
		try {
			account=super.CurrentSession(true).selectOne("com.banktransfer.Mapping.BanktransferMapper.findid",id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.CloseSession();
		}
		return account;
	}

	@Override
	public int update(int id,String cardNo, float transactionAmount) {
		// TODO Auto-generated method stub
		int count=0;
		int counts=0;
		try {
			count=super.CurrentSession(false).update("com.banktransfer.Mapping.BanktransferMapper.update",new Account(id,(this.findAccount(id).getBalance()-transactionAmount)));
			counts=super.CurrentSession(false).update("com.banktransfer.Mapping.BanktransferMapper.updates",new Account(cardNo,(this.findAccount(cardNo).getBalance()+transactionAmount)));
			CurrentSession(false).commit();
		} catch (Exception e) {
			e.printStackTrace();
			CurrentSession(false).rollback();
		}finally{
			super.CloseSession();
		}
		return count+counts;
	}

	@Override
	public Account findAccount(String cardNo) {
		// TODO Auto-generated method stub
		Account account=null;
		try {
			account=super.CurrentSession(true).selectOne("com.banktransfer.Mapping.BanktransferMapper.findca",cardNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			super.CloseSession();
		}
		return account;
	}

	@Override
	public int updatepwd(String cardNo, String newspassword) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			count=super.CurrentSession(false).update("com.banktransfer.Mapping.BanktransferMapper.updatepassword",new Account(cardNo,newspassword));
			super.CurrentSession(false).commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			super.CurrentSession(false).rollback();
		}finally{
			super.CloseSession();
		}
		return count;
	}

}
