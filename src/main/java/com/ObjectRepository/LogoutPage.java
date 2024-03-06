package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class LogoutPage {
     
	//Declaration
	@FindBy(xpath="//img[@class='img-profile rounded-circle']")
	private WebElement toClickOnLogoutImg;
	
	@FindBy(xpath="//i[@class='fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400']")
	private WebElement toClickOnLogoutButton;
	
	@FindBy(xpath="//div[@aria-modal='true']/descendant::a[text()='Logout']")
	private WebElement toClickOnLogoutPopup;
	
	@FindBy(xpath="//div[@id='logoutModal' and @class='modal fade show']/descendant::div[text()='Prince Ly are you sure do you want to logout?']")
	private WebElement toGetLogoutPopupAdminMsg;
	
	
	@FindBy(xpath="//div[@id='logoutModal' and @class='modal fade show']/descendant::div[text()='dhana are you sure do you want to logout?']")
	private WebElement toGetLogoutPopupEmpMsg;
			//Initialization
	

	public WebElement getToGetLogoutPopupAdminMsg() {
		return toGetLogoutPopupAdminMsg;
	}

	public WebElement getToGetLogoutPopupEmpMsg() {
		return toGetLogoutPopupEmpMsg;
	}

	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getToClickOnLogoutImg() {
		return toClickOnLogoutImg;
	}

	public WebElement getToClickOnLogoutButton() {
		return toClickOnLogoutButton;
	}

	public WebElement getToClickOnLogoutPopup() {
		return toClickOnLogoutPopup;
	}
	
	public WebElement getToGetLogoutPopupMsg() {
		return toGetLogoutPopupAdminMsg;
	}
	
	//BussinessLogic
	public void logout() {
		toClickOnLogoutImg.click();
		toClickOnLogoutButton.click();
		
	}
	
	public void logoutMsgPopupAdmin() {
		String actualLogoutText=toGetLogoutPopupAdminMsg.getText();
		String expectedLogoutText="Prince Ly are you sure do you want to logout?";
		if(expectedLogoutText.contains(actualLogoutText)){
			System.out.println("logout to the Application as a admin");
		}
		else {
			System.out.println("deos't loged out");
		}	
		toClickOnLogoutPopup.click();
	}
	
	
	public void logoutMsgPopUpForEmp() {
		String actualLogoutText=toGetLogoutPopupEmpMsg.getText();
	System.out.println();
		String expectedLogoutText="dhana are you sure do you want to logout?";
		if(expectedLogoutText.contains(actualLogoutText)){
			System.out.println("loged out the Application as a employee");
		}
		else {
			System.out.println("deos't loged out");
		}	
		toClickOnLogoutPopup.click();
	}
	}
	
	

