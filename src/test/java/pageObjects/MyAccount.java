package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {

	public MyAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//img[@class='oxd-userdropdown-img']")
	WebElement clcmyacc;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement clclogout;
	
	public void clickmyaccount() {
		clcmyacc.click();
	}
	public void logout()
	{
		clclogout.click();
	}
	
	
}
