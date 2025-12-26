package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {
	
	
	public AccountRegistrationPage(WebDriver driver)
	
	{
		super (driver);
	}

	
	
@FindBy(xpath= "//input[@id='input-firstname']")
WebElement txtFirstName;

@FindBy(xpath= "//input[@id='input-lastname']")
WebElement txtLastName;


@FindBy(xpath= "//input[@id='input-email']")
WebElement txtEmail;


@FindBy(xpath= "//input[@id='input-telephone']")
WebElement txtTelephone;

@FindBy(xpath= "//input[@id='input-password']")
WebElement txtPswd;

@FindBy(xpath= "//input[@id='input-confirm']")
WebElement txtCnfmPswd;


@FindBy(xpath= "//input[@name='agree']")
WebElement chkboxAgree;

@FindBy(xpath= "//input[@value='Continue']")
WebElement btncontinue;

@FindBy(xpath= "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgCOnfirmation;




public void setFirstName(String fname)
{
	txtFirstName.sendKeys(fname);
}

public void setLastName(String lname)
{
	txtLastName.sendKeys(lname);
}

public void setemail(String email)
{
	txtEmail.sendKeys(email);
}

public void setcontact(String cont)
{
	txtTelephone.sendKeys(cont);
}

public void setPassword(String pswd)
{
	txtPswd.sendKeys(pswd);
}

public void setConfirmPassword(String cpswd)
{
	txtCnfmPswd.sendKeys(cpswd);
}

public void setPrivacyPolicy()
{
	chkboxAgree.click();;
}

public void clickcontinue()
{
	//sol 1
	btncontinue.click();
	
	//sol 2
	//btncontinue.submit();
	//
	
	//sol 3
	//Actions act = new Actions(driver);
	//act.moveToElement(btncontinue).click().perform();
	
	//sol 4
	
	//JavascriptExecutor js = (JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();", btncontinue);
	
	//sol 5
	//btncontinue.sendKeys(Keys.RETURN);
	
	//sol 6
	
	//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//mywait.until(ExpectedConditions.elementToBeClickable(btncontinue)).click();
	
	
}


public String getconfirmMsg()
{
	try
	{
		return(msgCOnfirmation.getText());
	}
	catch(Exception e)
	{
		return (e.getMessage());
	}
}






}
