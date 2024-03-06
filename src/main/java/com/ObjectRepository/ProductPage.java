package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtils.WebDriverUtils;

public class ProductPage extends WebDriverUtils {

	//Declaration
	@FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement toClickOnPlusButInProduct;
	
	@FindBy(xpath="//form[@action='pro_transac.php?action=add']/descendant::input[@placeholder='Product Code']")
	private WebElement productCodeTextField;
	
	@FindBy(xpath="//form[@action='pro_transac.php?action=add']/descendant::input[@placeholder='Name']")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//form[@action='pro_transac.php?action=add']/descendant::textarea[@placeholder='Description']")
	private WebElement productDescriptionTextField;
	
	@FindBy(xpath="//form[@action='pro_transac.php?action=add']/descendant::input[@placeholder='Quantity']")
	private WebElement productQtyTextField;
	
	@FindBy(xpath="//form[@action='pro_transac.php?action=add']/descendant::input[@placeholder='On Hand']")
	private WebElement productOnHandQtyTextField;
	
	@FindBy(xpath="//form[@action='pro_transac.php?action=add']/descendant::input[@placeholder='Price']")
	private WebElement productPriceTextField;
	
	@FindBy(xpath="//form[@action='pro_transac.php?action=add']/descendant::select[@name='category']")
	private WebElement selectProductCategory;
	
	@FindBy(xpath="//form[@action='pro_transac.php?action=add']/descendant::select[@name='supplier']")
	private WebElement selectSupplierProduct;
	
	@FindBy(xpath="//form[@action='pro_transac.php?action=add']/descendant::input[@placeholder='Date Stock In']")
    private WebElement dateOfStackInProduct;
	
	@FindBy(xpath="//form[@action='pro_transac.php?action=add']/descendant::i[@class='fa fa-check fa-fw']")
     private WebElement toClickOnSaveButtonInProductModule;
	
	//Initialization
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getToClickOnPlusButInProduct() {
		return toClickOnPlusButInProduct;
	}

	public WebElement getProductCodeTextField() {
		return productCodeTextField;
	}

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getProductDescriptionTextField() {
		return productDescriptionTextField;
	}

	public WebElement getProductQtyTextField() {
		return productQtyTextField;
	}

	public WebElement getProductOnHandQtyTextField() {
		return productOnHandQtyTextField;
	}

	public WebElement getProductPriceTextField() {
		return productPriceTextField;
	}

	public WebElement getSelectProductCategory() {
		return selectProductCategory;
	}

	public WebElement getSelectSupplierProduct() {
		return selectSupplierProduct;
	}

	public WebElement getDateOfStackInProduct() {
		return dateOfStackInProduct;
	}

	public WebElement getToClickOnSaveButtonInProductModule() {
		return toClickOnSaveButtonInProductModule;
	}
	
	//BussinessLogic
	
	public void product(WebDriver drievr,String productCode,String productName,String productDesc,String productQty
 ,String productOnHandQty,String productPrice,String productCategory,String productSupplier,String productDateStockIn) {
		toClickOnPlusButInProduct.click();
		productCodeTextField.sendKeys(productCode);
		productNameTextField.sendKeys(productName);
		productDescriptionTextField.sendKeys(productDesc);
		productQtyTextField.sendKeys(productQty);
		productOnHandQtyTextField.sendKeys(productOnHandQty);
		productPriceTextField.sendKeys(productPrice);
		handleDropdown(productCategory, selectProductCategory);
		handleDropdown(productSupplier, selectSupplierProduct);
		dateOfStackInProduct.click();
		dateOfStackInProduct.sendKeys(productDateStockIn);
		//handleDropdown(productDateStockIn, dateOfStackInProduct);
		toClickOnSaveButtonInProductModule.click();
			
	}
	
//	public void toVerifyProductIsAdded() {
//		
//		 String expectedCode="AD101";
//		  
//		  if(PRODUCTCODE.equals(expectedCode)) {
//			  System.out.println("Test case pass");
//		  }
//		  else {
//			  System.out.println("Test case fail");
//		  }
//	}
	
	
	
	
	

}
