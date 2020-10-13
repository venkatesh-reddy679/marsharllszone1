package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void putCellValue1(String sheetName, String value) throws IOException {

		FileInputStream fi = new FileInputStream("G:\\selenium\\MarshallsPetZone2\\excel\\PetZone.xlsx");
		File f = new File("G:\\selenium\\MarshallsPetZone2\\excel\\PetZone.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		sheet.createRow(0).createCell(0).setCellValue(value);
		FileOutputStream fo = new FileOutputStream(f);
		workbook.write(fo);

	}

	public static void putCellValue2(String sheetName, String value) throws IOException {

		FileInputStream fi = new FileInputStream("G:\\selenium\\MarshallsPetZone2\\excel\\PetZone.xlsx");
		File f = new File("G:\\selenium\\MarshallsPetZone2\\excel\\PetZone.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		sheet.createRow(1).createCell(0).setCellValue(value);
		FileOutputStream fo = new FileOutputStream(f);
		workbook.write(fo);

	}

}
