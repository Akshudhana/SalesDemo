package com.genericUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListtenersUtils implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	//WebDriver driver;
	
	@Override
	public void onTestStart(ITestResult result) {
	//Execution starts from here
		String methodName=	result.getMethod().getMethodName();
		test=report.createTest(methodName);
		
		Reporter.log(methodName+"---> Execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=	result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"-->Passes");
		Reporter.log(methodName+"-->TestScript executed succesfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		WebDriverUtils webDriverUtilsobject=new WebDriverUtils();
	
		try {
			String methodName=	result.getMethod().getMethodName();
			String screenShotPath=webDriverUtilsobject.takeSceenShot(BaseClass.driver,methodName);
			test.log(Status.FAIL, methodName+"------>Failed");
			test.log(Status.FAIL, result.getThrowable());
			Reporter.log(methodName+"--->Failed");
			test.addScreenCaptureFromPath(screenShotPath);
					
					} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }

	//@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"--->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+"-->Skipped");
			}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReport/report.html");
		//It will create one emptyPage
		htmlReport.config().setDocumentTitle("SalesAndInventory");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("Akshatha");
		
		//ExtentReports report=new ExtentReports();
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		
		report.setSystemInfo("Base platform", "Windows 11");
	report.setSystemInfo("Base Browser", "chrome");
	report.setSystemInfo("Base URL", "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
	report.setSystemInfo("Reporter name", "Akshatha");	
	}

	@Override
	public void onFinish(ITestContext context) {
	
		report.flush();
	}

	
	
}
