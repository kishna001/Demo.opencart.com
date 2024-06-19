package opencartPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
WebDriver driver;
	
	public WishListPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@type='text']") WebElement search;
	@FindBy(xpath="//button[@class='btn btn-light btn-lg']") WebElement searchbtn;
	@FindBy(xpath = "//h4/a[normalize-space()='MacBook']") WebElement item;
	@FindBy(xpath = "//button[@id='button-cart']") WebElement product2;
	//@FindBy(xpath="//button[@aria-label='Add to Wish List']") WebElement wishlistbtn;
	@FindBy(xpath="//button[@aria-label='Add to Wish List']//i[@class='fa-solid fa-heart']") WebElement wishlistbtn;
	//@FindBy(xpath="//button[data-bs-original-title='Add to Wish List']") WebElement wishlistbtn;
//	@FindBy(css="button[aria-label='Add to Wish List'] i[class='fa-solid fa-heart']") WebElement wishlistbtn;
//	@FindBy(xpath="//ul[class='list-inline']/li[3]/a") WebElement WishlistBtn;
	
	public WebElement search()
	{
		return search;
	}
	public WebElement searchbtn()
	{
		return searchbtn;
	}
	
//	public WebElement product2()
//	{
//		return product2;
//	}
	public WebElement item()
	{
		return item;
	}
	public WebElement wishlistbtn()
	{
		return wishlistbtn;
	}
//	public WebElement WishlistBtn()
//	{
//		return WishlistBtn;
//}
}
