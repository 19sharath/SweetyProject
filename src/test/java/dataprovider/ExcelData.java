package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	XSSFWorkbook wb;
	public ExcelData () {
		
		File s = new File("./ApplicationTestdata/AppData.xlsx");
		try {
			FileInputStream f = new FileInputStream (s);
			wb = new XSSFWorkbook(f);
			
		} catch (Exception e) {
			System.out.println("Error is " +e.getMessage());
		}	
	}
	
	public String getData(int sheetInd, int row , int colum)
	{
	String data=	wb.getSheetAt(sheetInd).getRow(row).getCell(colum).getStringCellValue();
		return data;
	}
	
	public String getData(String sheetname, int row , int colum)
	{
	String data=	wb.getSheet(sheetname).getRow(row).getCell(colum).getStringCellValue();
		return data;
	}
	
	public int getDa(int sheetIndex, int row, int col) {
		int data = (int) wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getNumericCellValue();
	return data;
	}
	
	public int sheetcount(int sheetIndex) {
		
	int count= wb.getSheetAt(sheetIndex).getLastRowNum();
	return count;
	}
}
