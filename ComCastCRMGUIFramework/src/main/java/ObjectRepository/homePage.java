package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	
	@FindBy(xpath="//div[@class='app_logo']")
	private WebElement SwagLbs;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	private WebElement openMenu;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logout;
	
	@FindBy(xpath="//a[@id='item_4_title_link']//div")
	private WebElement product_name;
	
	@FindBy(xpath="//a[@id='item_4_img_link']//img")
	private WebElement product_image;
	
	
	public homePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement swaglabs() {
		return SwagLbs;
	}
	
	public WebElement openmenu() {
		return openMenu;
	}
	
	public WebElement log_out() {
		return logout;
	}
	
	public WebElement productName() {
		return product_name;
	}
	
	public WebElement ProductImage() {
		return product_image;
	}
	

}
