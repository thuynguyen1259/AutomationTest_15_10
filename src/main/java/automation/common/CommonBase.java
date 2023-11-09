package automation.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CommonBase {
	public WebDriver driver;
	public WebDriver initChromeDriver(String URL)
	{
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver",
		System.getProperty("user.dir") + "/driver/chromedriver");			
		// For MAC: System.getProperty("user.dir") + "/driver/chromedriver");	
		driver = (WebDriver) new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		return driver;
	}
}