package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productPage {
	
	@FindBy(xpath="//div[@class='inventory_details_name large_size']")
	private WebElement saucelabstext;
	
	@FindBy(id="add-to-cart")
	private WebElement add_to_cart;
	
	@FindBy(xpath="//div[@id='shopping_cart_container']/descendant::span")
	private WebElement carticon;
	
	public productPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement sauce_text() {
		return saucelabstext;
	}
	
	
	public WebElement addtoCart() {
		return add_to_cart;
	}
	
	public WebElement cart_icon() {
		return carticon;
	}

}
