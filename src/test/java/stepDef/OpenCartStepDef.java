package stepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenCartStepDef {
	WebDriver driver;
	@Given("user is on OpenCartLoginPage")
	public void user_is_on_open_cart_login_page() {
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("user enters email {string} and password {string}")
	public void user_enters_email_and_password(String string, String string2) throws InterruptedException {
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys(string);
	    driver.findElement(By.cssSelector("input[name='password']")).sendKeys(string2);
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
	}

	@Then("user should be able login succesfully")
	public void user_should_be_able_login_succesfully() {
		System.out.println("Login Successful");
	}


}