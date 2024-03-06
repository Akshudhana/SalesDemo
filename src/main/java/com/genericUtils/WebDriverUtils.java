package com.genericUtils;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.DStarRunner.DStarAlgorithmEnum;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

	//Popup
		/**
		 * This method is used to handle alert
		 * @param driver
		 */
		public void acceptAlert(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
	
		/**
		 * This method is used to cancel(dismiss) alert
		 * @param driver
		 */
		public void cancelAlert(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		
		
	/**
	 * This method Is Used To Get Alert Text 
	 * @param driver
	 * @param expectedmsg
	 */
	public void gettextalert(WebDriver driver,String expectmsg)
	{
		String alerttext = driver.switchTo().alert().getText();
		if(alerttext.contains(expectmsg)) {
			System.out.println("------alert is handeled----");
		}
		else
		{
			System.out.println("------alert is not handeled----");
		}	
	}
	
	/**
	 * This Method Is  Used to Maximize The Browser
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This Method Is  Used to Minimize The Browser
	 * @param driver
	 */
	public void minimizeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	
	//implicitly wait
	/**
	 * implicitlyWait mathos
	 * @param driver
	 * @param sec
	 */
	public void implicitlyWait_waitforPageLoad(WebDriver driver,int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	
	//Explicitly wait Object
	public WebDriverWait explicitlyWait_webDriverWaitObj(WebDriver driver,int sec) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		return wait;
	}
	
	/**
	 * Explicitlywait_waitUntilElementToBeVisible
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitUntilElementToBeVisible(WebDriver driver,int sec,WebElement element) {
		explicitlyWait_webDriverWaitObj(driver, sec).until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * Explicitlywait_waitUntilElementToBeClickable
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitUntilElementToBeClickable(WebDriver driver,int sec,WebElement element) {
		explicitlyWait_webDriverWaitObj(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Explicitlywait_waitUntilalertisPresent
	 * @param driver
	 * @param sec
	 */
	public void waitUntilalertisPresent(WebDriver driver,int sec) {
		explicitlyWait_webDriverWaitObj(driver, sec).until(ExpectedConditions.alertIsPresent());
	}
	
	//Action class
	
	/**
	 * Actions Class Object
	 * @param driver
	 * @return
	 */
	public Actions actionClassObj(WebDriver driver) {
		Actions action=new Actions(driver);
		return action;
	}
	
	//**This Method Is  Used to Do KeyboarAction Of DragAndDrop
	public void dragAndDrop(WebDriver driver,WebElement scr,WebElement des) {
		actionClassObj(driver).dragAndDrop(scr, des).perform();
	}
	
	/**
	 * This Method Is  Used to Do KeyboarAction Click
	 * @param driver
	 * @param element
	 */
	public void mouseHoveronEle(WebDriver driver,WebElement element) {
		actionClassObj(driver).click(element).perform();
		//actionClassObj(driver).moveToElement(element).perform();
		
		//Instead of created obj() directly we can use 
		//Actions action=new Actions(driver);
		//action.moveToElement(element).perform();
	}
	
	/**
	 * This Method Is  Used to Do KeyboarAction rightClickOnWebEle
	 * @param driver
	 * @param element
	 */
	public void rightClickOnWebEle(WebDriver driver,WebElement element) {
		actionClassObj(driver).contextClick(element).perform();
	}
	
	/**
	 * This Method Is  Used to Do KeyboarAction rightClickOnWebPage
	 * @param driver
	 */
	public void rightClickOnWebPage(WebDriver driver) {
		actionClassObj(driver).contextClick().perform();
	}
	
	
	/**
	 * doubleClick Action on WebElement
	 * @param driver
	 * @param element
	 */
	public void doubleClickonElement(WebDriver driver,WebElement element) {
		actionClassObj(driver).doubleClick(element);
	}
	
	
	/**
	 * doubleClick Action on WebPage
	 * @param driver
	 */
	public void doubleClickonWebPage(WebDriver driver) {
		actionClassObj(driver).doubleClick().perform();
	}
	
	/**
	 * enterKey Action 
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver) {
		actionClassObj(driver).sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * Move Action by Using x and y Axis
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void moveByOffset(WebDriver driver,int x,int y) {
		actionClassObj(driver).moveByOffset(x, y);
	}
	

	//Select class 
	
	/**
	 * Select class Object Creation method
	 * @param element
	 * @return 
	 * @return
	 */
	public Select selectClassOBJ(WebElement element) {
		Select select=new Select(element);
		return select;
		
	}
	
	/**
	 * To handle Drop down in select class By using Index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index) {
		selectClassOBJ(element).selectByIndex(index);
	}
	
	/**
	 * To handle Drop down in select class By using Value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element,String value) {
		selectClassOBJ(element).selectByValue(value);
	}
	
	
	/**
	 * To handle Drop down in select class By using VisibleText
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text,WebElement element) {
		selectClassOBJ(element).selectByVisibleText(text);
		
	}
	
	//Switch to
	
	/**
	 * This Method Is  Used to switch Control To one Window to another Window
	 * @param driver
	 * @param expectedtitle
	 */
	public void switchToWindow(WebDriver driver,String expectedtitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> iterator = window.iterator();
		while(iterator.hasNext()) {
			String next=iterator.next();
			String currentTitle=driver.switchTo().window(next).getTitle();
			
			if(currentTitle.contains(expectedtitle)) {
				break;
			}
		}
	}
	
	/**
	 * This Method Is  Used to switch Control To frame By Using Index
	 * @param driver
	 * @param index
	 */
	public void switchToframeIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This Method Is  Used to switch Control To frame By Using Name or ID
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToframeByNameorID(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This Method Is  Used to switch Control To frame By Using WebElement
	 * @param driver
	 * @param address
	 */
	public void switchToframeByWebElement(WebDriver driver,WebElement address) {
		driver.switchTo().frame(address);
	}
	
	
	
	
	
	public String takeSceenShot(WebDriver driver,String screenshotname) throws IOException {
		JavaUtils java=new JavaUtils();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=".\\Screenshot\\"+screenshotname+java.getSystemDataInFormat()+".png";
		File destination=new File(path);
		String scrPath=destination.getAbsolutePath();
		FileUtils.copyFile(src, destination);
		return scrPath;
	}
	
	/**
	 * This Method Is  Used to scroll WebPage By Using Element In JavaScript
	 * @param driver
	 * @param address
	 */
	public void scrollByElementUsingJavaScrip(WebDriver driver,WebElement address) {
		JavascriptExecutor java=(JavascriptExecutor)driver;
		java.executeScript("argument[0].ScrollIntoView();", address);
	}
	
}
