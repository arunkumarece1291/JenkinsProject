package flipTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import flipBase.BaseInfo;
import flipPages.ElectronicsPage;
import flipPages.HomePage;
import flipPages.LoginPage;
import flipPages.MenPage;

	//Test cases should be independent to each other
	//Before each test case -- launch the browser  and login
	//@Test -- Execute the test case
	//After each test case -- close the browser

public class HomePageTest extends BaseInfo
{
	LoginPage loginpageObj;
	HomePage homepageObj;
	ElectronicsPage electronicspageObj;
	MenPage menpageObj;
	
	public HomePageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		menpageObj = new MenPage();
		electronicspageObj = new ElectronicsPage();
		loginpageObj = new LoginPage();
		homepageObj = loginpageObj.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
	}
	
	
	@Test(priority = 1)
	public void homePageTest()
	{
		String title = homepageObj.validateHomePageTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!", "Title Not Matched");
	}

	@Test(priority = 2)
	public void verifyFlipTest()
	{
		boolean flag = homepageObj.verifyText();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority = 3)
	public void electronicsPageTest() throws InterruptedException
	{
		electronicspageObj = homepageObj.clickElectronics();
	}
	
	@Test(priority = 4)
	public void mensPageTest() throws InterruptedException
	{
		menpageObj = homepageObj.clickMen();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
