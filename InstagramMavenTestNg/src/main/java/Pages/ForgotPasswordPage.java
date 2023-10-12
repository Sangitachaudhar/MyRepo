package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//div[text()='Send login link']")
	private WebElement sendLoginLink;
	
	public  ForgotPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	

	public void clickSendLinkButton(String email)
	{
		emailAddress.sendKeys(email);
		
		if(sendLoginLink.isEnabled())
		{
			sendLoginLink.click();
		}
	}
}
