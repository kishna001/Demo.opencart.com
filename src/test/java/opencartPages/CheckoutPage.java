package opencartPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@name='shipping_method']")
	WebElement shipping;
	@FindBy(xpath = "//select[@name='shipping_method']/optgroup/option")
	WebElement shippingOption;
	@FindBy(xpath = "//select[@name='payment_method']")
	WebElement payment;
	@FindBy(xpath = "//select[@name='payment_method']/option[2]")
	WebElement paymentOption;
	@FindBy(xpath = "//button[@id='button-confirm']")
	WebElement confirm;
	public WebElement shipping() {
		return shipping;
	}

	public WebElement shippingOption() {
		return shippingOption;
	}

	public WebElement payment() {
		return payment;
	}

	public WebElement paymentOption() {
		return paymentOption;
	}

	public WebElement confirmOrder() {
		return confirm;
	}

}
