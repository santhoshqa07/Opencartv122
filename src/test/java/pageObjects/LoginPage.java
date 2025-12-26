package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
@FindBy(xpath="//input[@id='input-email']")
WebElement Email;

@FindBy(xpath="//input[@id='input-password']")
WebElement Password;


@FindBy(xpath="//input[@value='Login']")
WebElement LoginButton;


@FindBy(xpath ="//div[@class='alert alert-danger alert-dismissible']")
WebElement LoginfailureMsg;
	

public void setemail(String email)
{
	Email.sendKeys(email);
}

public void setpassword(String pswd)
{
	Password.sendKeys(pswd);
	
}

public void clickloginButton()
{
	LoginButton.click();
}

public boolean isLoginFailureMsgExists() 
{
	try
	{
	
	return (LoginfailureMsg.isDisplayed());
	}
	
	catch(Exception e)
	{
		return false;
	}
}
	
}
