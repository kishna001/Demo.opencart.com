package opencartPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;

public LoginPage(WebDriver driver) {
	super();
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy (xpath ="//div[@class='dropdown']/a/span[normalize-space()='My Account']") WebElement myAcc; //.click();
@FindBy (linkText = "Login") WebElement login;
//@FindAll(@FindBy(css =".dropdown-item")) List<WebElement> dropDownItems; //.click();
@FindBy (css="input[name='email']")	WebElement email;	
@FindBy (css="input[name='password']") WebElement password;	
@FindBy (css= "button[class='btn btn-primary']") WebElement loginBtn; //.click();
public WebElement myAccBtn()
{
	return myAcc;
}
public WebElement loginOption()
{
	return login;
}
public WebElement email()
{
	return email;
}
public WebElement password()
{
	return password;
}
public WebElement loginBtn()
{
	return loginBtn;
}
}
