package automation.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class TrizenPage {

		private WebDriver driver;
		@FindBy(xpath="(//label[text()='Departing'])[1]/following-sibling::div/input")
		WebElement textDepartingDate;
	
		@FindBy(xpath="(//label[text()='Passengers'])[1]/following-sibling::div/div")
		WebElement dropPassenger;
	
		@FindBy(xpath = "(//label[text()='Adults'])[1]/following-sibling::div//i[@class='la la-plus']")
		WebElement addAdult;
		
		@FindBy(id = "one-way-tab")
	    WebElement radioOneWay;
		
	    @FindBy(xpath = "//div[@id='one-way']//label[text()='Flying from']/following-sibling::div//input[1][@placeholder='City or airport']")
	    WebElement textFlyingFrom;
	    
	    @FindBy(xpath = "//div[@id='one-way']//label[text()='Flying to']/following-sibling::div//input[1][@placeholder='City or airport']")
	    WebElement textFlyingTo;
	    
	    @FindBy(xpath = "//div[@id='one-way']//button[@data-toggle='dropdown']")
	    WebElement dropCoach;
	    
	    @FindBy(xpath = "//div[@id='one-way']//a[text()='Search Now']")
	    WebElement buttonSearchNow;
	    
		

	public TrizenPage (WebDriver _driver) {
		this.driver=_driver;
		PageFactory.initElements(_driver, this);
	}
	public void HaddleDateTimeAndDrop() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('readonly', 'readonly')", textDepartingDate);
		textDepartingDate.clear();
		textDepartingDate.sendKeys("06122023");
		textDepartingDate.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		dropPassenger.click();
		addAdult.click();
		radioOneWay.click();
		textFlyingFrom.sendKeys("Ha Noi");
		textFlyingTo.sendKeys("Ho Chi Minh");
		Thread.sleep(5000);
		dropCoach.sendKeys("Business");
		buttonSearchNow.click();
		
	}
	
}
