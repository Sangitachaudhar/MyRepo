package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	@FindBy(xpath="//span[text()='Log in with Facebook']")
	private WebElement logWithfacebookLink;
	
	@FindBy(xpath="//input[@name='emailOrPhone']")
	private WebElement emailOrPhone;
	
	@FindBy(xpath="//input[@name='fullName']")
	private WebElement fullName;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signUpButton;
	
	public  SignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public void clickSignupButton(String email,String fullname,String user,String pass)
	{
		emailOrPhone.sendKeys(email);
		fullName.sendKeys(fullname);
		userName.sendKeys(user);
		password.sendKeys(pass);
		signUpButton.click();
	}
	
	public void clickfacebookLink()
	{
		logWithfacebookLink.click();
	}
}
