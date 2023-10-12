package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	static Workbook workbook;
	static String str_data="";
	
	//String s=Double.toString(d); double to string
	public static String getDataFromExcelsheet(String filePath,String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{

		InputStream inputstream=new FileInputStream(filePath);
	    workbook=WorkbookFactory.create(inputstream);
		
	    try {
	    
		    str_data=workbook.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		    
		   
	    }
	    catch (Exception e) {
	    	
	    	e.printStackTrace();
			// TODO: handle exception
	    	 //to retrive numeric data
			Double numericData=workbook.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
			str_data=Double.toString(numericData).replace(".0", "");
			System.out.println(str_data);
		}

	    
	    workbook.close();
		return str_data;
		
	}
	
	public static void captureScreenshot(String testId,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		

		File src=ts.getScreenshotAs(OutputType.FILE);
		
		SimpleDateFormat dateformat=new SimpleDateFormat("-yyyy-MM-dd HH-mm-ss");
	    Date date = new Date();  
	    String str_currentdateTime=dateformat.format(date);
		System.out.println("test.jpeg"+str_currentdateTime);
		
		File dest=new File("test-output\\FailedTestScreenshots\\"+testId+str_currentdateTime+".png");
		FileHandler.copy(src, dest);
	}

}

//D:\\Software_testing\\Automation\\Screenshot_seleniumpoject\\