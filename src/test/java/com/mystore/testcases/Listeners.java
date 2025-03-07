package com.mystore.testcases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mystore.base.BasClass;

import Data.ExportReport;

public class Listeners extends BasClass implements ITestListener{
	ExtentReports extent = ExportReport.getReporterObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result){  
		System.out.println("Execution started"); 
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		} 
	
	@Override
		public void onTestSuccess(ITestResult result) {  
		System.out.println("Success of test cases");
		extentTest.get().log(Status.PASS, "Test Passed");
		//test.log(Status.PASS, "Test Passed");
		} 
	@Override
	public void onTestFailure(ITestResult result) {
		// ScreenShots
		System.out.println("Failure of test cases");
		extentTest.get().fail(result.getThrowable());
		test.fail(result.getThrowable());
		try {
			 driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String filePath = null;
		try {
			 filePath = getScreenshot(result.getMethod().getMethodName(), driver);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		//test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}
	@Override
		public void onTestSkipped(ITestResult result) {    
		System.out.println("Skip of test cases and its details are : "+result.getName());  
		}  
	
		public void onFinish(ITestContext context) {  
		System.out.println("Execution Closed"); 
		extent.flush();
		} 
}

