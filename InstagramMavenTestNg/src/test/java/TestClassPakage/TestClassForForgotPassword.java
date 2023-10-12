package TestClassPakage;

import java.io.IOException;
import java.time.Duration;

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

import Base.Browser;
import Pages.ForgotPasswordPage;
import Pages.LoginPage;
import Pages.LoginWithFacebook;
import Utils.Utility;

public class TestClassForForgotPassword extends Browser{
	
	private WebDriver driver;
	 LoginPage loginPage;
	 ForgotPasswordPage forgotPasswordPage;
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
		public void luanchbrowser()
		{
			 loginPage=new LoginPage(driver);
			 forgotPasswordPage=new ForgotPasswordPage(driver);
		}
		
		@BeforeMethod
		public void openLoginPage()
		{
			driver.get("https://www.instagram.com/accounts/login");
			loginPage.clickForgotPasswordLink();
		}
		
		@Test
		public void verifyLoginCredentials() throws InterruptedException
		{
			Thread.sleep(3000);
			
			forgotPasswordPage.clickSendLinkButton("sangita@gmail.com");
			
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
			driver.close();
		}


}
