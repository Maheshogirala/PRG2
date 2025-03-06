package XLSX;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XLWrite {
     
	
	@Test
	public void writexl() throws IOException {
		// write XLSheet  
		// create file 
		
		FileOutputStream fo= new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\"+"Mahesh2.xlsx");
		// create new workbook
		
		XSSFWorkbook workbook= new XSSFWorkbook();
		// create sheet 
		XSSFSheet sheet= workbook.createSheet("Sheet1");
		
		
		/*
		// write the data into row0
		XSSFRow row= sheet.createRow(0);
		XSSFCell cell=row.createCell(0);
		cell.setCellValue("Name");
		XSSFCell cell1= row.createCell(1);
		cell1.setCellValue("id");
		
		XSSFRow row1= sheet.createRow(1);
		XSSFCell cell0=row1.createCell(0);
		cell0.setCellValue("Mahesh");
		XSSFCell cell11= row1.createCell(1);
		cell11.setCellValue("w3s001");
		*/
		
		
		Scanner sc= new Scanner(System.in);
		
		for(int r=0; r<4; r++) {
		XSSFRow row=sheet.createRow(r);
			for(int c=0; c<4; c++) {
				System.out.println("Enter the table data");
				String data=sc.next();
				row.createCell(c).setCellValue(data);
				
			}
			
			
		}
		
		
		
		
	
	
	workbook.write(fo);
	workbook.close();
	fo.close();
		
		
	}
	
	
	
	
}
