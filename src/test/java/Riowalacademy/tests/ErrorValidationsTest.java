package Riowalacademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Assert.ThrowingRunnable;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Riowalacademy.TestComponents.BaseTests;
import Riowalacademy.pageobject.LandingPage;
import Riowalacademy.pageobject.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationsTest extends BaseTests{
	
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	
		public void loginErrorValidation() throws IOException,InterruptedException{
		landingPage.loginApplication("harrypotteruk958@gmail.com", "Ade@123");
		Assert.assertEquals("Incorrect emailpassword.",landingPage.getErrorMessage());
	}

	//public static void main(String[] args) throws InterruptedException {
	@Test
	public void StartAloneTest() throws IOException
	{
		
		String ProductName="ZARA COAT 3";
		
		ProductCatalogue productCatalogue = landingPage.loginApplication("harrypotteruk958@gmail.com", "Ade@123");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
	}
	
}
