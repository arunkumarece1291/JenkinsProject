package flipTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flipBase.BaseInfo;
import flipPages.HomePage;
import flipPages.LoginPage;
import flipPages.MenPage;

public class MenPageTest extends BaseInfo
{

	LoginPage loginpageObj;
	HomePage homepageObj;
	MenPage menpageObj;
	
	public MenPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		
		menpageObj = new MenPage();
		loginpageObj = new LoginPage();
		homepageObj = loginpageObj.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		menpageObj = homepageObj.clickMen();
		
	}
	
	@Test
	public void shoeLabelTest()
	{
		String shoename=menpageObj.validateshoeLabel();
		System.out.println(shoename);
		Assert.assertEquals(shoename, "Sports Shoes");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
