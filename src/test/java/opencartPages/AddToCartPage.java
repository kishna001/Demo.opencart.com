package opencartPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	WebDriver driver;

	public AddToCartPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='search']")
	WebElement searchbar;// sendkeys
	@FindBy(xpath = "//button[@type='button']/i[@class='fa-solid fa-magnifying-glass']")
	WebElement searchIcon;// click
	@FindBy(xpath = "//button[@id='button-grid']")
	WebElement grid;// click
	@FindBy(xpath = "//button[@id='button-list']")
	WebElement list;// click
	@FindBy(xpath = "//h4/a[normalize-space()='MacBook']")
	WebElement product1;// click
	@FindBy(xpath = "//h4/a[normalize-space()='iPhone']")
	WebElement product2;
	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement add;// click
	@FindBy(xpath = "//li[@class='list-inline-item']//span[normalize-space()='Shopping Cart']")
	WebElement cart;// click
	@FindBy(xpath = "//input[@name='quantity']")
	WebElement quantity;// sendkeys
	@FindBy(xpath = "//tr[1]/td[4]/form/div/button[@class='btn btn-primary']")
	WebElement update;// click
	@FindBy(xpath = "//tr[1]/td[4]/form/div/button[@class='btn btn-danger']")
	WebElement remove;// click
	@FindBy(xpath = "//div[@class='dropdown d-grid']")
	WebElement cartDropdown;
	@FindBy(xpath = "//a/strong[contains(text(),'Checkout')]")
	WebElement checkout;
	public WebElement search() {
		return searchbar;
	}

	public WebElement browse() {
		return searchIcon;
	}

	public WebElement chooseView(String view) {
		if (view.equals("grid"))
			return grid;
		else
			return list;
	}

	public WebElement selectProduct() {
		return product1;
	}

	public WebElement selectProduct2() {
		return product2;
	}

	public WebElement addToCart() {
		return add;
	}

	public WebElement shoppingCart() {
		return cart;
	}

	public WebElement selectQuantity() {
		return quantity;
	}

	public WebElement update() {
		return update;
	}

	public WebElement removeProduct() {
		return remove;
	}

	public WebElement cartDropdown() {
		return cartDropdown;
	}

	public WebElement checkout() {
		return checkout;
	}

}
