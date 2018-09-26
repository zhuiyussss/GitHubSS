package com.banktransfer.Util;

import java.net.URLEncoder;

import com.alibaba.fastjson.JSONArray;

public class StringUtil {
	static public String StringEncode(Object obj,String encodeFormate){
		String newString="";
			try {
				newString=URLEncoder.encode(JSONArray.toJSONString(obj),encodeFormate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return newString;
		}
}
