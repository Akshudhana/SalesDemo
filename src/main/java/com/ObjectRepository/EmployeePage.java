package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtils.JavaUtils;
import com.genericUtils.WebDriverUtils;

public class EmployeePage extends WebDriverUtils{
     
	//Declaration
	@FindBy(xpath="//i[@class='fas fa-fw fa-plus']")
	private WebElement toClickOnPlusBtnInToAddEmployee;
	
	@FindBy(xpath="//div[@id='employeeModal']/descendant::input[@placeholder='First Name']")
	private WebElement empFirstNameTextField;
	
	@FindBy(xpath="//form[@action='emp_transac.php?action=add']/descendant::input[@name='lastname']")
	private WebElement empLastNameTextField;
	
    @FindBy(xpath="//form[@action='emp_transac.php?action=add']/descendant::select[@name='gender']")
    private WebElement toSelectEmpGenderTextField;

   @FindBy(xpath="//form[@action='emp_transac.php?action=add']/descendant::input[@name='phonenumber']")
   private WebElement empPhoneTextField;
   
   @FindBy(xpath="//form[@action='emp_transac.php?action=add']/descendant::input[@name='email']")
   private WebElement empEmailTextField;
   
   @FindBy(xpath="//form[@action='emp_transac.php?action=add']/descendant::select[@name='jobs']")
   private WebElement toSelectEmpJobFromDropDown;
   
   @FindBy(xpath="//input[@id='FromDate']")
   private WebElement toSelectEmpHireddateFromDropDown;
   
   @FindBy(xpath="//form[@action='emp_transac.php?action=add']/descendant::select[@name='province']")
   private WebElement toSelectEmpProvinceFromDropDown;
   
   @FindBy(xpath="//div[@id='employeeModal']/descendant::select[@id='city']")
   private WebElement toSelectEmpCityFromDropDown;
   
   @FindBy(xpath="//div[@id='employeeModal']/descendant::button[@type='submit']")
   private WebElement toClickOnSaveBtnInEmpModule;
   
  
   
  
   
   //Initialization
   
   public EmployeePage(WebDriver driver) {
	   PageFactory.initElements(driver, this);
   }
 //utilization
    public WebElement getToClickOnPlusBtnInToAddEmployee() {
	return toClickOnPlusBtnInToAddEmployee;
    }

    public WebElement getEmpFirstNameTextField() {
	return empFirstNameTextField;
    }

    public WebElement getEmpLastNameTextField() {
	return empLastNameTextField;
    }

    public WebElement getToSelectEmpGenderTextField() {
	return toSelectEmpGenderTextField;
    }

    public WebElement getEmpPhoneTextField() {
	return empPhoneTextField;
    }

    public WebElement getEmpEmailTextField() {
	return empEmailTextField;
    }

    public WebElement getToSelectEmpJobFromDropDown() {
	return toSelectEmpJobFromDropDown;
    }

    public WebElement getToSelectEmpHireddateFromDropDown() {
	return toSelectEmpHireddateFromDropDown;
    }

    public WebElement getToSelectEmpProvinceFromDropDown() {
	return toSelectEmpProvinceFromDropDown;
    }

    public WebElement getToSelectEmpCityFromDropDown() {
	return toSelectEmpCityFromDropDown;
    }

    public WebElement getToClickOnSaveBtnInEmpModule() {
	return toClickOnSaveBtnInEmpModule;
    }
    
   
   
   //BussinessLogic
    public void addemployee(WebDriver driver,String firstName,String lastName,String gender
    		, String email,String phoneNumber,String job,String hiredate,String province,String city) {
    	
    	JavaUtils java=new JavaUtils();
    	HomePage home=new HomePage(driver);
    	
    	toClickOnPlusBtnInToAddEmployee.click();
    	empFirstNameTextField.sendKeys(firstName);
    	empLastNameTextField.sendKeys(lastName);
    	handleDropdown(gender, toSelectEmpGenderTextField);
    	empPhoneTextField.sendKeys(java.getRndomNUM()+email);
    	empEmailTextField.sendKeys(phoneNumber);
    	handleDropdown(job, toSelectEmpJobFromDropDown);
    	toSelectEmpHireddateFromDropDown.click();
    	toSelectEmpHireddateFromDropDown.sendKeys(hiredate);
    	//handleDropdown(hiredate, toSelectEmpHireddateFromDropDown);
    	handleDropdown(province, toSelectEmpProvinceFromDropDown);
    	handleDropdown(city, toSelectEmpCityFromDropDown);
    	toClickOnSaveBtnInEmpModule.click();
    	
    }	
}
