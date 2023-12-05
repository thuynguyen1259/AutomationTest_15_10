package automation.constant;

import org.openqa.selenium.By;

public class CT_Account {
	
public static String RISE_URL = "https://rise.fairsketch.com/signin";
public static String TRIZEN_URL = "https://techydevs.com/demos/themes/html/trizen-demo/trizen/index.html"; 
public static By TEXT_EMAIL = By.id("email");
public static By TEXT_PASSWORD = By.id("password");
public static By BUTTON_SIGNIN = By.xpath("//button[text()='Sign in']");
public static By DASHBOARD =By.xpath("//span[text()='Dashboard' and @class='menu-text ']");
public static By AUTHENCATION_ALERT=By.xpath("//div[normalize-space()='Authentication failed!']");
public static By USER_DROPDOWN = By.xpath("//a[@id='user-dropdown']");
public static By BUTTON_LOGOUT=By.xpath("//a[text()=' Sign Out']");

public static By SIGNIN_TEXT=By.xpath("//h2[text()='Sign in']");

//////// BTVN day 14

public static String ALADA_URL = "https://alada.vn/";
public static By AVATAR_USER= By.xpath("//div[@class='avatar2']/img");
public static By INFOMATION =By.xpath("//a[text()='Thông tin chung']");

//BTVN day 15
public static By SEARCH_RESULT =By.xpath("//h2[text()='Flight Search Result']");


}


