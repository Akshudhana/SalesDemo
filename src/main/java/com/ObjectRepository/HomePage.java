package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	 //Declaration
	@FindBy(xpath="//span[text()='Employee']")
	private WebElement toclickOnemployeeModule;
	
	@FindBy(xpath="//span[text()='Customer']")
	private WebElement toclickOncustomerModule;
	
	@FindBy(xpath="//span[text()='Supplier']")
	private WebElement toclickOnsupplier; 
	
	@FindBy(xpath="//span[text()='Product']")
	private WebElement toclickOnproduct;
	
	@FindBy(xpath="//span[text()='Transaction']")
	private WebElement toclickOnTransaction;
	
	@FindBy(xpath="//span[text()='Inventory']")
	private WebElement toclickOnInventory;
	
	@FindBy(xpath="//span[text()='Accounts']")
	private WebElement toClickOnAccount;
	
	@FindBy(xpath="//span[text()='Prince Ly Cesar']")
	private WebElement toclickOnPrinceLyCesar;
	
	@FindBy(xpath="//span[text()='POS']")
	private WebElement toClickOnPos;
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	
	public WebElement getToClickOnPos() {
		return toClickOnPos;
	}
	public WebElement getToclickOnemployeeModule() {
		return toclickOnemployeeModule;
	}

	public WebElement getToclickOncustomerModule() {
		return toclickOncustomerModule;
	}

	public WebElement getToclickOnsupplier() {
		return toclickOnsupplier;
	}

	public WebElement getToclickOnproduct() {
		return toclickOnproduct;
	}

	public WebElement getToclickOnTransaction() {
		return toclickOnTransaction;
	}

	public WebElement getToclickOnInventory() {
		return toclickOnInventory;
	}

	public WebElement getToClickOnAccount() {
		return toClickOnAccount;
	}

	public WebElement getToclickOnPrinceLyCesar() {
		return toclickOnPrinceLyCesar;
	}
	
	//BussinessLogic
	public void toClickOnPos() {
		toClickOnPos.click();	
	}
	
	public void toclickOnemployeeModule() {
		toclickOnemployeeModule.click();
	}
	
	public void toclickOncustomerModuleInHomePage() {
		toclickOncustomerModule.click();
	}
	
	public void toclickOnsupplier() {
		toclickOnsupplier.click();
	}
	
	public void toclickOnproduct() {
		toclickOnproduct.click();
	}
	
	public void toclickOnTransaction() {
		toclickOnTransaction.click();
	}
	
	public void toclickOnInventory() {
		toclickOnInventory.click();
	}
	
	public void toClickOnAccount() {
		toClickOnAccount.click();
	}
	
	public void toclickOnPrinceLyCesar() {
		toclickOnPrinceLyCesar.click();	
	}
}
