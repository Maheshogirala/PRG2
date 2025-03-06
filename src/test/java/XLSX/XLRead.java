package XLSX;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLRead {

	public static void main(String[] args) throws IOException {
		// i want to read the XL 
		// step-1 open the file 
		
		FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+"data.xlsx");
		// open work book 
		
		XSSFWorkbook workbook= new XSSFWorkbook(fi);
		// open the sheet on work book
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		// iwant get the rows count 
		int row=sheet.getLastRowNum();
		System.out.println(row);
		// i want get the cell count 
		int cell=  sheet.getRow(0).getLastCellNum();
		System.out.println(cell);
		
		for(int r=0; r<=row;r++) {
			XSSFRow c_row= sheet.getRow(r);
			for(int c=0; c<=cell; c++) {
				XSSFCell c_cell=c_row.getCell(c);
				System.out.print(c_cell+"    ");
			}System.out.println();
			
		}
		workbook.close();
		fi.close();

	}

}
