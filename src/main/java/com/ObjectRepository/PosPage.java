package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtils.WebDriverUtils;

public class PosPage extends WebDriverUtils{

	@FindBy(xpath="//a[text()='Keyboard']")
	private WebElement toSelectProductCategoryInPos;
	
	@FindBy(xpath="//form[@action='pos.php?action=add&id=391']/descendant::input[@class='btn btn-info']")
	private WebElement toSelectProductInPos;
	
	@FindBy(xpath="//h4[text()='Point of Sale']")
	private WebElement toVerifyThatPosPageIsDisplaying;
	
	@FindBy(xpath="//select[@name='customer']")
	private WebElement toSelectCustomerFromDropDown;
	
	@FindBy(xpath="//button[@class='btn btn-block btn-success']")
	private WebElement toClickOnSubmitButtonInPOS;
	
	
	@FindBy(xpath="//input[@class='form-control text-right']")
	private WebElement toClickOnEnterCashInPOS;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-block']")
	private WebElement proceedToPaymentInPos;
	
	//Initialization
	
	public PosPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getToSelectProductCategoryInPos() {
		return toSelectProductCategoryInPos;
	}

	public WebElement getToSelectProductInPos() {
		return toSelectProductInPos;
	}

	public WebElement getToVerifyThatPosPageIsDisplaying() {
		return toVerifyThatPosPageIsDisplaying;
	}

	public WebElement getToSelectCustomerFromDropDown() {
		return toSelectCustomerFromDropDown;
	}

	public WebElement getToClickOnSubmitButtonInPOS() {
		return toClickOnSubmitButtonInPOS;
	}

	public WebElement getToClickOnEnterCashInPOS() {
		return toClickOnEnterCashInPOS;
	}

	public WebElement getProceedToPaymentInPos() {
		return proceedToPaymentInPos;
	}
	
	//BussinessLogic
	public void posModule() {
		toSelectProductCategoryInPos.click();
		toSelectProductInPos.click();
		
	}
	
	public void toCheckPosPageIsDisplaying(WebDriver driver,int index,String productprice) {
		String actualText=toVerifyThatPosPageIsDisplaying.getText();
		String expactedText="Point of Sale";
		if(actualText.equalsIgnoreCase(expactedText)) {
			System.out.println("Pos page is displaying");
		}
		else {
			System.out.println("Pos page is not displaying");
		}
		//handleDropdown(toSelectCustomerFromDropDown, );
		handleDropdown(toSelectCustomerFromDropDown, index);
		toClickOnSubmitButtonInPOS.click();
		toClickOnEnterCashInPOS.sendKeys(productprice);
		proceedToPaymentInPos.click();
		acceptAlert(driver);
	}
	
	
}
