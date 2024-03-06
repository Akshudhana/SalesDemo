package sample;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class flip 
{
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
	 WebElement search = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
	 search.sendKeys("samsung mobiles");
	 search.click();
	 driver.findElement(By.xpath("(//span[text()='samsung mobiles'])[3]")).click();
	 String mainwindow = driver.getWindowHandle();
	 driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy S24 Ultra 5G (Titanium Black, 256 GB)']")).click();
	 Thread.sleep(2000);
		Set<String> window = driver.getWindowHandles();
		for(String childwindow:window)
		{
			driver.switchTo().window(childwindow);
		}
		 driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']/parent::li[@class='col col-6-12']")).click();
		 WebElement phone = driver.findElement(By.xpath("//a[text()='SAMSUNG Galaxy S24 Ultra 5G (Titanium Black, 256 GB)']"));
			 
			WebElement price = driver.findElement(By.xpath("//span[text()='1,23,499']"));
			all_windows = driver.window_handles

					# Switch control to the parent window
					parent_window = all_windows[0]
					driver.switch_to.window(parent_window)
}
}
