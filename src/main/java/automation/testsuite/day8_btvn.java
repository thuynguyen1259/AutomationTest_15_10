package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class day8_btvn extends CommonBase {
	
	@BeforeMethod
	public void openChrome() {
		driver =initChromeDriver ("https://automationfc.github.io/basic-form/index.html");
		
	}
	@Test(priority =1)
	public void getLocatorYourBasicInfo() {
		//Email, Password, Number, Age
		System.out.println("Lấy locator Email :"	+driver.findElement(By.id("mail")));
		System.out.println("Lấy locator Password :"	+driver.findElement(By.id("disable_password")));
		System.out.println("Lấy locator Number :" +driver.findElement(By.id("number")));
		System.out.println("Lấy locator Age under 18 :" +driver.findElement(By.id("under_18")));
		System.out.println("Lấy locator Age 18 or older :" +driver.findElement(By.id("over_18")));
		System.out.println("Lấy locator Age Radio button is disabled :" +driver.findElement(By.id("radio-disabled")));
		
	}
	@Test(priority=2)
	public void getLocatorYourProfile() {
		//Education, Biography, Job role 1,2,3, Interests, Languages, Slide 1,2; button
		System.out.println("Lấy locator Eduction :"	+driver.findElement(By.name("user_edu"))); //có thể dùng by.id("edu")
		System.out.println("Lấy locator Biography :"	+driver.findElement(By.name("user_bio")));
		System.out.println("Lấy locator Role Job1 :" +driver.findElement(By.id("job1")));
		System.out.println("Lấy locator Role Job2 :" +driver.findElement(By.id("job2")));
		System.out.println("Lấy locator Interest Development :" +driver.findElement(By.id("development")));
		System.out.println("Lấy locator Interest Design :" +driver.findElement(By.id("design")));
		System.out.println("Lấy locator Interest checkbox disable :" +driver.findElement(By.id("check-disbaled")));
		System.out.println("Lấy locator Language java :" +driver.findElement(By.id("java"))); // hoặc by.name("java")
		System.out.println("Lấy locator Slide 1 :" +driver.findElement(By.id("slider-1"))); // hoặc by.name("slider-1")
		System.out.println("Lấy Button is disable :" +driver.findElement(By.id("button-disabled"))); 
		System.out.println("Lấy Button is enable :" +driver.findElement(By.id("button-enabled"))); 

	}
	@Test(priority=3)
	public void getLocatorTable() {
		System.out.println("Lấy Element is display :"	+driver.findElement(By.linkText("Element is display"))); 
		System.out.println("Lấy Element is disable :"	+driver.findElement(By.linkText("Element is disable"))); 
		System.out.println("Lấy Element is select :"	+driver.findElement(By.partialLinkText("select"))); 

	}
	@Test(priority=4)
	public void getLocatorWindow() {
		System.out.println("Lấy Google :"	+driver.findElement(By.linkText("GOOGLE"))); 
		System.out.println("Lấy Facebook :"	+driver.findElement(By.linkText("FACEBOOK"))); 		

	}
	@Test(priority=5)
	public void getLocatorFile() {
		System.out.println("Lấy file download :"	+driver.findElement(By.linkText("download.txt"))); 
		
	}
	@Test(priority=6)
	public void getLocatorHover() {
		System.out.println("Lấy locator hover image 1 :"	+driver.findElement(By.linkText("download.txt"))); 
		
	}
	
	
	@AfterTest 
	public void closeChromeBrower() {
		driver.close();
	}
}
