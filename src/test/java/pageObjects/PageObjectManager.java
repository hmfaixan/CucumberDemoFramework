package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LandingPage landingPage;
	public offersPage OffersPage;
	public WebDriver driver;
	public CheckoutPage checkoutPage;
	
	public PageObjectManager(WebDriver driver) {
		
		this.driver = driver;
	}
		
	public LandingPage getLandingPage() {
	
		landingPage = new LandingPage(driver);
		return landingPage;
	}

	public offersPage getOffersPage() {
		
		OffersPage = new offersPage(driver);
		return OffersPage;
	}
	
	public CheckoutPage getCheckoutPage() {
		
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
}
