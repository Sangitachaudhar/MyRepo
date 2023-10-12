package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userName;

	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath="//span[text()='Log in with Facebook']")
	private WebElement logWithfacebookLink;
	
	@FindBy(xpath="//a/span[text()='Forgot password?']")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath="//span[text()='Sign up']")
	private WebElement sighnUpLink;
	
	public  LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickUserName(String name)
	{
		userName.sendKeys(name);
	}
	
	public void clickPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public void clickLoginWithFacebookLink()
	{
		logWithfacebookLink.click();
	}
	
	public void clickForgotPasswordLink()
	{
		forgotPasswordLink.click();
	}
	public void clickOnSighnUpLink()
	{
		sighnUpLink.click();
	}
}
