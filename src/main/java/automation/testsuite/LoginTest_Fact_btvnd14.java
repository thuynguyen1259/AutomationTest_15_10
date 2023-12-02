package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.page.Page_Fact_btvnd14;

public class LoginTest_Fact_btvnd14 extends CommonBase{
	
	@BeforeMethod
	public void openChrome() {
		driver=initChromeDriver(CT_Account.ALADA_URL);
	}
	
	@Test (priority=1)
	//1. Đăng ký tài khoản thành công
	public void Register_SuccessFully() throws InterruptedException
	{
		Page_Fact_btvnd14 register= new Page_Fact_btvnd14(driver);
		register.Register_Function("Thuy Nguyen","thuynguyen99@gmail.com", "thuynguyen99@gmail.com", "123456", "123456","0978765499");
		Thread.sleep(5000);
		assertTrue(driver.findElement(CT_Account.AVATAR_USER).isDisplayed());	
	}
	
	@Test (priority=2)
	//2. Đăng nhập tài khoản và vào chỉnh sửa thông tin
	public void Login_Successfully() throws InterruptedException {
	Page_Fact_btvnd14 login= new Page_Fact_btvnd14(driver);
	login.Login_Function("thuynguyen99@gmail.com","123456");
	Thread.sleep(5000);
	assertTrue(driver.findElement(CT_Account.AVATAR_USER).isDisplayed());
	login.Edit_Function();
	Thread.sleep(5000);
	assertTrue(driver.findElement(CT_Account.INFOMATION).isDisplayed());
	login.Change_Password("123456", "1234567", "1234567");
	}
	
	//3. Đăng nhập với pass mới
	@Test (priority=3)
	public void Login_Successfully_NewPass() throws InterruptedException {
		Page_Fact_btvnd14 login= new Page_Fact_btvnd14(driver);
		login.Login_Function("thuynguyen99@gmail.com","1234567");
		Thread.sleep(5000);
		assertTrue(driver.findElement(CT_Account.AVATAR_USER).isDisplayed());
	}
	
	@AfterMethod
	public void closeChrome() {
		closeDriver(); //đóng driver
	}
}
