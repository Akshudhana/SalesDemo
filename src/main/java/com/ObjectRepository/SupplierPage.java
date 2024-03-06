package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtils.WebDriverUtils;

public class SupplierPage extends WebDriverUtils{
	//Declaration
    @FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
    private WebElement toClickOnSupplierMoulePlusButton;
  
    @FindBy(xpath="//form[@action='sup_transac.php?action=add']/descendant::input[@placeholder='Company Name']")
    private WebElement supplierCompanyNameTextField;
   
    @FindBy(xpath="//form[@action='sup_transac.php?action=add']/descendant::select[@placeholder='Province']")
    private WebElement selectSupplierProvinceTextField;
    
    @FindBy(xpath="//form[@action='sup_transac.php?action=add']/descendant::select[@id='city']")
    private WebElement selectSupplierCityTextField;
    
    @FindBy(xpath="//form[@action='sup_transac.php?action=add']/descendant::input[@placeholder='Phone Number']")
    private WebElement supplierPhoneTextField;
    
    @FindBy(xpath="//form[@action='sup_transac.php?action=add']/child::button[@class='btn btn-success']")
    private WebElement toClickOnSaveButtonInsupplier;
    
    //Initialization
    public SupplierPage(WebDriver driver) {
    	PageFactory.initElements(driver,this);
    }

  //Utilization
	public WebElement getToClickOnSupplierMoulePlusButton() {
		return toClickOnSupplierMoulePlusButton;
	}

	public WebElement getSupplierCompanyNameTextField() {
		return supplierCompanyNameTextField;
	}

	public WebElement getSelectSupplierProvinceTextField() {
		return selectSupplierProvinceTextField;
	}

	public WebElement getSelectSupplierCityTextField() {
		return selectSupplierCityTextField;
	}

	public WebElement getSupplierPhoneTextField() {
		return supplierPhoneTextField;
	}

	public WebElement getToClickOnSaveButtonInsupplier() {
		return toClickOnSaveButtonInsupplier;
	}
    
    //BussinessLogic
	public void supplier(WebDriver driver,String supCompanyName,String supProvince,String supCity,String supPhoneNum) throws InterruptedException {
		
		toClickOnSupplierMoulePlusButton.click();
		supplierCompanyNameTextField.sendKeys(supCompanyName);
		handleDropdown(supProvince, selectSupplierProvinceTextField);
		handleDropdown(supCity, selectSupplierCityTextField);
		supplierPhoneTextField.sendKeys(supPhoneNum);
		Thread.sleep(2000);
		toClickOnSaveButtonInsupplier.click();
		
		
	}
    
    
    






}
