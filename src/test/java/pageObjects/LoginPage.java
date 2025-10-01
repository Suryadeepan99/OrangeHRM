package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement txtusername;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btnlogin;
	
	public void setusername(String uname) {
		txtusername.sendKeys(uname);
	}
		
	public void setpassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void clickbtn() {
		btnlogin.click();
	}
	}


