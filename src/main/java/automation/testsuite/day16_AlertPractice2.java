package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class day16_AlertPractice2 extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://demo.automationtesting.in/Alerts.html");
	
	}
	
	@Test (priority=1)
	public void AlertWithOK() throws InterruptedException {
		click(By.xpath("//a[text()='Alert with OK ']"));
		click(By.xpath("//button[normalize-space()='click the button to display an alert box:']"));
		pause(3000);
		String msgConfirm=driver.switchTo().alert().getText();
		assertEquals(msgConfirm,"I am an alert box!");
		driver.switchTo().alert().accept();
	}
	
	@Test (priority=2)
	public void AlertWithOkAndCancel() throws InterruptedException {
		click(By.xpath("//a[text()='Alert with OK & Cancel ']"));
		click(By.xpath("//button[normalize-space()='click the button to display a confirm box']"));
		pause(3000);
		String msgCancel=driver.switchTo().alert().getText();
		assertEquals(msgCancel,"Press a Button !");
		driver.switchTo().alert().dismiss();
		assertTrue(isElementPresent(By.xpath("//p[@id='demo']")));
	}
	
	@Test (priority=3)
	public void AlertWithTextbox() throws InterruptedException {
		click(By.xpath("//a[text()='Alert with Textbox ']"));
		click(By.xpath("//button[text()='click the button to demonstrate the prompt box ']"));
		pause(3000);
		driver.switchTo().alert().sendKeys("Thuy Nguyen");
		driver.switchTo().alert().accept();
		assertTrue(isElementPresent(By.xpath("//p[@id='demo1']")));
	}
	
	
	@AfterMethod
	public void closeChrome() {
		closeDriver(); //đóng driver
	}
}
