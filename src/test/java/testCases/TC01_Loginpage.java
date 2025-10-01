package testCases;

import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class TC01_Loginpage extends BaseClass{
	@Test(groups={"Sanity","Master"})
	public void verifylogin() {
		LoginPage lp=new LoginPage(driver);
	
		lp.setusername("Admin");
		lp.setpassword("admin123");
		lp.clickbtn();
		
	}

}
