package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class day17_handleIframe extends CommonBase {
	
	@Parameters("browser")
	@BeforeMethod
	public void openChrome1(String browser) {
		setupDriver(browser);
		driver.get("https://codestar.vn/");
	}
	@Test
	public void testGuiNgay_iFrame() 
	{
		pause(5000);
		//tìm số lượng iframe
		int totaliframe=driver.findElements(By.tagName("iframe")).size();
		for(int i=0;i<totaliframe;i++) {
			// tìm index của iframe
			driver.switchTo().frame(i);
			//tìm số lượng có button gửi ngay
			int totalGuiNgay =driver.findElements(By.xpath("//button[text()='Gửi ngay']")).size();
			System.out.println(" button gửi ngay: "+totalGuiNgay);
			// nếu button gửi ngay trong total khác 0 thì đứng tại iframe chưa element cần test
			if(totalGuiNgay!=0)
			{
				type(By.id("account_phone"),"0976123456");
				click(By.xpath("//button[text()='Gửi ngay']"));
				isElementPresent(By.xpath("//button[text()='Gửi ngay']"));
				driver.switchTo().defaultContent();
			}
			else
			// đóng iframe trước khi chuyển sang iframe tiếp theo
			driver.switchTo().defaultContent();
		}
	}
	@Test
	public void testDangKyNgay_iFrame() 
	{
		pause(5000);
		//tìm số lượng iframe
		int totaliframe=driver.findElements(By.tagName("iframe")).size();
		for(int i=0;i<totaliframe;i++) {
			// tìm index của iframe
			driver.switchTo().frame(i);
			//tìm số lượng có button đăng ký ngay
			int totalGDangKyNgay =driver.findElements(By.xpath("//button[text()='Đăng ký ngay']")).size();
			System.out.println(" button đăng ký ngay: "+totalGDangKyNgay);
			// nếu button đăng ký ngay trong total khác 0 thì đứng tại iframe chưa element cần test
			if(totalGDangKyNgay!=0)
			{
				type(By.id("account_phone"),"0976123456");
				type(By.xpath("//input[@name='account_name']"),"thuynguyen");
				click(By.xpath("//button[text()='Đăng ký ngay']"));
				isElementPresent(By.xpath("//button[text()='Đăng ký ngay']"));
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
