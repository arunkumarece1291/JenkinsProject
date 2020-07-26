package flipPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import flipBase.BaseInfo;

public class LoginPage extends BaseInfo
{
	//PageFactory
	
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']")
	WebElement mobilenumber;
	
	@FindBy(xpath="//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement submit;
	
	// Initializing the page factory
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Actions
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String uname, String pwd)
	{
		mobilenumber.sendKeys(uname);
		password.sendKeys(pwd);
		submit.click();
		
		return new HomePage();
		
	}
	
}
