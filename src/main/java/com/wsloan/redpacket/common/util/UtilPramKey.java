package com.wsloan.redpacket.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 * 主键生成规则
 * 
 * @author
 *
 */
public class UtilPramKey {

	private static long orderrounds=10;

	/**
	 * 生成主键
	 * @return
	 */
	public static String getPriamKey(){
	    long rounds1=runOrderInfo();
		String key = getDefaultTime()+String.valueOf(rounds1);
		return key;
	}


	private static synchronized long runOrderInfo(){

		if(orderrounds>=99){

			orderrounds=10;
		}else{
			orderrounds++;
		}
		return orderrounds;
	}


	/**
	 * 时间缀 yyyyMMddHHmmss
	 * 
	 * @return
	 */
	private static String getDefaultTime(){
		String default_parent="yyyyMMddHHmmss";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(default_parent);
		String date=formatter.format(cal.getTime());
		return date;
	}

	
	public static void main(String[]a){
		System.out.println("生成主键:"+getPriamKey());
	}
	
}
