package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_utility {
	public  String excel_email(int i) throws IOException {
		  
		  FileInputStream fil = new FileInputStream(new File("C:\\Users\\DELL\\Downloads\\anusha\\src\\test\\resources\\testdata\\naukri1.xlsx"));
		  XSSFWorkbook workbook = new XSSFWorkbook(fil);
		  XSSFSheet sheet=workbook.getSheet("Sheet1");
		  
		    
			  XSSFRow row =sheet.getRow(i);
			  XSSFCell cell=row.getCell(0);
			  String em=cell.getStringCellValue();
			        
		return em;
}
	public  String excel_password(int i) throws IOException {
		  
		  FileInputStream fil = new FileInputStream(new File("C:\\Users\\DELL\\Downloads\\anusha\\src\\test\\resources\\testdata\\naukri1.xlsx"));
		  XSSFWorkbook workbook = new XSSFWorkbook(fil);
		  XSSFSheet sheet=workbook.getSheet("Sheet1");
		  
		  
			  XSSFRow row =sheet.getRow(i);
			  XSSFCell cell1=row.getCell(1);
			  String pwd=cell1.getStringCellValue();
    
		return pwd;
}
}
