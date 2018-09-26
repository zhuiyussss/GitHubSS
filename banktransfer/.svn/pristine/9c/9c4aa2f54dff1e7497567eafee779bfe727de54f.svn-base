package com.banktransfer.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.banktransfer.Entity.Account;
import com.banktransfer.Entity.TransactionRecord;
import com.banktransfer.dao.Interface.AccountDao;
import com.banktransfer.dao.Interface.TransactionRecordDao;
@Service("accountservice")
public class AccountService {
	@Autowired
	@Qualifier("accountdao")
//	@Resource(name="accountdao")
	private AccountDao accountdao;
	@Autowired
	@Qualifier("transactionRecorddao")
	private TransactionRecordDao transactionRecorddao;
	public TransactionRecordDao getTransactionRecorddao() {
		return transactionRecorddao;
	}

	public void setTransactionRecorddao(TransactionRecordDao transactionRecorddao) {
		this.transactionRecorddao = transactionRecorddao;
	}

	public AccountDao getAccountdao() {
		return accountdao;
	}

	public void setAccountdao(AccountDao accountdao) {
		this.accountdao = accountdao;
	}
	public Account findAccount(String cardNo,String password) {
		return accountdao.findAccount(cardNo, password);
	}
	public Account findAccount(int id) {
		return accountdao.findAccount(id);
	}
	public Account findAccount(String cardNo) {
		return accountdao.findAccount(cardNo);
	}
	public int update(int id,String cardNo, float transactionAmount){
		int count=0;
		
		try {
			if(accountdao.findAccount(cardNo)!=null){
				if(accountdao.findAccount(id).getBalance()>=transactionAmount&&accountdao.findAccount(cardNo).getStatus()==1){
					count=accountdao.update(id, cardNo, transactionAmount);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String transactionDate = sdf.format(new Date());
					String remark="转账";
					TransactionRecord transactionrecord1=new TransactionRecord(-1,accountdao.findAccount(id).getCardNo(),transactionDate,transactionAmount,accountdao.findAccount(id).getBalance(),"取款",remark);
					TransactionRecord transactionrecord2=new TransactionRecord(-1,cardNo,transactionDate,transactionAmount,accountdao.findAccount(cardNo).getBalance(),"存款",remark);
					transactionRecorddao.save(transactionrecord1);
					transactionRecorddao.save(transactionrecord2);
				}else if(accountdao.findAccount(cardNo).getStatus()==0){
					count=accountdao.findAccount(cardNo).getStatus();	
				}else if(accountdao.findAccount(cardNo).getStatus()==1&&accountdao.findAccount(id).getBalance()<transactionAmount){
					count=-2;
				}
			}else{
				count=-1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public int save(TransactionRecord transactionrecord){
		return transactionRecorddao.save(transactionrecord);
	}
	public int updatepwds(String cardNo,String password, String newspassword) {
		int count=0;
		if(accountdao.findAccount(cardNo, password)!=null){
			count=accountdao.updatepwd(cardNo, newspassword);
		}
		return count;
	}
}
