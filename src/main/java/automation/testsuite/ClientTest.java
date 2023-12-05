package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.page.ClientPage;
import automation.page.LoginPage_Factory;

public class ClientTest extends CommonBase {

	@BeforeTest
	public void openChrome() {
		driver = initChromeDriver(CT_Account.RISE_URL);
	
	}
	@Test
	public void AddClientSuccessfully() throws InterruptedException {
		LoginPage_Factory login = new LoginPage_Factory(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		Thread.sleep(5000);
		ClientPage client = new ClientPage (driver);
		client.AddClientFunction("Thuy99 Company", "Sara Ann","Hadong","Ha Noi","State1","10000","VietNam","0967764634","website1","123","456","VIP",
				"AFN","$","Unsatisfied");
		//check add thành công 
		//assertTrue(driver.findElement(By.xpath("//a[text()='Thuy Company']")).isDisplayed());
		Thread.sleep(5000);
		isElementPresent(By.xpath("//a[text()='Thuy99 Company']"));
		
	}
	@AfterMethod
	public void closeChrome() {
		closeDriver(); //đóng driver
	}
	
}
