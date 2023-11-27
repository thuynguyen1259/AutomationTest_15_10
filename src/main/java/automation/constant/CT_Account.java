package automation.constant;

import org.openqa.selenium.By;

public class CT_Account {
	
public static String RISE_URL = "https://rise.fairsketch.com/signin";
public static By TEXT_EMAIL = By.id("email");
public static By TEXT_PASSWORD = By.id("password");
public static By BUTTON_SIGNIN = By.xpath("//button[text()='Sign in']");
public static By DASHBOARD =By.xpath("//span[text()='Dashboard' and @class='menu-text ']");
public static By AUTHENCATION_ALERT=By.xpath("//div[normalize-space()='Authentication failed!']");
public static By USER_DROPDOWN = By.xpath("//a[@id='user-dropdown']");
public static By BUTTON_LOGOUT=By.xpath("//a[text()=' Sign Out']");
}
