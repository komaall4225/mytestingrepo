package baseTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.comcast.crm.generic.fileutility.FileUtility;

import ObjectRepository.homePage;
import ObjectRepository.loginpage;

public class baseClass {
	
	public WebDriver driver;
	public loginpage lp;
	public homePage hp;
	public static WebDriver edriver;
	@BeforeClass
	public void launchingBrowser() throws IOException {
	String browser = System.getProperty("browser");
	 if(browser.equals("chrome"))
		 driver=new ChromeDriver();
	 else if(browser.equals("edge"))
		 driver=new EdgeDriver();
	 else { 
		 driver=new ChromeDriver();
	 }
	 
	 edriver=driver;
	  String url=System.getProperty("baseUrl");
	  driver.get(url);
	  driver.manage().window().maximize();
	  String timeOut=System.getProperty("timeOuts");
	 int timeOuts= Integer.parseInt(timeOut);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOuts));
	}
	
	@BeforeMethod
	public void login() throws IOException {
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		lp=new loginpage(driver);
		lp.user().sendKeys(username);
		lp.pass_word().sendKeys(password);
		lp.login_button().click();
	}
	
	@AfterMethod
	public void logout() {
		hp=new homePage(driver);
	Actions act=new Actions(driver);
	act.moveToElement(hp.openmenu()).click().perform();
	hp.log_out().click();
	}
	  
	  @AfterClass
	  public void tearDown() {
	  driver.quit();
	  
	}
	}
	
	
	
   