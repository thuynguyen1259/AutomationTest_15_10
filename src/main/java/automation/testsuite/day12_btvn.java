package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class day12_btvn extends CommonBase {
	
	@BeforeMethod
	public void openChrome() {
		driver =initChromeDriver("http://demo.seleniumeasy.com/input-form-demo.html");
	}
	
	@Test
	public void selectDropList() {
		WebElement select = driver.findElement(By.name("state"));
		Select dropdownlist=new Select(select);
		System.out.println("dropdownlist.isMultiple: " +dropdownlist.isMultiple());
		System.out.println("dropdownlist.getOptions: " +dropdownlist.getOptions().size());
		//chọn = index
		select.click();
		dropdownlist.selectByVisibleText("California");
		System.out.println("droplist option: "+dropdownlist.getFirstSelectedOption().getText());
		driver.close();
	}
	
	@Test
	public void selectRadio() throws InterruptedException {
		//Thread.sleep(2000);
		//kiểm tra giá trị măcj định của yes và no là chưa check
		WebElement radioYes=driver.findElement(By.xpath("//input[@value='yes']"));
		WebElement radioNo= driver.findElement(By.xpath("//input[@value='no']"));
		System.out.println("trạng thái của radio yes là :" +radioYes.isSelected());
		System.out.println("trạng thái của radio no là :" +radioNo.isSelected());
		//kiem tra raido chưa được check và click vào
		if(radioNo.isEnabled()==true && radioNo.isSelected()==false) {
			radioNo.click();
		}
		driver.close();
	}
}
