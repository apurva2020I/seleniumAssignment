package assertion;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;

public class Assignment4 {
	@Test
	public void test() throws IOException {
		
		String path="C:\\Users\\apurva.jyoti\\git\\HSBCStuff\\seleniumAssignment\\ExcelData\\data.xlsx";
		
		FileInputStream input=new FileInputStream(path);
		XSSFWorkbook book =new XSSFWorkbook(input);
		XSSFSheet sheet=book.getSheet("Sheet1");
		
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		for(int i=1;i<=rowCount;i++) {
			
			String username=sheet.getRow(i).getCell(0).getStringCellValue();
			String password=sheet.getRow(i).getCell(1).getStringCellValue();

			
			Assert.assertNotNull(username);
			System.out.println("username : "+username);
			System.out.println("password : "+password);

			
		}
	}

}



