package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//span[normalize-space()='Admin']")
	WebElement btnadmin;
	
	@FindBy(xpath="//button[normalize-space()='Add']")
	WebElement btnAdd;
	
	@FindBy (xpath="//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-2 orangehrm-full-width-grid']/div[1]/div[1]/div[2]/div[1]/div[1]")
	WebElement userroledrp;
	
	@FindBy (xpath="//span[contains(text(),'Admin')]")
	WebElement selAdmin;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement txtEmpname;
	
	@FindBy(xpath="//span[contains(text(),'Ranga')]")
	WebElement selempname;
	//span[normalize-space()='A8DCo 4Ys 010Z']
	//span[contains(text(),'Ranga')]
	//span[normalize-space()='A8DCo 4Ys 010Z']
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]")
	WebElement statusdrp;
	
	@FindBy(xpath="//span[normalize-space()='Enabled']")
	WebElement selenabled;
	
	@FindBy(xpath="//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	WebElement txtusername;
	
	@FindBy (xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
	WebElement txtpassword;
	
	@FindBy (xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
	WebElement txtconfirmpassword;
	
	@FindBy (xpath="//button[normalize-space()='Save']")
	WebElement clksave;

	
	public void admin() {
		btnadmin.click();;
	}
	public void Add()
	{
		btnAdd.click();
	}
	public void userrole()
	{
		userroledrp.click();
	}
	public void selectadmin()
	{
		selAdmin.click();
	}
	public void setemployeename(String empname)
	{
		txtEmpname.sendKeys(empname);
	}
	public void selectempname()
	{
		selempname.click();
	}
	public void status()
	{
		statusdrp.click();
	}
	public void selectEnabled()
	{
		selenabled.click();
	}
	public void setusername(String uname)
	{
		txtusername.sendKeys(uname);
	}
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	public void setconfirmpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	public void savebutton()
	{
		clksave.click();
	}
	
	
	


}
