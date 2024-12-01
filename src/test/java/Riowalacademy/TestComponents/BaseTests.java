package Riowalacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Riowalacademy.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests<TakeScreenshot> {

	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException
	{
		//properties class
		Properties prop =new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir"+"C:\\Users\\hjalwauk\\eclipse-workspace\\Seleniumjio\\src\\main\\java\\Riowalacademy\\resources\\GlobalData.properties"));
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			//Firefox
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			//edge
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}

	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		driver= initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	public String getScreesnshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakeScreenshot ts= (TakeScreenshot)driver;
		File Source=((TakesScreenshot) ts).getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") +"//reports//"+ testCaseName+".png");
		FileUtils.copyFile(Source, file);
		return System.getProperty("user.dir") +"//reports//"+ testCaseName+".png";
	}
}
