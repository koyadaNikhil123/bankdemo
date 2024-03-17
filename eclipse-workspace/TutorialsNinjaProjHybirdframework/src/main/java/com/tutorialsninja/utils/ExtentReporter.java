package com.tutorialsninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport(){
		
		ExtentReports extentreports=new ExtentReports();
		File extentreportfile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(extentreportfile);
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("Tutorials Ninja Test Automation results report");
		sparkreporter.config().setDocumentTitle("TN Automation report");
		sparkreporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		Properties configprop=new Properties();
		File configfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\config\\config.properties");
		FileInputStream fiss = null;
		try {
			fiss = new FileInputStream(configfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			configprop.load(fiss);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentreports.attachReporter(sparkreporter);
		extentreports.setSystemInfo("Application URL",configprop.getProperty("url") );
		extentreports.setSystemInfo("Browser Name",configprop.getProperty("browser") );
		extentreports.setSystemInfo("Email",configprop.getProperty("validEmail") );
		extentreports.setSystemInfo("Password",configprop.getProperty("validPassword") );
		extentreports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentreports.setSystemInfo("UserName", System.getProperty("user.name"));
		extentreports.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentreports;




		
	}

}
