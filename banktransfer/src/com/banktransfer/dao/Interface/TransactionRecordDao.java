package com.banktransfer.dao.Interface;

import java.util.List;

import com.banktransfer.Entity.TransactionRecord;

public interface TransactionRecordDao {
	int save(TransactionRecord transactionrecord);
	List<TransactionRecord> findList(String cardNo,String begin,String end,int pageno,int pagesize);
	int findCount(String cardNo);
}
