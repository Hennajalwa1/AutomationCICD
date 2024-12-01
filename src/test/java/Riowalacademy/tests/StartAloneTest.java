package Riowalacademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Assert.ThrowingRunnable;
import org.testng.annotations.Test;

import Riowalacademy.TestComponents.BaseTests;
import Riowalacademy.pageobject.LandingPage;
import Riowalacademy.pageobject.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StartAloneTest extends BaseTests{

	//public static void main(String[] args) throws InterruptedException {
	@Test
	public void StartAloneTest() throws IOException
	{
		
		String ProductName="ZARA COAT 3";
		
		ProductCatalogue productCatalogue = landingPage.loginApplication("harrypotteruk958@gmail.com", "Abcde@123");
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(ProductName);
		productCatalogue.goToCartPage();
	
		
				
	
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List <WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(ProductName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
				
		Actions a= new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[Placeholder='Select Country']")), "india").build().perform();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();

		String confirmMessage = driver.findElement(By.cssSelector("hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
		
		public void getScreesnshot()
		{
			TakeScreenshot ts= (TakeScreenshot)driver;
			File Source=ts.getScreenshotAs(OutputType.FILE);
			File file = new file("");
			FileUtils.copyFile(source, file);
			return file;
		}
	}
	
}
