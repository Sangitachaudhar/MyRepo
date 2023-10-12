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
import Pages.SignUpPage;
import Utils.Utility;

public class TestClassForSignUp extends Browser {
	
	private WebDriver driver;
	 LoginPage loginPage;
	 SignUpPage signUpPage;
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
			 signUpPage=new SignUpPage(driver);
		}
		
		@BeforeMethod
		public void openLoginPage()
		{
			driver.get("https://www.instagram.com/accounts/login");
			loginPage.clickOnSighnUpLink();
		}
		
		@Test(priority=1)
		public void verifyLoginCredentials() throws InterruptedException
		{
			Thread.sleep(3000);
			
			signUpPage.clickSignupButton("sangita@gmil.com", "Sangita", "Sangita Chaudhar", "A12334");
		}
		
		
		@Test(priority=1)
		public void verifyLoginCredentials2() throws InterruptedException
		{
			Thread.sleep(3000);
			
			signUpPage.clickSignupButton("7656543245", "Sangita", "Sangita Chaudhar", "A12334");
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
