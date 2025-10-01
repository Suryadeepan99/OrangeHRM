package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC_Addadminusers extends BaseClass {    
    
    @Test(groups={"Regression","Master"})
    public void verifyadminuser() {
        
        logger.info("**** Login page automation start ****");
        try {
            LoginPage lp = new LoginPage(driver);
            lp.setusername("Admin");
            logger.info("Entered username");

            lp.setpassword("admin123");
            logger.info("Entered password");

            lp.clickbtn();

            HomePage hp = new HomePage(driver);
            hp.admin();
            hp.Add();
            logger.info("Providing admin details");

            hp.userrole();
            hp.selectadmin();
            hp.setemployeename("A");
            hp.selectempname();
            hp.status();
            hp.selectEnabled();

            String username = randomstring().toLowerCase();
            hp.setusername(username);

            String password = randonAlphanumeric();
            hp.setpassword(password);
            hp.setconfirmpassword(password);
            hp.savebutton();

        } catch(Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail();
        }

        logger.info("Automation script finished");
    }
}
