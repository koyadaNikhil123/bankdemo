package com.tutorialsninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {



	
public static String generatedateStamp() {

	Date date=new Date();
	 String datestamp=date.toString().replace(" ","_").replace(":","_");
	return "koyada"+datestamp+"@gmail.com";
	
}

 
@SuppressWarnings("resource")
public static Object[][] getTestDataFromExcel(String sheetname) throws IOException {
	 
	 File excelFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\testdata\\testdata.xlsx");
	 XSSFWorkbook workbook=null;
	
		FileInputStream fisExcel=new FileInputStream(excelFile);
	
	  workbook=new XSSFWorkbook(fisExcel);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rows][cols];
		
		
		for(int i=0;i<rows;i++) {
			XSSFRow	row=sheet.getRow(i+1);
		
	
		for(int j=0;j<cols;j++) {
			
			XSSFCell cell=row.getCell(j);
		CellType cellType = cell.getCellType();
		
		switch(cellType) {
	
		case STRING:
			       data[i][j]=cell.getStringCellValue();
			       break;
		case NUMERIC:
			         data[i][j]=Integer.toString((int)cell.getNumericCellValue());
			         break;
		case BOOLEAN:
			        data[i][j]=cell.getBooleanCellValue();
			        break;
		default:
			break;
		             }
		   }
		}
		return data;
  }

public static String captureScreenshot(WebDriver driver,String testName) {
	
	File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destinationScreenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
	
	
		try {
			FileUtils.copyFile(srcScreenshot,new File(destinationScreenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	return destinationScreenshotPath;
}
}




