package com.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelRead {
	WebDriver driver;
	
	public ExcelRead(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public static String getCellValue(String sheetName,int rowNum,int cellNum) throws IOException {
		String cellValue= null;
		FileInputStream stream = new FileInputStream("G:\\selenium\\MarshallsPetZone2\\excel\\PetZone.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(cellNum);
	    cellValue =cell.getStringCellValue();
	    return cellValue;
		
		
		
	}


	

}
