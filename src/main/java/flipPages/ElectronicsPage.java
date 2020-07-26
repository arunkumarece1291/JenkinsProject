package flipPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import flipBase.BaseInfo;

public class ElectronicsPage extends BaseInfo 
{
	@FindBy(xpath="(//a[@class='_2AkmmA _1eFTEo'])[1]")
	WebElement viewAllLabel;
	
	@FindBy(xpath="//h1[@class='_2yAnYN']")
	WebElement mobileLabel;


	public ElectronicsPage()
	{
		PageFactory.initElements(driver, this);
		
	}

	public String validateSamsungLabel()
	{
		viewAllLabel.click();
		return mobileLabel.getText();
	}
	
}
