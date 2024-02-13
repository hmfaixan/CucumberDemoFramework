package stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import pageObjects.offersPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

	public String offerPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	offersPage offerPage;

	public OfferPageStepDefinition(TestContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;
		this.offerPage = testContextSetup.pageObjectManager.getOffersPage();
	}

	public void switchToOffersPage() throws InterruptedException {

		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.SwitchWindowToChild();
		Thread.sleep(3000);
	}

	@Then("^User searched for (.+) short name in offers page to check if product exists with same name$")
	public void user_searched_for_same_short_name_in_offers_page_to_check_if_product_exists(String shortName)
			throws InterruptedException {

		switchToOffersPage();

		//offerPage = testContextSetup.pageObjectManager.getOffersPage();

		offerPage.searchItem(shortName);

		Thread.sleep(3000);

		offerPageProductName = offerPage.getProductName();

		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}

}
