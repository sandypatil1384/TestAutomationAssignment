package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002_ProfileTest extends BaseClass {
	@Test (priority = 0) // (groups= {"Regression","Master"})
	public void test_Login() throws InterruptedException {
		logger.debug("application logs......");
		logger.info("***  Starting TC_002_LoginTest ***");
		try {

			HomePage hp = new HomePage(driver);
			hp.clickSignIn();
			logger.info("Clicked on Sign In");

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(rb.getString("email"));

			lp.setPassword(rb.getString("password"));

			lp.clickLogin();

			Thread.sleep(10000);

			ProfilePage pp = new ProfilePage(driver);
			boolean targetPage = pp.isMyAccountPageExists();
			Assert.assertEquals(targetPage, true, "Invalid Login Data");

		} catch (Exception e) {
			logger.error("test failed");
			Assert.fail();
		}

		logger.info("***  Finished TC_002_LoginTest ***");
	}

	@Test (priority = 1, dataProvider = "ContactData", dataProviderClass = DataProviders.class)
	public void test_ContactInfo(String firstname, String lastname, String exp) throws InterruptedException {
		try {

			ProfilePage pp = new ProfilePage(driver);
			pp.myAccount();

			logger.info("Clicked on My account link");

			pp.profile();
			logger.info("Clicked on Profile link");

			logger.info("Providing customer data");

			Thread.sleep(3000);
			String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
			pp.setFirstName(del + firstname);

			
			pp.setLastName(del + lastname);

			pp.saveChanges();
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-250)");

			

			/*
			 * pp.setOldPassword(rb.getString("password"));
			 * 
			 * pp.setNewPassword(rb.getString("newpassword"));
			 * 
			 * pp.setConfirmPassword(rb.getString("confirmpassword"));
			 * 
			 * pp.submit();
			 * 
			 * logger.info("Clicked on Save Changes");
			 */

			String confmsg = pp.getConfirmationMsg();

			logger.info("Validating expected message");
			Assert.assertEquals(confmsg, "Your changes have been saved.", "Test failed");

			

		} catch (Exception e) {
			logger.error("test failed");
			Assert.fail();
		}

		logger.info("***  Finished TC_002_ProfileUpdateTest ***");
	}
	
	@Test(priority = 2, dataProvider = "PasswordData", dataProviderClass = DataProviders.class)
	public void test_ResetPass(String oldpass, String newpass, String confirm) throws InterruptedException {
		try {

			ProfilePage pp = new ProfilePage(driver);
			pp.myAccount();

			logger.info("Clicked on My account link");

			pp.profile();
			logger.info("Clicked on Profile link");

			logger.info("Providing customer data");

			/*
			 * Thread.sleep(3000); String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
			 * pp.setFirstName(del + firstname);
			 * 
			 * 
			 * pp.setLastName(del + lastname);
			 * 
			 * pp.saveChanges();
			 * 
			 * JavascriptExecutor jse = (JavascriptExecutor)driver;
			 * jse.executeScript("window.scrollBy(0,-250)");
			 */

			

			Thread.sleep(3000);
			String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
			  pp.setOldPassword(del + oldpass);
			  
			  pp.setNewPassword(del+ newpass);
			  
			  pp.setConfirmPassword(del+confirm);
			  
			  pp.submit();
			  
			  logger.info("Clicked on Save Changes");
				/*
				 * JavascriptExecutor jse = (JavascriptExecutor)driver;
				 * jse.executeScript("window.scrollBy(0,-250)");
				 */

			String confmsg = pp.getConfirmationMsg();

			logger.info("Validating expected message");
			Assert.assertEquals(confmsg, "Your changes have been saved.", "Test failed");

			

		} catch (Exception e) {
			logger.error("test failed");
			Assert.fail();
		}

		logger.info("***  Finished TC_002_ProfileUpdateTest ***");
	}

}
