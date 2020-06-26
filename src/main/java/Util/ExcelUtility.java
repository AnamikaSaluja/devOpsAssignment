package Util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {


	public static String getCellData(int RowNum, int ColNum) throws Exception{
		XSSFWorkbook wb=null;
		try {

			File src = new File("D:\\Eclipse\\Amazon_Assignment\\src\\test\\resources\\TestCaseRunMode.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			XSSFSheet sh1 = wb.getSheet("Testcase");
			System.out.println(sh1.getRow(RowNum).getCell(ColNum).getStringCellValue());

			return sh1.getRow(RowNum).getCell(ColNum).getStringCellValue();
		} catch (Exception e) 
		{

			return "";

		} 
		
	}
}
