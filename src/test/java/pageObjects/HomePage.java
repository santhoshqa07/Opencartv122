package pageObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
@FindBy(xpath="//a[normalize-space()='My Account']")
WebElement lnkmyaccount;


@FindBy(xpath="//a[normalize-space()='Register']")
WebElement lnkRegister;



@FindBy(xpath="//a[normalize-space()='Login']")
WebElement loginlink;

public void clickMyAccount()
{
	lnkmyaccount.click();
}


public void clickRegister()
{
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].click();", lnkRegister);
;
}

public void loginlink()
{
	loginlink.click();
}


}
