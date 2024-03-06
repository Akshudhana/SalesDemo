package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

	//Declaration
	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	private WebElement toClicOnSearchTextFieldInInventory;
	
	//Initialization
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getToClicOnSearchTextFieldInInventory() {
		return toClicOnSearchTextFieldInInventory;
	}
	
	//BussinessLogic
	public void toVerifyAddedProductIsDisplayingInInventory(String PRODUCTCODE) {
		
		 String expectedCode="AD101";
		  
		  if(PRODUCTCODE.equals(expectedCode)) {
			  System.out.println("Test case pass");
		  }
		  else {
			  System.out.println("Test case fail");
		  }
	}
	
	
}
