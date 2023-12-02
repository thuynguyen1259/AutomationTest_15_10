package automation.testsuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.page.LoginPage_Factory;

public class LoginTest_Factory extends CommonBase {

	@BeforeMethod
	public void openChrome() {
		driver=initChromeDriver(CT_Account.RISE_URL);
	}

	@Test (priority=1)
	//1. đăng nhập thành công, username và password đúng => show màn dashboard
	public void LoginSuccessFully()
	{
		LoginPage_Factory login= new LoginPage_Factory(driver);
		login.LoginFunction("client@demo.com", "riseDemo");
		assertTrue(driver.findElement(CT_Account.DASHBOARD).isDisplayed());	
	}
	
	@Test(priority=2)
	//2. đăng nhập thất bại, email sai, pass đúng => show msg lỗi
	public void LoginFail_IncorrectEmail()
	{
		LoginPage_Factory login= new LoginPage_Factory(driver);
		login.LoginFunction("client_incorrect@demo.com", "riseDemo");
		//assertTrue(driver.findElement(CT_Account.AUTHENCATION_ALERT).isDisplayed());
		assertFalse(isElementPresent(CT_Account.DASHBOARD));	
	}
	
	@Test(priority=3)
	//3. đăng nhập thất bại, email đúng, pass sai => show msg lỗi
	public void LoginFail_IncorrectPass()
	{
		LoginPage_Factory login= new LoginPage_Factory(driver);
		login.LoginFunction("client@demo.com", "riseDemoIncorrect");
		assertTrue(driver.findElement(CT_Account.AUTHENCATION_ALERT).isDisplayed());	
	}
	
	@Test(priority=4)
	//4. đăng nhập thất bại, email và pass đều sai => show msg lỗi
	public void LoginFail_IncorrectEmailPass()
	{
		LoginPage_Factory login= new LoginPage_Factory(driver);
		login.LoginFunction("client_incorrect@demo.com", "riseDemoIncorrect");
		assertTrue(driver.findElement(CT_Account.AUTHENCATION_ALERT).isDisplayed());	
	}
	
	@Test (priority=5)
	//5. logout thành công => show về form sign in
	public void LogOutSuccessfully() throws InterruptedException
	{
		LoginPage_Factory login= new LoginPage_Factory(driver);
		login.LoginFunction("client@demo.com", "riseDemo");
		assertTrue(driver.findElement(CT_Account.DASHBOARD).isDisplayed());	
		Thread.sleep(2000);
		login.LogoutFunction();
		assertTrue(driver.findElement(CT_Account.SIGNIN_TEXT).isDisplayed());	
	}
	
	@AfterMethod
	public void closeChrome() {
		closeDriver(); //đóng driver
	}
	
}
