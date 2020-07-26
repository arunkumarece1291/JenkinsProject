package flipBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import flipUtil.TestUtil;

public class BaseInfo 
{

	public static WebDriver driver;
	public static Properties prop;
	
	public BaseInfo()
	{
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\FlipkartTest\\src\\main\\java\\flipConfig\\config.properties");	
			prop.load(ip);
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		
	}
	
	public static void initialization() throws InterruptedException
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "G:\\\\Selenium\\\\chromedriver-9-06-20\\\\chromedriver_win32\\\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browsername.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "G:\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		Thread.sleep(3000);
	}
	
}
