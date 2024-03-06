package com.genericUtils;

import java.io.IOException;
import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ObjectRepository.LoginPage;
import com.ObjectRepository.LogoutPage;

public class BaseClass {
   
	public DataBaseUtils databaseUtils=new DataBaseUtils();
	//Why AccessSpecifier is public means this method we have to use it in different Package that's why
	public PropertyFileUtils propertFileUtils=new PropertyFileUtils();
	public ExcelUtils excelUtils=new ExcelUtils();
	public JavaUtils javaUtils=new JavaUtils();
	public WebDriverUtils webDriverUtils=new WebDriverUtils();
	public static WebDriver driver;
	
	
	//@BeforeSuite(groups= {"smokeSuit","regresionSuit"})
	        //OR
	@BeforeSuite(alwaysRun = true)
	//if we are not getting javaAnotation go to pom.xml in testNg dependencies remove scope
	public void connectDB() throws SQLException {
		databaseUtils.connectDataBase(); //SqlException
		System.out.println("BC---connect to db---");
		//Reporter.log("---connect to db---",true);
		//if we use this reporter.log means in report also it print printing statement and true if we are using means in console and in report also we will get printing statement	
	}
	
	
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void launchTheBrowser() throws IOException {
		String BROWSER=propertFileUtils.readDataFromPropertyFile("browser"); //IOException
		String URL=propertFileUtils.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) 
		{
			driver=new ChromeDriver(); 
		}
		
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else {
			System.out.println("---Invalid Browser");
		}
		
		//Maximize the browser
		webDriverUtils.maximizeBrowser(driver);
		
		//enter Url
		driver.get(URL);
		
		//wait for page load
		webDriverUtils.implicitlyWait_waitforPageLoad(driver, 10);
		
		Reporter.log("BC--Browser is launched--");
		
		System.out.println("BC--Browser is launched--");
	}
	  
	    
	    @BeforeMethod(alwaysRun = true)
	    public void loginToApp() throws IOException {
	    	
	    	String USERNAME=propertFileUtils.readDataFromPropertyFile("username");
	    	String PASSWORD=propertFileUtils.readDataFromPropertyFile("password");
		
		 LoginPage login=new LoginPage(driver);
		 login.login(USERNAME, PASSWORD, driver);
		 login.acceptAlertLoginMsg(driver);
		 login.toVerifyHomePageIsDisplaying(driver);
		 
         System.out.println("BC--loged into application--");	
	}
	
	    @AfterMethod(alwaysRun = true)
	    public void logoutToApp() {
	    	LogoutPage logout=new LogoutPage(driver);
	    	logout.logout();
	    	logout.logoutMsgPopupAdmin();
	    	
	    	//System.out.println("BC--logged out from application---");
	    }
	    
	    @AfterClass(alwaysRun = true)
	    public void closeBrowser() {
	    	driver.quit();
	    	System.out.println("BC--Browser Closed---");
	    }
	    
	    @AfterSuite(alwaysRun = true)
	    public void closeDB() throws SQLException {
	    	databaseUtils.disconnectDataBase();
	    	System.out.println("BC--Disconnected from DB--");
	    }
	
}
