package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider = "LoginData", dataProviderClass= DataProviders.class, groups= {"data-driven", "master"})
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		
		logger.info("**** Started TC003_LoginDDT ****");
		try
		{
			
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.loginlink();
			
			LoginPage lp = new LoginPage(driver);			
			lp.setemail(email);
			lp.setpassword(pwd);
			lp.clickloginButton();
			
			boolean errormsg = lp.isLoginFailureMsgExists();
			
			/*Data is valid - login success-test pass -logout
			 * Data is valid - login unsuccess-test failed
			 * 
			 * Data is invalid - login success-test fail -logout
			 * Data is invalid - login unsuccess-test pass
			 * 
			 */
			
			if(exp.equalsIgnoreCase("invalid"))
			{
				if(errormsg == true)
				{
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			
			
			
			MyAccountPage mp = new MyAccountPage(driver);
			
			
			
			if(exp.equalsIgnoreCase("valid"))
			{
				if(mp.isMyAccountPageExists())
				{
					mp.logout();
					Assert.assertTrue(true);
					
				}
				
				else
				{
					Assert.assertTrue(false);
				}
				
			}
			
						
		} 
		
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error("Exception occured in login test: " + e.getMessage());
			Assert.fail("Test Failed due to the exception" + e.getMessage());
		}
		
		logger.info("**** Finished TC003_LoginDDT ****");
	}
}
