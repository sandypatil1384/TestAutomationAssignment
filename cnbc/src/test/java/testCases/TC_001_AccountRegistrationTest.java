package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test//(groups= {"Regression","Master"})
	public void test_account_Registration() throws InterruptedException
	{
		logger.debug("application logs......");
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account link");
		
			
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			
		logger.info("Providing customer data");
		
		
		regpage.setEmail(rb.getString("email"));// randomly generated the email
		
		//String password=randomAlphaNumeric();
		regpage.setPassword(rb.getString("password"));
		
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		logger.info("Clicked on continue");
		
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("Validating expected message");
		Assert.assertEquals(confmsg, "You have successfully created a CNBC account.","Test failed");
		
		}catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");		
	}
	
	
	
}
