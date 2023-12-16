package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class day17_HandlePopupWindow extends CommonBase {
	
	@BeforeMethod
	public void openChrome() {
		driver=initChromeDriver("https://demo.guru99.com/popup.php");
	}
	@Test
	public void testDemoGuru() {
		//sau khi vào website click vào click here > tìm window
		click(By.xpath("//a[text()='Click Here']"));
		//lấy tất cả window
		Set<String> listWindow=driver.getWindowHandles();
		//lấy main window
		String mainWindow=driver.getWindowHandle();
		for(String childWindow:listWindow) {
			if(!childWindow.equalsIgnoreCase(mainWindow))
			{
				driver.switchTo().window(childWindow);
				assertEquals(driver.getCurrentUrl(),"https://demo.guru99.com/articles_popup.php");
				type(By.xpath("//input[@name='emailid']"),"thuytest@gmail.com");
				click(By.xpath("//input[@name='btnLogin']"));
				isElementPresent(By.xpath("//h2[text()='Access details to demo site.']"));
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		assertEquals(driver.getCurrentUrl(),"https://demo.guru99.com/popup.php");
		
	}
}
