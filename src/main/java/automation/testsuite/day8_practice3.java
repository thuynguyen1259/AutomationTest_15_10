package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class day8_practice3 extends CommonBase  {

	@BeforeMethod
	public void openChrome() {
		driver =initChromeDriver ("https://selectorshub.com/xpath-practice-page/");
		
	}
	@Test
	public void getLocator() {
		//User Email, Password, Company, MobileNumber
	System.out.println("Lấy locator Username :"	+driver.findElement(By.id("userId")));
	System.out.println("Lấy locator Password :"	+driver.findElement(By.id("pass")));
	System.out.println("Lấy locator Company :"	+driver.findElement(By.name("company")));
	System.out.println("Lấy locator Mobile Number :"	+driver.findElement(By.name("mobile number")));

	}
	@AfterTest 
	public void closeChromeBrower() {
		driver.close();
	}
}
