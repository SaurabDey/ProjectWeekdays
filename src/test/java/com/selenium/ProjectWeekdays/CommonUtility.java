package com.selenium.ProjectWeekdays;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CommonUtility {
	WebDriver driver;

	public CommonUtility(WebDriver driver) {
		this.driver = driver;
	}

	public String[] commonExcelMethod() throws IOException
	{
		String[] dataExcel=new String[2];
		File f= new File("Resource/Data.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook excel = new XSSFWorkbook(fis);
		XSSFSheet sht = excel.getSheet("Sheet1");
		
		dataExcel[0] =sht.getRow(1).getCell(0).getStringCellValue();
		dataExcel[1] =sht.getRow(1).getCell(1).getStringCellValue();
		
		excel.close();
		fis.close();
		
		return dataExcel;
	}

	public String takeScreenshot(String name)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String dest = "Resource/SeleniumScreenshot"+name+".png";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dest;
	}
}
