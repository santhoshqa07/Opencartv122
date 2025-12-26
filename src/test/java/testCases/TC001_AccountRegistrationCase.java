package testCases;

import java.time.Duration;


import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationCase extends BaseClass {
	
	
	
	@Test (groups= {"regresssion", "master"})
	public void verify_account_registration()
	{
		logger.info("Test Case Started");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*** Clicked on MyAccount ***");
		
		hp.clickRegister();
		logger.info("*** Clicked on Register ***");
		
		
		
		AccountRegistrationPage ap = new AccountRegistrationPage(driver);
		
		logger.info("*** Passing values in all the text fields ***");
		
		ap.setFirstName(randomString().toUpperCase());
		ap.setLastName(randomString().toUpperCase());
		ap.setemail(randomString()+"@gmail.com");
		ap.setcontact(randomeNumber());
		
		String password = randomAlphaNumeric();
		ap.setPassword(password);
		ap.setConfirmPassword(password);
		
		ap.setPrivacyPolicy();
		ap.clickcontinue();
		
		logger.info("Validating expected Message...");
		
		String confrmMsg = ap.getconfirmMsg();
		if(confrmMsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed.. ");
			logger.debug("Debug Logs.. ");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			Assert.fail();
		}
		
		
		logger.info("***** Finished TC001_AccountRegistrationTest *****  ");
		
	}
	

	

}
	
	


