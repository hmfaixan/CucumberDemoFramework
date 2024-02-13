package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;
	public WebDriver WebDriverManager() throws IOException {
	
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String url = prop.getProperty("QAurl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
		// result = testCondition ? value1 : value2
		String browser = browser_maven!= null ? browser_maven : browser_properties;
		
		if (driver==null) {
			
			if (browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty ("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
				driver = new ChromeDriver ();
			}
			
			if (browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty ("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//geckodriver.exe");
				driver = new FirefoxDriver ();
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
			driver.manage().window().maximize();
		}
 
		return driver;
	}
}
