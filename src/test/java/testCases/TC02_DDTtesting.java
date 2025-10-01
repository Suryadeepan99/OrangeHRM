package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import utilities.Dataprovider;

public class TC02_DDTtesting extends BaseClass{
	@Test(dataProvider="LoginData", dataProviderClass=Dataprovider.class,groups="Datadriven")
	public void verifylogin_DDT(String uname, String pwd, String exp) {
		try {
		logger.info("***login started***");
		LoginPage lp=new LoginPage(driver);
		lp.setusername(uname);
		lp.setpassword(pwd);
		lp.clickbtn();
		
		HomePage hp=new HomePage(driver);
		
		hp.admin();
		hp.Add();
		hp.userrole();
		hp.selectadmin();
		hp.setemployeename("A");
		hp.selectempname();
		hp.status();
		hp.selectEnabled();
		hp.setusername(randomstring().toLowerCase());
		String password=randonAlphanumeric();
		hp.setpassword(password);
		hp.setconfirmpassword(password);
		hp.savebutton();
		
		MyAccount acc=new MyAccount (driver);
		acc.clickmyaccount();
		acc.logout();
		
		if(exp.equalsIgnoreCase("Valid")) {
			acc.logout();
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
		}
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*** Data driven testing is completed ****");
	}
	

}
