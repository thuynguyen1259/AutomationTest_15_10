package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class day12_radiobutton extends CommonBase {
	
	@BeforeMethod
	public void openChrome() {
		driver =initChromeDriver("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
	}
 
	@Test
	public void testRadiobutton () {
		//kiểm tra giá trị măcj định của male và female là chưa check
		WebElement radioMale=driver.findElement(By.xpath("//input[@value='Male']"));
		WebElement radioFemale= driver.findElement(By.xpath("//input[@value='Female']"));
		System.out.println("trạng thái của radio male là :" +radioMale.isSelected());
		System.out.println("trạng thái của radio Female là :" +radioFemale.isSelected());
		//kiem tra raido chưa được check và click vào
		if(radioFemale.isEnabled()==true && radioFemale.isSelected()==false) {
			radioFemale.click();
		}
		else if (radioMale.isEnabled()==true && radioMale.isSelected()==false) {
			radioMale.click();
		}
		
		driver.close();
	}
}
