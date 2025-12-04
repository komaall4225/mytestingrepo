package ObjectRepository;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class loginpage {
		
		@FindBy(id="user-name")
		private WebElement username;
		@FindBy(id="password")
		private WebElement password;
		@FindBy(id="login-button")
		private WebElement login_btn;
		public loginpage(WebDriver driver) {
			PageFactory.initElements(driver,this);
			
		}
		public WebElement user() {
			return username;
		}
		public WebElement pass_word() {
			return password;
		}
		public WebElement login_button() {
			return login_btn;
		}	

	}

