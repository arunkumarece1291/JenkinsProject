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

public class ElectronicsPageTest extends BaseInfo 
{
	
	LoginPage loginpageObj;
	HomePage homepageObj;
	ElectronicsPage electronicspageObj;
	
	public ElectronicsPageTest()
	{
		super();
	}


	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		
		electronicspageObj = new ElectronicsPage();
		loginpageObj = new LoginPage();
		homepageObj = loginpageObj.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		electronicspageObj = homepageObj.clickElectronics();
		
	}


	@Test
	public void validateSamsungLabelTest()
	{
		String flag = electronicspageObj.validateSamsungLabel();
		System.out.println(flag);
		Assert.assertEquals(flag, "Mobiles", "Data is not correct");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
			
	
}

