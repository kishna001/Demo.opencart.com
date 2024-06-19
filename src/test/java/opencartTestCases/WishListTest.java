package opencartTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import opencartPages.LoginPage;
import opencartPages.WishListPage;

public class WishListTest extends Base{
	WishListPage wish;
	LoginPage lpage;
	
	@BeforeMethod
	public void login() throws Exception {
		System.out.println("Login before adding items to WishList");
		lpage = new	LoginPage(driver);
		FileInputStream fis=new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\SDETProj2-Maven\\src\\main\\java\\demoCartProperties\\DemoCartInputFile.properties");
		Properties prop =new Properties();
		prop.load(fis);
		Thread.sleep(2000);
		lpage.myAccBtn().click();
		Thread.sleep(2000);
		lpage.loginBtn().click();
//		lpage.EmailAddress().sendKeys(prop.getProperty("Email"));
//		lpage.password().sendKeys(prop.getProperty("password"));
		lpage.email().sendKeys("janu@gmail.com");
		lpage.password().sendKeys("janu");
		lpage.loginBtn().click();
		System.out.println("Logged in successfully");
	}
	@Test
	public void WishListTC01() throws IOException, InterruptedException
	{
		wish = new WishListPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		FileInputStream fis=new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\SDETProj2-Maven\\src\\main\\java\\demoCartProperties\\DemoCartInputFile.properties");
		Properties prop =new Properties();
		prop.load(fis);
		Thread.sleep(2000);
		wish.search().sendKeys(prop.getProperty("searchinput"));
		wish.searchbtn().click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement item = wish.item();
		js.executeScript("window.scrollBy(0, 400)");
		item.click();
		Thread.sleep(2000);
		WebElement addtowishlist=wish.wishlistbtn();
		js.executeScript("window.scrollBy(0,200)");
	    addtowishlist.click();
	    takeScreenshot();
	   // Assert.assertTrue(item.isSelected());
	    System.out.println("Item added to wishlist successfully");
	    //wish.WishlistBtn().click();
	        
	}
}
