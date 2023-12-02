package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Factory {
	private WebDriver driver;
	
	@FindBy (id="email")
	WebElement textEmail;
	
	@FindBy (id="password")
	WebElement textPassword;
	
	@FindBy (xpath="//button[text()='Sign in']")
	WebElement btnSignin;
	
	@FindBy (xpath="//a[@id='user-dropdown']")
	WebElement linkAvatar;
	
	@FindBy (xpath="//a[text()=' Sign Out']")
	WebElement btnLogout;

	
	public LoginPage_Factory(WebDriver _driver) {
		this.driver=_driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void LoginFunction(String email, String pass) {
		textEmail.clear();
		textEmail.sendKeys(email);
		textPassword.clear();
		textPassword.sendKeys(pass);
		btnSignin.click();
	
	}
	public void LogoutFunction() {
		linkAvatar.click();
		btnLogout.click();
	}

}
