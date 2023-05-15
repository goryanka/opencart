package testBase;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass  {

	public static WebDriver driver;
	
	public Logger logger;
	
	public ResourceBundle rsBundle; //for config file under resources file
	
	@BeforeClass(groups = {"Master", "Sanity", "Regression"})
	@Parameters("browser")
	public void setup(String browser) {
		
		rsBundle = ResourceBundle.getBundle("config");
		
	    logger = LogManager.getLogger(this.getClass()); //for logging
		
		//WebDriverManager.chromedriver().setup();
		
	    if(browser.equals("chrome")) {
	    driver = new ChromeDriver();
	    }
	    else if(browser.equals("edge"))
	    {
	    	driver = new EdgeDriver();
	    }
	    else {
	    	driver = new FirefoxDriver();
	    }
	    
	    driver.get(rsBundle.getString("appURL"));
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		//driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
	}
	
	
	public String randomString() {
		 String generatedString = RandomStringUtils.randomAlphabetic(5);
		 return (generatedString);
				 
	}
	
	public String randomNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
	    return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		
	    String st = RandomStringUtils.randomAlphabetic(4);
	    String num = RandomStringUtils.randomNumeric(3);
		
		return (st +"@"+ num);
	}
	
	
	@AfterClass(groups = {"Master", "Sanity", "Regression"})
	public void tearDown() {
		
		driver.quit();
		
	}
	
	public String captureScreen(String tname) {
		
		/*SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss"); 
		Date dt = new Date(0);
		String timestamp  = df.format(dt);
		*/
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver; 
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.div") + "\\screenshots\\" + tname + " " + timestamp + ".png";
		 
		 try {
			FileUtils.copyFile(source, new File(destination));
			 
		} catch ( Exception e) {
			e.getMessage();
		}
		return destination;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
