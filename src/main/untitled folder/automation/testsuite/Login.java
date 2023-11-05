package automation.testsuite;

import org.junit.Test;
import org.testng.annotations.BeforeTest;

import automation.common.CommonBase;

public class Login extends CommonBase{
	@BeforeTest
	public void openChrome() {
		driver=initChromeDriver ("https://bepantoan.vn/");
	}
	@Test
	public void Test() {
		System.out.println("hello my first project");
	}
	
}
