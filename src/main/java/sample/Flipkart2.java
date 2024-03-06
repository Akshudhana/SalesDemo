package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.reactivex.rxjava3.functions.Action;

public class Flipkart2 
{
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
	 WebElement search = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
	 search.sendKeys("samsung mobiles");
	 search.click();
	 driver.findElement(By.xpath("(//span[text()='samsung mobiles'])[3]")).click();
	//	driver.findElement(By.xpath("//input[@value='samsung mobiles']")).click();
		//driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	

	 String mainwindow = driver.getWindowHandle();
	 driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy S24 Ultra 5G (Titanium Black, 256 GB)']")).click();
	 Thread.sleep(2000);
		Set<String> window = driver.getWindowHandles();
		for(String childwindow:window)
		{
			driver.switchTo().window(childwindow);
		}
	 //Actions action=new Actions(driver);
// action.scrollToElement(add).perform();
	 driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']/parent::li[@class='col col-6-12']")).click();
 WebElement phone = driver.findElement(By.xpath("//a[text()='SAMSUNG Galaxy S24 Ultra 5G (Titanium Black, 256 GB)']"));
String phoneName=phone.getText();
	 
	WebElement price = driver.findElement(By.xpath("//span[text()='1,23,499']"));
	
	driver.close();
	//System.out.println(phone.getText()+"----->"+price.getText());
//	 Thread.sleep(3000);
//	 String actualtext="Samsung Mobiles S24 Ultra- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
	Set<String> window1 = driver.getWindowHandles();
	for(String pwindow:window1)
	{
		driver.switchTo().window(pwindow);
	}
 
//	 if(actualtext.)
//	 
//	 driver.switchTo().window(mainwindow);
//	
//	 
//	 
//	

	WebElement clear=driver.findElement(By.xpath("//input[@value=\"samsung mobiles s24 ultra\"]"));
	clear.clear();
	clear.sendKeys("abc");
//	driver.switchTo().activeElement().clear() ;
//	WebElement search1 = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));

//	 search1.sendKeys("samsung mobiles");
//	 search1.click();
//	 driver.findElement(By.xpath("(//span[text()='samsung mobiles'])[3]")).click();
	
	//driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy S24 Ultra 5G (Titanium Gray, 256 GB)']")).click();
//	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
//	 
//		 driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy S24 Ultra 5G (Titanium Black, 256 GB)']")).click();
//		 driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
//		 
//	FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Flipkart.xlsx"); 
//	Workbook workbook = WorkbookFactory.create(fi);
//	Sheet sh = workbook.getSheet("Flipkart");
////	String row1 = phone.getText();
//	
//	sh.createRow(0).createCell(0).setCellValue(phoneName);
//	String cel1 = price.getText();
//	sh.getRow(0).createCell(1).setCellValue(cel1);
//	
//	FileOutputStream fout=new FileOutputStream(".\\src\\test\\resources\\Flipkart.xlsx");
//	workbook.write(fout);
//	workbook.close();
		 
	 
}
}
