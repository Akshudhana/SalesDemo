package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericUtils.WebDriverUtils;

public class LoginPage extends WebDriverUtils{

	//Declaration
	@FindBy(xpath="//input[@name='user']")
	private WebElement usernameTextField;
	
	@FindBy(name="password")
	private WebElement passwordText;
	
	@FindBy(name="btnlogin")
	private WebElement loginButton;
	
	
	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//Utilization
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}


	public WebElement getPasswordText() {
		return passwordText;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//Bussiness logic
	public void login(String username,String password,WebDriver driver) {
		usernameTextField.sendKeys(username);
		passwordText.sendKeys(password);
		loginButton.click();
		System.out.println("Loged into application");
	
			
	}
	

	public void acceptAlertLoginMsg(WebDriver driver) {
		String exceptedTitle="Prince Ly Welcome!";
		String actualatitle=driver.switchTo().alert().getText();
		
     Assert.assertEquals(actualatitle, exceptedTitle, "alert is handled");
			
     acceptAlert(driver);	
	}
	
	
	public void toVerifyHomePageIsDisplaying(WebDriver driver) {
		String expectedTitle="Sales and Inventory System";
		String title=driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title, expectedTitle, "home page is displayed");
	}
	
	
	
	
}
