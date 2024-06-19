package opencartTestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import opencartPages.LogoutPage;

public class Base {
	 WebDriver driver;

	@BeforeTest
	@Parameters({ "browser" })
	public void invokeBrowser(String browser) throws InterruptedException {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.opencart.com/");
	}
	
	
	public void takeScreenshot() throws IOException {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f, new File("./screenshot/"+"Page-"+System.currentTimeMillis()+".png"));
		System.out.println("Screenshot Successfully added");
	}
	
	@AfterMethod
	public void logout() {
		LogoutPage exit=new LogoutPage(driver);
		exit.myAccBtn().click();
		exit.logoutBtn().click();
	}
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
}
