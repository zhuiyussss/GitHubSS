package com.banktransfer.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.banktransfer.Util.StringUtil.StringEncode;

import com.banktransfer.Entity.TransactionRecord;
import com.banktransfer.Service.AccountService;

@Controller
@RequestMapping(value={"/account"})
public class AccountController {
	@Autowired
	@Qualifier("accountservice")
	private AccountService accountservice;

	public AccountService getAccountservice() {
		return accountservice;
	}
	
	public void setAccountservice(AccountService accountservice) {
		this.accountservice = accountservice;
	}
	@RequestMapping(value={"/accounts"},method=RequestMethod.POST)
	@ResponseBody
	public Object findAccount(String cardNo,String password){
		return StringEncode(accountservice.findAccount(cardNo, password), "utf-8");
	}
	@RequestMapping(value={"/accountid"},method=RequestMethod.POST)
	@ResponseBody
	public Object findid(int id){
		return StringEncode(accountservice.findAccount(id), "utf-8");
	}
	@RequestMapping(value={"/accountupdate"},method=RequestMethod.POST)
	@ResponseBody
	public Object updade(int id,String cardNo, float transactionAmount){
		
		Object obj=StringEncode(accountservice.update(id, cardNo, transactionAmount), "utf-8");
		return obj;
	}
	@RequestMapping(value={"/accountupdatepwd"},method=RequestMethod.POST)
	@ResponseBody
	public Object updadepwdss(String cardNo, String password,String newspassword){
		Object obj=StringEncode(accountservice.updatepwds( cardNo,password,newspassword), "utf-8");
		return obj;
	}
}
