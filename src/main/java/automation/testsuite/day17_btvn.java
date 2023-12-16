package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class day17_btvn extends CommonBase {
	
	@BeforeMethod
	public void openChrome() {
		driver=initChromeDriver("https://mediamart.vn/");
	}
	@Test
	public void testZalo_iFrame() 
	{
		pause(5000);
		//tìm số lượng iframe
		int totaliframe=driver.findElements(By.tagName("iframe")).size();
		//for(int i=0;i<totaliframe;i++) {
			// tìm index của iframe
			driver.switchTo().frame(0);
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
	@AfterMethod
	public void closeChrome() {
		closeDriver(); //đóng driver
	}

}
