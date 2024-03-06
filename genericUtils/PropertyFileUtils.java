package com.genericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class PropertyFileUtils {

	/**
	 * This Method Is Used To ReadDataFromPropertyFile
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException 
	{
		FileInputStream file=new FileInputStream(IpathConstants.Properyfilepath);
		
			Properties prob=new Properties();
			prob.load(file);
			
			String value=prob.getProperty(key);
			return value;
			
		
	}
	

	
	
	
	public String readDataFromPropertyFile1(String key) throws IOException 
	{
		FileInputStream file=new FileInputStream(IpathConstants.Properyfilepath);
		
			Properties prob=new Properties();
			prob.load(file);
			
			String value=prob.getProperty(key);
			return value;
			
		
	}
	
	
	
	public void writeDataFromPropertyFile1(String key,String value) throws IOException 
	{
		FileInputStream file=new FileInputStream(IpathConstants.Properyfilepath);
		
			Properties prob=new Properties();
			prob.load(file);
			
			prob.setProperty(key, value);
			
			FileOutputStream filw1=new FileOutputStream(IpathConstants.Properyfilepath);
			prob.store(filw1, "updated");
		
			}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

