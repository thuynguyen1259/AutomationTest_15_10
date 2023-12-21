package automation.common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonBase {
	public WebDriver driver;
	private int initWaitTime =10;
	public WebDriver initChromeDriver(String URL)
	{
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver",
		System.getProperty("user.dir") + "/driver/chromedriver");			
		// For MAC: System.getProperty("user.dir") + "/driver/chromedriver");	
		driver = (WebDriver) new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}
	
	/*hàm isDisplayed()
	- happy case: sẽ trả về true
	- negative case: isDisplayed() trả về false
	=> hoặc trước khi chạy đến isDislayed() đã bị exception ở 1 dòng code nào đó trước đó
	=> catch exception và return false
	*/
	public boolean isElementPresent(By locator) {
		try {
			//long initWaitTime = 10;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		} catch (org.openqa.selenium.TimeoutException e2) {
			return false;
		}
	}
	
	/*handle Click()
	- happy case: findElement và click thành công
	- negative case: 2 case
	1. Findelement văng ra exception(xử lý đợi explicit wait cho hàm FindElement)
	2. elementToBeClickable bị exception do element đó không cho phép Click(ElementClickInterceptedException)
	*/
	//1. FindElement văng ra exception(xử lý đợi explicit wait cho hàm FindElement)
	public WebElement getElementPresentDOM(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}
	public void click(By locator) {
		WebElement element = getElementPresentDOM(locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	//2. elementToBeClickable bị exception do element đó không cho phép Click(ElementClickInterceptedException)
	public void clickByJsExecutor(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", locator);
	}
	
	/*handle Sendkeys()
	- happy case: findElement và sendkey thành công
	- negative case: 2 case
	1. Findelement văng ra exception(xử lý đợi explicit wait cho hàm FindElement) => done bằng getElementPresentDOM
	2. SendKeys không thành công do element readonly/ không cho nhập bằng bình thường (ElementNotInteractableException)
	*/
	//	1. Findelement văng ra exception(xử lý đợi explicit wait cho hàm FindElement) => done bằng getElementPresentDOM
	public void type(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		element.clear();
		element.sendKeys(value);
	}
	//	2. SendKeys không thành công do element readonly/ không cho nhập bằng bình thường (ElementNotInteractableException)
		//nếu có value thì sử dụng sendkey = value
	public void typeInValue_ByJsExecutor(By locator, String value) throws InterruptedException {
		WebElement element = getElementPresentDOM(locator);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + value + "'", element);
		} catch (StaleElementReferenceException ex) {
			Thread.sleep(1000);
			typeInValue_ByJsExecutor(locator, value);
		}
	}
		//nếu không có value sử dụng inner HTML
	public void inputTextJavaScript_ToInnerHTMLAttribute(By inputElement, String value) throws InterruptedException {
		WebElement element = driver.findElement(inputElement);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			executor.executeScript("arguments[0].innerHTML = '" + value + "'", element);
		} catch (StaleElementReferenceException ex) {
			//Thread.sleep(1000);
			pause(1000);
			inputTextJavaScript_ToInnerHTMLAttribute(inputElement, value);
		}
	}
	
	// Handle Thread.sleep(miliSeconds);
		public void pause(long miliSeconds)
		{
			try {
				Thread.sleep(miliSeconds);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Handle Scroll tới element MÀ VẪN NHÌN THẤY TRÊN MÀN HÌNH (scroll đến element cuối cùng nhìn thấy trên màn hình)
		public void scrollToElement(By locator) {
			WebElement element = getElementPresentDOM(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		}
	
	public void closeDriver()
	{
		if(driver!=null)
		{
			driver.close();
		}
	}
	private WebDriver initChromeDriver()
	{
		System.out.println("Lauching system on chrome driver..");;
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver",
		System.getProperty("user.dir") + "/driver/chromedriver");			
		// For MAC: System.getProperty("user.dir") + "/driver/chromedriver");	
		driver =  new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		return driver;
	}
	
	public WebDriver initFirefoxDriver()
	{
		System.out.println("Lauching system on firefix driver..");;
		FirefoxOptions options = new FirefoxOptions();
		System.setProperty("webdriver.firefox.driver",
		System.getProperty("user.dir") + "/driver/geckodriver");			
		// For MAC: System.getProperty("user.dir") + "/driver/chromedriver");	
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		//driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		return driver;
	}
	public WebDriver initMSEgdeDriver()
	{
		System.out.println("Lauching system on Edge driver..");;
		EdgeOptions options = new EdgeOptions();
		System.setProperty("webdriver.edge.driver",
		System.getProperty("user.dir") + "/driver/msedgedriver");			
		// For MAC: System.getProperty("user.dir") + "/driver/chromedriver");	
		driver =  new EdgeDriver(options);
		driver.manage().window().maximize();
		//driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		return driver;
	}
	public WebDriver setupDriver(String browserName) {
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver=initChromeDriver();
			break;
		case "firefox":
			driver=initFirefoxDriver();
			break;
		case "edge":
			driver = initMSEgdeDriver();
			break;
		default:
			System.out.println("No browser name was passed in prametter");
			driver = initChromeDriver();
		}
		return driver;
	}
	
}