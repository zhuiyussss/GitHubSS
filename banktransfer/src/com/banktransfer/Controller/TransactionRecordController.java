package com.banktransfer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import static com.banktransfer.Util.StringUtil.StringEncode;
import com.banktransfer.Entity.TransactionRecord;
import com.banktransfer.Service.TransactionRecordService;

@Controller
@RequestMapping(value={"/transactionrecord"})
public class TransactionRecordController {
	@Autowired
	@Qualifier("transactionrecordservice")
	private TransactionRecordService transactionrecordservice;
	
	public TransactionRecordService getTransactionrecordservice() {
		return transactionrecordservice;
	}

	public void setTransactionrecordservice(
			TransactionRecordService transactionrecordservice) {
		this.transactionrecordservice = transactionrecordservice;
	}

	@RequestMapping(value={"/transactionrecordfind"},method=RequestMethod.POST)
	@ResponseBody
	public Object findList(String cardNo,String begin, String end,
			int pageno, int pagesize){
		return StringEncode(transactionrecordservice.findList(cardNo,begin, end, pageno, pagesize), "utf-8");
	}
	@RequestMapping(value={"/transactionrecordcount"},method=RequestMethod.POST)
	@ResponseBody
	public Object findcount(String cardNo){
		return StringEncode(transactionrecordservice.findCount(cardNo), "utf-8");
	}
}
