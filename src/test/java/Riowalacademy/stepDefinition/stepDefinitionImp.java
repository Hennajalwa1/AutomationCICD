package Riowalacademy.stepDefinition;

import java.io.IOException;

import Riowalacademy.TestComponents.BaseTests;
import Riowalacademy.pageobject.ProductCatalogue;
import io.cucumber.java.en.Given;

public LandingPage landingPage;
public class stepDefinitionImp extends BaseTests {

	@Given("I landed on ecommerce page")

	public void I_landed_on_ecommerce_page() throws IOException
	{
		landingPage=launchApplication();
	}
	@Given("^Login with username (.+) and (.+)$")

	public void Login_with_usernam_and_password(String username,String paswword)
	{
		ProductCatalogue productCatalogue = landingPage.loginApplication(username, paswword);
	}

}
