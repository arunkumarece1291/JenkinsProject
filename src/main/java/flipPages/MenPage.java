package flipPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import flipBase.BaseInfo;

public class MenPage extends BaseInfo 
{

	@FindBy(xpath="//h1[@class='_2yAnYN']")
	WebElement shoeLabel;

	public MenPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validateshoeLabel()
	{
		return shoeLabel.getText();
	}

	
}


