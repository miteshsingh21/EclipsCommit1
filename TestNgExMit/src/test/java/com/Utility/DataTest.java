package com.Utility;

import java.io.FileInputStream;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class DataTest {
	
	@DataProvider
	public Object[][] logintest(){
		return new Object[][] {
    new Object[] {"testing.adrs@gmail.com", "ADRS@1234","Amazon.com. Spend less. Smile more."},
    new Object[] {"mitesh@gmail.com","123456","Amazon.com. Spend less. Smile more."},
     new Object[] {"Test@gmail.com","123456","Amazon.com. Spend less. Smile more."},
     new Object[] {"@%$&(","123456","Amazon.com. Spend less. Smile more."}
		
	};
	

}
	@DataProvider
	public String[][] loginexceltest() throws Exception{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Loginfile.xls");
		 Workbook wb = Workbook.getWorkbook(fis);
		 Sheet sh = wb.getSheet("Login");
		 int rows = sh.getRows();
		 int cols = sh.getColumns();
		 String[][] values = new String[rows-1][cols];
		for(int i = 1;i < rows;i++) {
			for(int j = 0;j<cols;j++) {
				Cell cell = sh.getCell(j, i);
				String data = cell.getContents();
				values[i-1][j]= data;
			}
				
		}
		return values;
		
		
		
		
		
		
	}
	
	
}
