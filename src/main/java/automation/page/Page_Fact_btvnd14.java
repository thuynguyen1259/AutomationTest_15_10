package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_Fact_btvnd14 {

private WebDriver driver;
	// đăng ký
	@FindBy (xpath="//a[text()='Đăng Ký']")
	WebElement btnRegister;

	@FindBy (id="txtFirstname")
	WebElement textName;
	
	@FindBy (id="txtEmail")
	WebElement textEmail;

	@FindBy (id="txtCEmail")
	WebElement textCEmail;
	
	@FindBy (id="txtPassword")
	WebElement textPassword;
	
	@FindBy (id="txtCPassword")
	WebElement textCPassword;
	
	@FindBy (id="txtPhone")
	WebElement textPhone;
	
	@FindBy (id="chkRight")
	WebElement checkRight;
	
	@FindBy (xpath="//button[text()='ĐĂNG KÝ' and @type='submit']")
	WebElement btnSubmitRegister;
	
	////=======đăng nhập
	
	@FindBy (xpath="//a[text()='Đăng Nhập']")
	WebElement btnLogin;
	
	@FindBy (id="txtLoginUsername")
	WebElement textLoginUsername;
	
	@FindBy (id="txtLoginPassword")
	WebElement textLoginPassword;
	
	@FindBy (xpath="//button[text()='ĐĂNG NHẬP' and @type='submit']")
	WebElement btnSubmitLogin;
	
	//=====đổi pass
	@FindBy (xpath="//div[@class='avatar2']/img")
	WebElement btnAvatar;
	
	@FindBy (xpath="//a[text()='Chỉnh sửa thông tin']")
	WebElement btnEditAccount;
	
	@FindBy (id="txtpassword")
	WebElement textOldPassword;
	
	@FindBy (id="txtnewpass")
	WebElement textNewPassword;
	
	@FindBy (id="txtrenewpass")
	WebElement textRenewPassword;
	
	@FindBy (xpath="//button[text()='Lưu mật khẩu mới']")
	WebElement btnSave;
	
	public Page_Fact_btvnd14(WebDriver _driver) {
		this.driver=_driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void Register_Function(String name, String email, String cemail, String pass, String cpass, String phone)
	{	
		btnRegister.click();
		textName.clear();
		textName.sendKeys(name);
		textEmail.clear();
		textEmail.sendKeys(email);
		textCEmail.clear();
		textCEmail.sendKeys(cemail);
		textPassword.clear();
		textPassword.sendKeys(pass);
		textCPassword.clear();
		textCPassword.sendKeys(cpass);
		textPhone.clear();
		textPhone.sendKeys(phone);
		if (checkRight.isSelected()==false){
			checkRight.click();
        }
		btnSubmitRegister.click();
		
	}
	public void Login_Function(String email, String pass) {
		btnLogin.click();
		textLoginUsername.clear();
		textLoginUsername.sendKeys(email);
		textLoginPassword.clear();
		textLoginPassword.sendKeys(pass);
		btnSubmitLogin.click();
	}
	public void Edit_Function() {
		btnAvatar.click();
		btnEditAccount.click();
	}
	public void Change_Password(String oldPass, String newPass, String renewPass) {
		textOldPassword.clear();
		textOldPassword.sendKeys(oldPass);
		textNewPassword.clear();
		textNewPassword.sendKeys(newPass);
		textRenewPassword.clear();
		textRenewPassword.sendKeys(renewPass);
		btnSave.click();
		
		
	}
}
