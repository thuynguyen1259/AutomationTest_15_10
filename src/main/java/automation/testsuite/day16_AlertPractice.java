package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class day16_AlertPractice extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://demo.guru99.com/test/delete_customer.php");
	
	}
	
	@Test
	public void deleteCustomerSuccessfully() {
		type(By.xpath("//input[@name='cusid']"), "4567");
		click(By.xpath("//input[@name='submit']"));
		String msgConfirm=driver.switchTo().alert().getText();
		assertEquals(msgConfirm,"Do you really want to delete this Customer?");
		driver.switchTo().alert().accept();
		String msgNotiSuccess=driver.switchTo().alert().getText();
		assertEquals(msgNotiSuccess,"Customer Successfully Delete!");
		driver.switchTo().alert().accept();
	}
	
	@AfterMethod
	public void closeChrome() {
		closeDriver(); //đóng driver
	}
	
}
