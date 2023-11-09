package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class day8_practice1 extends CommonBase {
	@BeforeTest
	public void openChromeBrower () {
		driver=initChromeDriver("https://rise.fairsketch.com/signin");
	}
	@Test
	public void getLocatorById_Name_ClassName() {
		WebElement emailElement = driver.findElement(By.id("email"));
		System.out.println("email is "+ emailElement);
		WebElement passwordElement = driver.findElement(By.id("password"));
		System.out.println("email is "+ passwordElement);
		WebElement buttonElement = driver.findElement(By.className("w-100"));
		System.out.println("Sign in button is "+ buttonElement);
	}
	@AfterTest
	public void closeChromeBrower() {
		driver.close();
	}
}
