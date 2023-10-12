package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWithFacebook {
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//input[@id='pass']")
	private WebElement password;
	
	@FindBy(xpath="//button[@id='loginbutton']")
	private WebElement loginButton;
	
	public  LoginWithFacebook(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickLoginButton(String email,String pass)
	{
		emailAddress.sendKeys(email);
		password.sendKeys(pass);
		loginButton.click();
	}
}
