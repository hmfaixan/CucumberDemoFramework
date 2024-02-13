package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class offersPage {

	public WebDriver driver;

	public offersPage(WebDriver driver) {

		this.driver = driver;
	}

	By Search = By.xpath("//input[@type='search']");
	By ProductName = By.cssSelector("tr td:nth-child(1)");

	public void searchItem(String name) {
		driver.findElement(Search).sendKeys(name);
	}

	public String getProductName() {
		return driver.findElement(ProductName).getText();
	}
}
