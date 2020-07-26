package flipPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import flipBase.BaseInfo;

//Creating Page Library for Home Page

public class HomePage extends BaseInfo 
{

	@FindBy(xpath="//img[@class='_1e_EAo']")
	WebElement fliptext;
	
	@FindBy(xpath="(//span[@class='_1QZ6fC _3Lgyp8'])[1]")
	WebElement electronicsLink;
	
	
	@FindBy(xpath="//a[@title='Samsung'][1]")
	WebElement samsungLink;
	
	
	@FindBy(xpath="(//span[@class='_1QZ6fC _3Lgyp8'])[3]")
	WebElement mensLink;
	
	@FindBy(xpath = "(//a[@title='Sports Shoes'])[1]")
	WebElement sportshoeLink;
	
	//Initializing page objects
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean verifyText()
	{
		return fliptext.isDisplayed();
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public ElectronicsPage clickElectronics()
	{
		
		  Actions action = new Actions(driver);
		  action.moveToElement(electronicsLink).build().perform(); 
		  WebElement ck= samsungLink;
		  Click(driver, ck, 20); //explict wait
		  return new ElectronicsPage();
	}
		
	public static void Click(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element)).click();
	}
		
			
		

	
	public MenPage clickMen()
	{
		Actions action=new Actions(driver);
		action.moveToElement(mensLink).build().perform();
		sportshoeLink.click();
		
		
		return new MenPage();
	}
	
}
