package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.page.TrizenPage;

public class TrizenTest extends CommonBase {
	@BeforeTest
	public void openChrome() {
		driver = initChromeDriver(CT_Account.TRIZEN_URL);
	
	}
	@Test
	public void TestDateTimeAndDrop() throws InterruptedException {
		TrizenPage trizen = new TrizenPage(driver);
		trizen.HaddleDateTimeAndDrop();
		Thread.sleep(5000);
		assertTrue(driver.findElement(CT_Account.SEARCH_RESULT).isDisplayed());
	}
	@AfterMethod
	public void closeChrome() {
		closeDriver(); //đóng driver
	}
}
