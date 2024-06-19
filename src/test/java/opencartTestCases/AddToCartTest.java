package opencartTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import opencartPages.AddToCartPage;
import opencartPages.CheckoutPage;
import opencartPages.LoginPage;

public class AddToCartTest extends Base {
	Properties properties;
	AddToCartPage obj;
	LoginPage lpage;
	JavascriptExecutor js ;
	@BeforeMethod
	public void login() throws Exception {
		lpage = new	LoginPage(driver);
		FileInputStream fis=new FileInputStream("data.properties");
		Properties prop =new Properties();
		prop.load(fis);
		Thread.sleep(2000);
		lpage.myAccBtn().click();
		Thread.sleep(2000);
		lpage.loginOption().click();
		lpage.email().sendKeys(prop.getProperty("Email"));
		lpage.password().sendKeys(prop.getProperty("password"));
		lpage.loginBtn().click();
	}

	@Test
	public void addToCartTC() throws Exception {
		obj = new AddToCartPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		FileInputStream stream = new FileInputStream("data.properties");
		properties = new Properties();
		properties.load(stream);
		Thread.sleep(3000);
		obj.search().sendKeys(properties.getProperty("search1"));
		obj.browse().click();
		Thread.sleep(3000);
		obj.chooseView(properties.getProperty("view")).click();
		Thread.sleep(2000);
		 js = (JavascriptExecutor) driver;
		WebElement product1 = obj.selectProduct();
		js.executeScript("window.scrollBy(0, 2000)");
		product1.click();
		Thread.sleep(2000);
		obj.addToCart().click();
		takeScreenshot();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement alertEle= driver.findElement(By.xpath("//div[@id='alert']/div"));
		wait.until(ExpectedConditions.visibilityOf(alertEle));
		String successMessage = alertEle.getText();
		Assert.assertEquals(successMessage,"Success: You have added " + properties.getProperty("search1") +" to your shopping cart!");
		driver.navigate().refresh();
		Thread.sleep(2000);
		obj.shoppingCart().click();
		obj.selectQuantity().clear();
		Thread.sleep(2000);
		obj.selectQuantity().sendKeys(properties.getProperty("quantity"));
		obj.update().click();
		Thread.sleep(2000);
		obj.removeProduct().click();
		Thread.sleep(2000);
		obj.search().clear();
		obj.search().sendKeys(properties.getProperty("search2"));
		Thread.sleep(2000);
		obj.browse().click();
		WebElement product2 = obj.selectProduct2();
		js.executeScript("window.scrollBy(0, 2000)");
		product2.click();
		Thread.sleep(3000);
		obj.addToCart().click();
		Thread.sleep(2000);
		obj.cartDropdown().click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(obj.checkout()));
		button.click();
//		obj.shipping().click();
//		Thread.sleep(2000);
//		obj.shippingOption().click();
//		obj.payment().click();
//		Thread.sleep(2000);
//		obj.paymentOption().click();
//		WebElement order = obj.confirmOrder();
//		js.executeScript("arguments[0].scrollIntoView(true)", order);
//		Thread.sleep(2000);
//		order.click();
	}
}
