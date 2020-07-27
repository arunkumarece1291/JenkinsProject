package flipTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flipBase.BaseInfo;
import flipPages.HomePage;
import flipPages.LoginPage;

public class LoginPageTest  extends BaseInfo
{

	LoginPage loginpageObj; //create object for assessing the methods from LoginPage class
	HomePage homepageObj;
	
	public LoginPageTest()
	{
		super();  //Calling parent class constructor
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginpageObj = new LoginPage();
	}

	
	@Test(priority = 1, groups = {"smoke"})
	public void loginPageTitleTest()
	{
		String title = loginpageObj.validateLoginPageTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Test(priority = 2)
	public void loginTest()
	{
		homepageObj = loginpageObj.login(prop.getProperty("username"), prop.getProperty("password")); //Landing page of Login page is HomePage thats why created object for Homepage
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}

}
