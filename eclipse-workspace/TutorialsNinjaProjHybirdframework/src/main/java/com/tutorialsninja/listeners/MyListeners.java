package com.tutorialsninja.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.utils.ExtentReporter;
import com.tutorialsninja.utils.Utilities;

public class MyListeners implements ITestListener {

	public static ExtentReports extentrep;
	public static ExtentTest extenttest;
	@Override
	public void onStart(ITestContext context) {
		 
		 extentrep = ExtentReporter.generateExtentReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String testname=result.getName();
		 extenttest = extentrep.createTest(testname);
		extenttest.log(Status.INFO, testname +" started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname=result.getName();
		extenttest.log(Status.PASS, testname +" got successfully executed");
	
	}
		

	@Override
	public void onTestFailure(ITestResult result) {
		String testname=result.getName();
         
	 WebDriver driver = null;
	
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String destinationScreenshotPath = Utilities.captureScreenshot(driver,result.getName());

		extenttest.addScreenCaptureFromPath(destinationScreenshotPath);
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.FAIL,testname +" got failed");
		System.out.println(testname +" got failed");
		System.out.println(result.getThrowable());
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testname=result.getName();
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.SKIP, testname +" got skipped");
		System.out.println(testname +" got skipped");
		System.out.println(result.getThrowable());

	
	}

	

	@Override
	public void onFinish(ITestContext context) {
		extentrep.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		
	}

	

