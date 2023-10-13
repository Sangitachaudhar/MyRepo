package TestClassPakage;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.Browser;
import Pages.LoginPage;
import Utils.Utility;

public class TestClassForLoginPage extends Browser {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private String testId;
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@Parameters("browser")
	@BeforeTest
	public void luanchbrowser(String browserName)
	{
		
		reporter=new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend=new ExtentReports();
		extend.attachReporter(reporter);
		
	  if(browserName.equals("Chrome"))
		{
				
			driver=launchChrome();
		}
		
		if(browserName.equals("Firefox"))
		{
			driver=launchFirefox();

		}
		if(browserName.equals("Edge"))
		{
			driver=launchEdge();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}
	
	@BeforeClass
	public void  createObject()
	{
		 System.out.println("hi");
		 loginPage=new LoginPage(driver);
		 
		
	}
	
	
	@BeforeMethod
	public void openLoginPage()
	{
		driver.get("https://www.instagram.com/accounts/login");
	}
	
	@Test
	public void verifyUser() throws IOException, InterruptedException
	{
		testId="TC001";
		 String userName = null;
		 String password = null;
//		 String path="D:\\Software_testing\\Automation\\mytestData.xlsx";
		 String path="src\\test\\resources\\TestData\\mytestData.xlsx";

		 userName=Utility.getDataFromExcelsheet(path,"Sheet1", 1, 0);
				 
		 password=Utility.getDataFromExcelsheet(path,"Sheet1", 1, 1);
				 
		 System.out.println(userName+"\n"+password);
		 System.out.println("for testing:::"+userName+"\n"+password);		 

		 SoftAssert softAssert=new SoftAssert();
		 
		 String expectedData=userName;
		 String actualResult=userName;
		
		 softAssert.assertEquals(expectedData, actualResult,"Pass");
		
		 loginPage.clickUserName(userName);
		 loginPage.clickPassword(password);
		 
		Thread.sleep(3000);	
		 
		loginPage.clickLoginButton();	
		
	}
	
	@AfterMethod
	public void logout(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			//capture screenshot
			Utility.captureScreenshot(testId, driver);
		}
	}
	
	@AfterClass
	public void closebrowser()
	{
		driver.quit();
	}

}
