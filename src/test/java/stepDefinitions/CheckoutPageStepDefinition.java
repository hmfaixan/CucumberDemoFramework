package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public CheckoutPage checkoutPage;
	TestContextSetup testContextSetup;
	LandingPage landingPage;

	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
		this.checkoutPage  = testContextSetup.pageObjectManager.getCheckoutPage();
	}

	
	@Then("Verify user has ability to enter promo code and place the order")
	public void Verify_user_has_ability_to_enter_promo_code_and_place_the_order() throws InterruptedException {
		Assert.assertTrue(checkoutPage.VerifyPromoBtn()); 
		Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
		Thread.sleep(2000);
		}

	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void User_proceeds_to_checkout_and_validate_items_in_checkout_page(String name) throws InterruptedException{
		checkoutPage.CheckoutItems();
		Thread.sleep(1000);
	}
}
