package automation.testsuite;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class day12_Checkbox extends CommonBase{

	
	@BeforeMethod
	public void openChrome() {
		driver =initChromeDriver("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}
	@Test
	public void ClickCheckbox() {
		// kiểm tra rằng sau khi page được mở thì Default checked đã được check
		WebElement defaultChecked = driver.findElement(By.xpath("//div[text()='Single Checkbox Demo']/following::div//label[normalize-space()='Default Checked']//input[@type='checkbox']"));
		boolean status= defaultChecked.isSelected();
		System.out.println("Status is: "+ status);
		
		// kiểm tra rằng sau khi page được mở thì Default checked đã được check
		WebElement clickonthischeckbox = driver.findElement(By.xpath("//div[text()='Single Checkbox Demo']/following::div//label[normalize-space()='Click on this check box']//input[@type='checkbox']\n"
				+ ""));
		if(clickonthischeckbox.isSelected()==false) {
			clickonthischeckbox.click();
			System.out.println("check box click on this checkbox was checked");
			
		}
		//lấy xpath của default disable, tìm element này, Elemant.isEnable(), Element.isDisable()
	}
	@Test
	public void clickOnMultiCheckbox() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> ListCheckbox;
		//lấy tổng số check box
		ListCheckbox=driver.findElements(By.xpath("//div[text()='Multiple Checkbox Demo']/following-sibling::div[@class='panel-body']/child::div[@class='checkbox']//input"));
		for(int i=0; i<ListCheckbox.size();i++) {
			WebElement checkbox =ListCheckbox.get(i);
			if(checkbox.isSelected()==false) {
				checkbox.click();
				System.out.println("checkbox thu "+(i+1)+" đã được check");
			}
		}
	}
	
}
