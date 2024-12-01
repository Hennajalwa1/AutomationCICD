package Riowalacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
		WebDriver driver;
		
		public  AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
		@FindBy(css="[routerlink*='cart']")
		WebElement cartHeader;
	
	
		public void waitForElementToAppear(By findBy) 
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

		}
		
		public void waitForWebElementToAppear(WebElement findBy) 
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

		}
		
		public void goToCartPage()
		{
			cartHeader.click();
		}
		public void waitForElementToDisappear(WebElement ele)
		{
			//4 seconds_application
		//	Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
			wait.until(ExpectedConditions.invisibilityOf(ele));
		}
	}