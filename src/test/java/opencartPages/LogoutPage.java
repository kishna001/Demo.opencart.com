package opencartPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath ="//div[@class='dropdown']/a/span[normalize-space()='My Account']") WebElement myAcc; //.click();
	@FindBy (linkText = "Logout") WebElement logout;
	public WebElement myAccBtn()
	{
		return myAcc;
	}
	public WebElement logoutBtn()
	{
		return logout;
	}
}
