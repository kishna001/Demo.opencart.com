package opencartTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import opencartPages.RegistrationPage;

public class RegistrationTest extends Base{
	RegistrationPage rpage;
	@Test
	public void RegistrationTC() throws IOException, InterruptedException
	{
		rpage = new	RegistrationPage(driver);
		FileInputStream fis=new FileInputStream("data.properties");
		Properties prop =new Properties();
		prop.load(fis);
		Thread.sleep(2000);
		rpage.MyAccBtn().click();
		Thread.sleep(2000);
		rpage.RegBtn().click();
		rpage.firstname().sendKeys(prop.getProperty("firstname"));
		rpage.lastname().sendKeys(prop.getProperty("lastname"));
		rpage.Email().sendKeys(prop.getProperty("Email"));
		rpage.password().sendKeys(prop.getProperty("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement checkbox = rpage.chkbox();
		js.executeScript("window.scrollBy(0, 5000)");
		Thread.sleep(2000);
		checkbox.click();
		rpage.ContinueBtn1().click();
	}
}

