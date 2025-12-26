package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTestCase extends BaseClass {
	
	@Test (groups={"sanity", "master"})
	public void verifysuccessfulLogin()
	{
		
		logger.info("**** Starting TC002_LoginTest ****");
		try
		{
			
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.loginlink();
			
			LoginPage lp = new LoginPage(driver);
			
			
			
	        

			
			lp.setemail(p.getProperty("email"));
			logger.info("Email entered: " + p.getProperty("email"));
			
			lp.setpassword(p.getProperty("password"));
			logger.info("Password entered: " + p.getProperty("password"));
			
			lp.clickloginButton();
			
			
			MyAccountPage mp = new MyAccountPage(driver);
			boolean targetpage= mp.isMyAccountPageExists();
			
			Assert.assertTrue(targetpage);

			
			
			
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error("Exception occured in login test: " + e.getMessage());
			Assert.fail("Test Failed due to the exception" + e.getMessage());
		}
		
		logger.info("**** Finished TC002_LoginTest ****");
		
		
		
		
		
		
	}

}
