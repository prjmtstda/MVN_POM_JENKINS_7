package utility;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import io.github.bonigarcia.wdm.WebDriverManager;

// BaseClass + BrowserFactory
public class TestBase 
{
    public static WebDriver driver = null;
    
    @BeforeSuite
    public void initialize() throws IOException, InterruptedException
    {
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//driver = new ChromeDriver();

		//System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		//driver = new FirefoxDriver();

		//System.setProperty("webdriver.gecko.driver", "C:/jars_selenium/drivers/geckodriver.exe");
		//driver = new FirefoxDriver();

		//System.setProperty("webdriver.chrome.driver", "C:/jars_selenium/drivers/chromedriver.exe");
		//driver = new ChromeDriver();

		// WebDriverManager.chromedriver().setup();                      // 4.4.3
		// WebDriver driver = new ChromeDriver();
			
		// [OR]		
						
		// WebDriver driver = WebDriverManager.chromedriver().create();  // 5.1.1 
						
		// [OR]
						
		/*
			ChromeOptions co = new ChromeOptions();
			co.setHeadless(true);
			WebDriver driver = WebDriverManager.chromedriver().capabilities(co).create();  // 5.1.1
		*/	
						
		/*
			ChromeOptions co = new ChromeOptions();
			co.setHeadless(false);
			WebDriver driver = WebDriverManager.chromedriver().capabilities(co).create();  // 5.1.1
		*/	

		// WebDriver driver = WebDriverManager.chromedriver().create();  // 5.1.1

		driver = WebDriverManager.chromedriver().create();      // 5.1.1
		//driver = WebDriverManager.firefoxdriver().create();   // 5.1.1
		//driver = WebDriverManager.edgedriver().create();      // 5.1.1
		//driver = WebDriverManager.chromiumdriver().create();  // 5.1.1
		//driver = WebDriverManager.operadriver().create();     // 5.1.1
		//driver = WebDriverManager.iedriver().create();        // 5.1.1
		//driver = WebDriverManager.safaridriver().create();    // 5.1.1
	    driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   // Selenium 3.0
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   // Selenium 4.0
		//driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(0));    // Selenium 4.0
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); // Selenium 4.0
		driver.manage().deleteAllCookies();
    	
    	driver.get("https://opensource-demo.orangehrmlive.com");
    	Thread.sleep(5000);
    }
    
    @AfterSuite
    public void tearDownTest()
    {
		driver.close();
    }
}
