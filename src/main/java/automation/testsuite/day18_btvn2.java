package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class day18_btvn2 extends CommonBase {
	
	@Parameters("browser")
	@BeforeMethod
	public void openChrome1(String browser) {
		setupDriver(browser);
		driver.get("https://bepantoan.vn/");
	}

	
	@Test
	public void testChat() {
		
		pause(5000);
		//tìm số lượng iframe
		int totaliframe=driver.findElements(By.tagName("iframe")).size();
		for(int i=0;i<totaliframe;i++) {
			// tìm index của iframe
			driver.switchTo().frame(i);
			//tìm số lượng có button chat ngay
			int totalChatNgay =driver.findElements(By.xpath("//div[text()=' Chát Ngay Với Chúng Tôi ! ']")).size();
			System.out.println(" button Chat ngay với chúng tôi: "+totalChatNgay);
			if(totalChatNgay!=0)
			{
				click(By.xpath("//div[text()=' Chát Ngay Với Chúng Tôi ! ']"));
				isElementPresent(By.xpath("//button[text()=' I accept ']"));
				driver.switchTo().defaultContent();
			}
			else
			// đóng iframe trước khi chuyển sang iframe tiếp theo
			driver.switchTo().defaultContent();
		}
	}
	@AfterMethod
	public void closeChrome() {
		closeDriver(); //đóng driver
	}
}
