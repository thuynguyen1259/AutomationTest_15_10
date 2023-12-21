package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class day17_btvn extends CommonBase {
	
	@Parameters("browser")
	@BeforeMethod
	public void openChrome(String browser) {
		setupDriver(browser);
		driver.get("https://mediamart.vn/");
	}
	@Test
	public void testZalo_iFrame() 
	{
		pause(5000);
		//tìm số lượng iframe
		int totaliframe=driver.findElements(By.tagName("iframe")).size();
		for(int i=0;i<totaliframe;i++) {
			try {	
			// tìm index của iframe
			driver.switchTo().frame(i);
			//tìm số lượng có zalo
			int totalZalo =driver.findElements(By.xpath("//div[@class='za-chat__head-box']")).size();
			System.out.println(" button gửi ngay: "+totalZalo);
			// nếu button zalo trong total khác 0 thì đứng tại iframe chưa element cần test
			if(totalZalo!=0)
			{
				click(By.xpath("//div[@class='za-chat__head-box']"));
				isElementPresent(By.xpath("//div[text()='Chat bằng Zalo']"));
				driver.switchTo().defaultContent();
			}
			else
			// đóng iframe trước khi chuyển sang iframe tiếp theo
			driver.switchTo().defaultContent();
		}
		//bắt exception
			catch(Exception e) {
				return;
			}
		}
	}
	@AfterMethod
	public void closeChrome() {
		closeDriver(); //đóng driver
	}

}

