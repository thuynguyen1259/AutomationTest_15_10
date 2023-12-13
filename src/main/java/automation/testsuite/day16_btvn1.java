package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.page.Page_Fact_btvnd14;

public class day16_btvn1 extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver=initChromeDriver(CT_Account.ALADA_URL);
	}
	
	@Test (priority=1)
	public void UpdatePassword_Successfully() throws InterruptedException {
		Page_Fact_btvnd14 login= new Page_Fact_btvnd14(driver);
		login.Login_Function("thuynguyen99@gmail.com","1234567");
		Thread.sleep(5000);
		assertTrue(driver.findElement(CT_Account.AVATAR_USER).isDisplayed());
		login.Edit_Function();
		scrollToElement(By.xpath("//label[text()='Giới tính']"));
		Thread.sleep(5000);
		login.Change_Password("1234567", "123456", "123456");
		pause(3000);
		String msgUpdateSuccess = driver.switchTo().alert().getText();
		assertEquals(msgUpdateSuccess,"Cập nhật mật khẩu mới thành công!");
		driver.switchTo().alert().accept();
		assertTrue(driver.findElement(CT_Account.INFOMATION).isDisplayed());
		}
	@AfterMethod
	public void closeChrome() {
		closeDriver(); //đóng driver
	}
}
