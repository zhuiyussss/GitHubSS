package com.banktransfer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.banktransfer.Entity.TransactionRecord;
import com.banktransfer.dao.Interface.TransactionRecordDao;

@Service("transactionrecordservice")
public class TransactionRecordService {
	@Autowired
	@Qualifier("transactionRecorddao")
	private TransactionRecordDao transactionRecorddao;

	public TransactionRecordDao getTransactionRecorddao() {
		return transactionRecorddao;
	}

	public void setTransactionRecorddao(TransactionRecordDao transactionRecorddao) {
		this.transactionRecorddao = transactionRecorddao;
	}
	public List<TransactionRecord> findList(String cardNo,String begin, String end,
			int pageno, int pagesize) {
		List<TransactionRecord> list=null;
		if(transactionRecorddao.findList(cardNo,begin, end, pageno, pagesize)!=null){
			list=transactionRecorddao.findList(cardNo,begin, end, pageno, pagesize);
		}
		return list;
	}
	public int findCount(String cardNo) {
		return transactionRecorddao.findCount(cardNo);
	}
}
