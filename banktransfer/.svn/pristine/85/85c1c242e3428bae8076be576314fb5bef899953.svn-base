package com.banktransfer.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.banktransfer.Entity.TransactionRecord;
import com.banktransfer.dao.Interface.TransactionRecordDao;
import com.banktransfer.dao.Support.SqlSessionFactoryTemplate;
@Component("transactionRecorddao")
public class TransactionRecordDaoImpl extends SqlSessionFactoryTemplate
		implements TransactionRecordDao {

	@Override
	public int save(TransactionRecord transactionrecord) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			count=super.CurrentSession(false).insert("com.banktransfer.Mapping.BanktransferMapper.save", transactionrecord);
			super.CurrentSession(false).commit();
		} catch (Exception e) {
			e.printStackTrace();
			super.CurrentSession(false).rollback();
		}finally{
			super.CloseSession();
		}
		return count;
	}

	@Override
	public List<TransactionRecord> findList(String cardNo,String begin, String end,
			int pageno, int pagesize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cardNo", cardNo);
		map.put("begin", begin);
		map.put("end", end);
		map.put("pageno", (pageno-1)*pagesize);
		map.put("pagesize", pagesize);
		List<TransactionRecord> list = super.CurrentSession(true)
				.selectList("com.banktransfer.Mapping.BanktransferMapper.findbetween",map);
		return list;
	}

	@Override
	public int findCount(String cardNo) {
		// TODO Auto-generated method stub
		return super.CurrentSession(true).selectOne("com.banktransfer.Mapping.BanktransferMapper.count",cardNo);
	}
	
}
