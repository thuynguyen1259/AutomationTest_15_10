package automation.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPage {

	private WebDriver driver;
	@FindBy(xpath = "//span[text()='Clients']")
	WebElement clientLinks;
	
	@FindBy(xpath="//a[@data-title='Add client']")
	WebElement clientButton;
	
	@FindBy(id="type_person")
	WebElement radioPersion;
	
	@FindBy(id="company_name")
	WebElement textboxClientName;
	
	@FindBy(id="s2id_created_by")
	WebElement ownerDropdownlist;
	
	@FindBy(xpath = "//ul[@id='select2-results-3']//div[text()='Sara Ann']")
	WebElement ownerItem; 
	
	@FindBy(id ="address")
	WebElement textAddress;
	
	@FindBy(id ="city")
	WebElement textCity;
	
	@FindBy(id ="state")
	WebElement textState;
	
	@FindBy(id ="zip")
	WebElement textZip;
	
	@FindBy(id="country")
    WebElement textCountry;
	
    @FindBy(id="phone")
    WebElement textPhone;
    
    @FindBy(id="website")
    WebElement textWebsite;
    
    @FindBy(id="vat_number")
    WebElement textVATNumber;
    
    @FindBy(id="gst_number")
    WebElement textGSTNumber;
    
    @FindBy(id = "s2id_group_ids")
    WebElement dropGroup;
    
    @FindBy(xpath="//ul[@class='select2-results']//div[text()='Gold']")
    WebElement groupItem;
    
    @FindBy(id = "s2id_currency")
    WebElement dropCurrency;
    
    @FindBy(xpath="//ul[@id='select2-results-1']//div[text()='AUD']")
    WebElement currencyItem;
    
    @FindBy(id = "currency_symbol")
    WebElement textCurrencySymbol;
    
    @FindBy(id = "s2id_client_labels")
    WebElement dropClientLabels;
    
    @FindBy(xpath="//ul[@class='select2-results']//div[text()='Unsatisfied']")
    WebElement labelItem;
    
    @FindBy(id="disable_online_payment")
    WebElement checkboxDisableOnlinePayment;
	
	@FindBy(xpath="//button[@type='submit' and normalize-space()='Save']")
	WebElement buttonSave;
	
	@FindBy(xpath="//a[text()='Clients']")
	WebElement clientsTab;
	
	@FindBy(xpath="//input[@type='search' and @placeholder='Search']")
	WebElement textboxSearch;
	
	public ClientPage (WebDriver _driver) {
		this.driver=_driver;
		PageFactory.initElements(_driver, this);
	}
	public void AddClientFunction(String companyName, String Owner, 
			String Address, String City, String State, String Zip, String Country, String Phone, String Website, String VAT_Number,
		    String GST_Number, String Client_groups, String Currency, String Currency_Symbol, String Label) throws InterruptedException {
		//pre condition: login
		Thread.sleep(5000);
		clientLinks.click();
		clientButton.click();
		Thread.sleep(5000);
		radioPersion.click();
		textboxClientName.sendKeys(companyName);
		Thread.sleep(5000);
		ownerDropdownlist.click();
		ownerItem.click();
		textAddress.sendKeys(Address);
        textCity.sendKeys(City);
        textState.sendKeys(State);
        textZip.sendKeys(Zip);
        textCountry.sendKeys(Country);
        textPhone.sendKeys(Phone);
        textWebsite.sendKeys(Website);
        textVATNumber.sendKeys(VAT_Number);
        textGSTNumber.sendKeys(GST_Number);
        Thread.sleep(5000);
        dropGroup.click();
        groupItem.click();
        Thread.sleep(5000);
        dropCurrency.click();
        currencyItem.click();
        textCurrencySymbol.sendKeys(Currency_Symbol);
		Thread.sleep(5000);
		dropClientLabels.click();
		labelItem.click();
		buttonSave.click();
		Thread.sleep(5000);
		//assert add client successful
		//clientsTab.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", clientsTab);
		Thread.sleep(5000);
		textboxSearch.sendKeys(companyName);
	}
}
