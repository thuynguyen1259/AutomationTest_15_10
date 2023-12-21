package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class day18_btvn1 extends CommonBase {

	@Parameters("browser")
	@BeforeMethod
	public void openChrome1(String browser) {
		setupDriver(browser);
		driver.get("https://dienmaynhapkhaugiare.com.vn/");
	}
	@Test
	public void testZalo() {
		//sau khi vào website click vào zalo > tìm window
		click(By.xpath("//div[@id='zalo-vr']"));
		//lấy tất cả window
		Set<String> listWindow=driver.getWindowHandles();
		//lấy main window
		String mainWindow=driver.getWindowHandle();
		for(String childWindow:listWindow) {
			if(!childWindow.equalsIgnoreCase(mainWindow))
			{
				driver.switchTo().window(childWindow);
				assertEquals(driver.getCurrentUrl(),"https://zalo.me/0988169282");
			}
		}
		
	}
	@AfterMethod
	public void closeChrome() {
		closeDriver(); //đóng driver
	}
	
}
