package com.ObjectRepository;

import org.checkerframework.common.initializedfields.qual.InitializedFieldsBottom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtils.WebDriverUtils;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class AccountPage extends WebDriverUtils{
	
	//Declaration
    @FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
    private WebElement userAccountPlusButton;
    
    @FindBy(xpath="//select[@name='empid']")
    private WebElement selectEmpFromDropDown;
    
    @FindBy(xpath="//form[@action='us_transac.php?action=add']/descendant::input[@name='username']")
    private WebElement addUserAccountUserTextField;
    
    @FindBy(xpath="//form[@action='us_transac.php?action=add']/descendant::input[@name='password']")
    private WebElement addUserAccountPasswordTextField;
    
    @FindBy(xpath="//form[@action='us_transac.php?action=add']/child::button[@class='btn btn-success']")
    private WebElement userAccountSaveButton;
   
    //Initialization
    public AccountPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }

    //Utilization
	public WebElement getUserAccountPlusButton() {
		return userAccountPlusButton;
	}

	public WebElement getSelectEmpFromDropDown() {
		return selectEmpFromDropDown;
	}

	public WebElement getAddUserAccountUserTextField() {
		return addUserAccountUserTextField;
	}

	public WebElement getAddUserAccountPasswordTextField() {
		return addUserAccountPasswordTextField;
	}

	public WebElement getUserAccountSaveButton() {
		return userAccountSaveButton;
	}
	
	
	//BussinessLogic
	public void addAccount(WebDriver driver,String empName,String empUserName,String Password) {
		
		HomePage home=new HomePage(driver);
		
		userAccountPlusButton.click();
		handleDropdown(empName, selectEmpFromDropDown);
		addUserAccountUserTextField.sendKeys(empUserName);
		addUserAccountPasswordTextField.sendKeys(Password);
		userAccountSaveButton.click();
		
		
	}
	
    
}
