package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;

	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	
	@Given("User is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}

	@When("^User searched with short name (.+) and extracted actual name of the product$")
	public void user_searched_with_short_name_and_extracted_actual_name_of_the_product(String shortName)
			throws InterruptedException {

		landingPage.searchItem(shortName);

		Thread.sleep(3000);

		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName + " is extracted from Homepage");
	}
	
	@When("Added {string} items of the selected product to the cart")
	public void Added_Items_product(String quantity) throws InterruptedException {
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		Thread.sleep(3000);
	}

}
