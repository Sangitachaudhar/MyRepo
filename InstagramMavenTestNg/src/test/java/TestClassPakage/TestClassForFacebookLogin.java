package TestClassPakage;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.math3.analysis.function.Log;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Base.Browser;
import Pages.LoginPage;
import Pages.LoginWithFacebook;
import Utils.Utility;

public class TestClassForFacebookLogin extends Browser {
	
   private  WebDriver driver;
    LoginPage loginPage;
    LoginWithFacebook loginWithFacebook;
    private String testId;
	
    @Parameters("browser")
	@BeforeTest
	public void luanchbrowser(String browserName)
	{
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
	public void createObject()
	{
		  loginPage=new LoginPage(driver);
		  loginWithFacebook=new LoginWithFacebook(driver);
	}
	
	@BeforeMethod
	public void openLoginPage()
	{
		driver.get("https://www.instagram.com/accounts/login");
		
		
		loginPage.clickLoginWithFacebookLink();
	}
	
	@Test
	public void verifyLoginCredentials() throws EncryptedDocumentException, IOException
	{
		testId="TC004";
		
		 String userName = null;
		 String password = null;

		 String path="src\\test\\resources\\TestData\\mytestData.xlsx";

		 userName=Utility.getDataFromExcelsheet(path,"Sheet1", 1, 0);
				 
		 password=Utility.getDataFromExcelsheet(path,"Sheet1", 1, 1);
				 
		 System.out.println("facebook:"+userName+"\n"+password);
		
//		loginWithFacebook.clickLoginButton("Sangita", "S@133435");
		loginWithFacebook.clickLoginButton(userName,password);
		
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
