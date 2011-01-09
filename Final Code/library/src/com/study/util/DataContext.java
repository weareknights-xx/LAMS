package com.study.util;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;


public class DataContext {
	public static String getDataContext(String data) throws UnsupportedEncodingException{
		if(data==null){
			return "";
		}else{
			data = new String(data.getBytes("iso-8859-1"),"GB18030");
			return data;
		}
	}
	public static Date getCurrentDate(){
		return new Date();
	}
}
