package opencartPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
WebDriver driver;
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='dropdown']/a/span[normalize-space()='My Account']") WebElement MyAccBtn;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right show']/li[1]/a") WebElement RegBtn;
	@FindBy(name="firstname") WebElement firstname;
	@FindBy(name="lastname") WebElement lastname;
	@FindBy(xpath="//input[@type='email']") WebElement Email;
	@FindBy(id="input-password") WebElement password;
	@FindBy(xpath="//input[@type='checkbox']") WebElement chkbox;
	@FindBy(xpath="//button[@type='submit']") WebElement ContinueBtn1;
	
	public WebElement MyAccBtn()
	{
		return MyAccBtn;
	}
	public WebElement RegBtn()
	{
		return RegBtn;
	}
	public WebElement firstname()
	{
		return firstname;
	}
	public WebElement lastname()
	{
		return lastname;
	}
	public WebElement Email()
	{
		return Email;
	}
	public WebElement password()
	{
		return password;
	}
	public WebElement chkbox()
	{
		return chkbox;
	}
	public WebElement ContinueBtn1()
	{
		return ContinueBtn1;
		
	}
	
	
	


}
