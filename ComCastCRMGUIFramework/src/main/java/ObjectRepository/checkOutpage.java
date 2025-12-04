package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkOutpage {
	@FindBy(xpath="//input[@id='first-name']")
	  private WebElement firstname;
	  
	  @FindBy(id="last-name")
	  private WebElement lastname;
	  
	  
	  @FindBy(id="postal-code")
	  private WebElement postalcode;
	  
	  @FindBy(id="continue")
	  private WebElement continuebtn;
	  
	  @FindBy(id="finish")
	  private WebElement finish;
	  
	  public checkOutpage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
	  
	  public WebElement first_name() {
		  return firstname;
	  }
	  
	  
	  public WebElement last_name() {
		  return lastname;
	  }
	  
	  public WebElement postal_code() {
		  return postalcode;
	  }
	  
	  
	  public WebElement continue_btn() {
		  return continuebtn;
	  }
	  
	  public WebElement finis_h() {
		  return finish;
	  }

}
