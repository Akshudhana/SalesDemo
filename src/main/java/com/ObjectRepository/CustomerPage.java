package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage{

	
	
	@FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement toClickOnPlusBtnToAddCustomerTextField;
	
	@FindBy(xpath="//div[@id='customerModal']/descendant::input[@placeholder='First Name']")
	private WebElement addCustomerFirstNameTextField;
	
	@FindBy(xpath="//div[@id='customerModal']/descendant::input[@placeholder='Phone Number']")
	private WebElement addCustomerPhoneNumberTextField;
	
	@FindBy(xpath="//div[@id='customerModal']/descendant::input[@placeholder='Last Name']")
	private WebElement addCustomerLastNameTextField;
	
	@FindBy(xpath="//div[@id='customerModal']/descendant::button[@type='submit']")
    private WebElement toClickOnCustomerSaveButton;
	
	
	
	
	
	
	//Initilization
	public CustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

    //Utilization
	
	public WebElement getToClickOnPlusBtnToAddCustomerTextField() {
		return toClickOnPlusBtnToAddCustomerTextField;
	}


	public WebElement getAddCustomerFirstNameTextField() {
		return addCustomerFirstNameTextField;
	}


	public WebElement getAddCustomerPhoneNumberTextField() {
		return addCustomerPhoneNumberTextField;
	}


	public WebElement getAddCustomerLastNameTextField() {
		return addCustomerLastNameTextField;
	}


	public WebElement getToClickOnCustomerSaveButton() {
		return toClickOnCustomerSaveButton;
	}
	
	//Bussiness Logic
	public void addCustomer(String firstName,String lastName,String phoneNumber) {
		
		toClickOnPlusBtnToAddCustomerTextField.click();
		addCustomerFirstNameTextField.sendKeys(firstName);
		addCustomerLastNameTextField.sendKeys(lastName);
		addCustomerPhoneNumberTextField.sendKeys(phoneNumber);
		toClickOnCustomerSaveButton.click();
		System.out.println("Customer added succesfully");
	}
	
}
