package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class day8_practice2 extends CommonBase {

	@BeforeMethod // annotation (chú thích) khởi tạo
	public void openChrome() {
		driver = initChromeDriver("https://bepantoan.vn/danh-muc/bep-gas");
		
	}
	@Test(priority=1)
	public void getLocatorByText() {
		WebElement linktext = driver.findElement(By.linkText("Máy Rửa Chén Bát"));
		System.out.println("locator may rua chen bat là :" + linktext);
		
		WebElement textBepGa = driver.findElement(By.partialLinkText("Bếp Gas Giá Rẻ"));
		System.out.println("locator của text bếp ga giá rẻ là :" + textBepGa);
	}
	@Test(priority=2)
	public void getLocatorByClassName_TagName() {
		System.out.println("locator của checkbox england là :"+driver.findElement(By.className("cursor-pointer")));
		System.out.println("số lượng của checkbox england là :"+driver.findElements(By.className("cursor-pointer")).size());// elements số lượng
		System.out.println("thẻ có tên input là :"+driver.findElement(By.tagName("input")));
	}
	
	@AfterTest 
	public void closeChromeBrower() {
		driver.close();
	}
}
