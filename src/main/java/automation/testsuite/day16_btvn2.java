package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;

public class day16_btvn2 extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver=initChromeDriver(CT_Account.BLOGSPOT_URL);
	}
	@Test
	public void clickTryIt() {
		click(By.xpath("//button[text()='Try it']"));
		pause(10000);
		String msgWelcome=driver.switchTo().alert().getText();
		assertEquals(msgWelcome,"Welcome to Selenium WebDriver Tutorials");
		driver.switchTo().alert().accept();
	}
	@AfterMethod
	public void closeChrome() {
		closeDriver(); //đóng driver
	}
}
