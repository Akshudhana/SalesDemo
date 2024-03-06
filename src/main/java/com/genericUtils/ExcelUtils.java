package com.genericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelUtils {
/**
 * This Methods is used to write data to the Excel
 * @param sheetName
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readDataFromExcel(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream(IpathConstants.ExcePath);
		Workbook wb = WorkbookFactory.create(file);
		String value=wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		
		return value;
	}
	
	/**
	 * This method is used to get the lastRawCount of excel
	 * @param sheet
	 * @return 
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public  static String[][] getLatRowNum(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream(IpathConstants.ExcePath);
		Workbook wb = WorkbookFactory.create(file);
	//int rowCount=wb.getSheet(sheet).getLastRowNum();
       Sheet sheet1 = wb.getSheet(sheet);  
       int rowCount=sheet1.getLastRowNum();
       int CELLCoun = sheet1.getRow(0).getLastCellNum();
       String[][] value1=new String[rowCount][CELLCoun];
     for(int i=0; i<rowCount;i++) {
//    	 short cell = sheet1.getRow(i).getLastCellNum();
//    	 value1[i]=new String[cell];
    	 for(int j=0; j<CELLCoun; i++) {
    		  Row value = sheet1.getRow(i);
    		  Cell cell1 = value.getCell(j);
    		   value1[i][j] = cell1.getStringCellValue();
    		   
    		       	 }
    	     }
     return value1;

   
	}
	
	
	/**
	 * This method is used to Write the data in excel
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream(IpathConstants.ExcePath);
		Workbook wb = WorkbookFactory.create(file);
		wb.getSheet(sheetName).createRow(row).createCell(cell);
		
		FileOutputStream fILEOUT=new FileOutputStream(IpathConstants.ExcePath);
		  wb.write(fILEOUT);
		wb.close();
		
	}
	/**
	 * This method is used to get data from Excel using Hashmap
	 * @param sheetName
	 * @param cell
	 * @param driver
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public HashMap<String, String> readMultipleData(String sheetName,int cell,WebDriver driver) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream(IpathConstants.ExcePath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		//int rowCount1=sheet.getPhysicalNumberOfRows();
		
		HashMap<String, String> hashmap = new HashMap<String, String>();
			
			for(int i=0; i<=rowCount; i++) {
				
				String key=sheet.getRow(i).getCell(cell).getStringCellValue();
				String value=sheet.getRow(i).getCell(cell+1).getStringCellValue();
			
				hashmap.put(key, value);
		}
		return hashmap;
			// for(Entry<String, String> set:hashmap.entrySet()) 
			//{
				//	driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		
		//}
	}
	
	
	public Object[][] excelDataFromDataProvider( String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream(".\\src\\test\\resources\\ReadingData.xlsx");
		Workbook wb=WorkbookFactory.create(file);
		Sheet sheet=wb.getSheet(sheetname);
		int rowNum=sheet.getLastRowNum()+1;
		int cellNum=sheet.getRow(0).getLastCellNum();
		
		Object[][] object = new Object[rowNum][cellNum];
		
		for(int i=0; i<rowNum; i++)
		{
			for(int j=0; j<cellNum; j++) {
				object[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return object;
			}
	
}
