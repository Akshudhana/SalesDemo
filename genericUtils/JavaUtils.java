package com.genericUtils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
/**
 * This method is used to append the RandomNumber
 * @author Administrator
 * @return
 */
	public int getRndomNUM() {
		Random ran=new Random();
		int ramdow=ran.nextInt(500);
		return ramdow;
	}
	
	/**
	 * This method is used to get systemDate
	 * @return
	 */
	public String getSystemData() {
		Date date=new Date();
		String date1=date.toString();
		return date1;
	}
	
	
	/**
	 * This method is used to get systemDateInFormate
	 * @return
	 */
	public String getSystemDataInFormat() {
		SimpleDateFormat dateFormate=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss") ;	
		Date date=new Date();
		String date1=dateFormate.format(date);
		return date1;
		}
	}

