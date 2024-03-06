package sample;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) 
		{
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://www.flipkart.com/viewcart?exploreMode=true&preference=FLIPKART");
			
//		WebElement searchfeild = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
//		searchfeild.click();
//		searchfeild.sendKeys("samsung mobiles");
			//driver.findElement(By.xpath("//a[@title=\"Cart\"]/parent::div[@class='_38VF5e']"));
		List<WebElement> name = driver.findElements(By.xpath("//a[@class='_2Kn22P gBNbID']"));
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='_2-ut7f _1WpvJ7']"));
				int count=0;
		for(WebElement ref:prices)
		{
			String pri= ref.getText().replace(",","");
			Integer price1=Integer.parseInt(pri);	
			{
				System.out.println(name.get(count)+"----------->"+price1);
			}

	}
		
		}
	
}

		


