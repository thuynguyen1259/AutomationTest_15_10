package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class day12_dropdownlist extends CommonBase {
	
	@BeforeMethod
	public void openChrome() {
		driver =initChromeDriver("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
	}
	@Test
	public void selectDropList() throws InterruptedException {
		WebElement select = driver.findElement(By.id("select-demo"));
		Select dropdownlist=new Select(select);
		System.out.println("dropdownlist.isMultiple: " +dropdownlist.isMultiple());
		System.out.println("dropdownlist.getOptions: " +dropdownlist.getOptions().size());

		// chọn =cách value
		select.click();
		dropdownlist.selectByValue("Thursday");
		System.out.println("droplist first option: "+dropdownlist.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		
		// chon sunday = cách visible text
		select.click();
		dropdownlist.selectByVisibleText("Sunday");
		System.out.println("droplist second option: "+dropdownlist.getFirstSelectedOption().getText());
		Thread.sleep(2000);

		//chọn = cách index
		select.click();
		System.out.println("droplist third option: "+dropdownlist.getFirstSelectedOption().getText());
		dropdownlist.selectByIndex(3);
		

		
	}
}


