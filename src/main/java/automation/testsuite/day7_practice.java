package automation.testsuite;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class day7_practice extends CommonBase {
 @BeforeTest
 public void openChrome() {
	 driver = initChromeDriver("https://bepantoan.vn/");
			 
 	}
 @Test
 public void Test() {
	 System.out.println("hello my first project");
 }
 
}
