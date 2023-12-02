package automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.constant.CT_Account;

public class LoginPage {

private WebDriver driver;

	public LoginPage(WebDriver _driver) 
	{
		this.driver=_driver;
	}
	
	public void LoginFunction(String emailValue, String passValue)
	{
		//driver.findElement(By.id("email"));
		WebElement email=driver.findElement(CT_Account.TEXT_EMAIL);
		if(email.isEnabled())
		{
			email.clear();
			email.sendKeys(emailValue);
		}
		WebElement pass =driver.findElement(CT_Account.TEXT_PASSWORD);
		if(pass.isEnabled())
		{
			pass.clear();
			pass.sendKeys(passValue);
		}
		WebElement login  =driver.findElement(CT_Account.BUTTON_SIGNIN);
		if(login.isEnabled())
		{
			login.click();
		}
	}
	public void LogoutFuntion()
	{
		WebElement userdropdown =driver.findElement(CT_Account.USER_DROPDOWN);
		if(userdropdown.isEnabled())
		{
		userdropdown.click();
		}
		WebElement logout=driver.findElement(CT_Account.BUTTON_LOGOUT);
		if(logout.isEnabled())
		{
		logout.click();
		}
	}
}
