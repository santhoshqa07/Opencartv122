package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
@FindBy(xpath = "//h2[text()='My Account']")
WebElement MyAccountHeading;

@FindBy(xpath= "//a[@class='list-group-item'][normalize-space()='Logout']") //added in step 6
WebElement Logoutlink;

public boolean isMyAccountPageExists()
{
	try
	{
		return (MyAccountHeading.isDisplayed());
	}
	catch (Exception e)
	{
		//System.out.println("MyAccountPage locator failed: " + e.getMessage());
        //e.printStackTrace();
		return false;
	}

}	

public void logout() 
{
	Logoutlink.click();


}



}