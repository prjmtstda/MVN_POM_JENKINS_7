package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.Dashboard;
import pages.LoginPage;
import utility.TestBase;

public class OrangeHRM_TestCase extends TestBase
{
   @Test
   public void init() throws InterruptedException
   {
	   Thread.sleep(5000);
	   
	   // LoginPage loginPage = new LoginPage(null);
	   // PageFactory.initElements(driver, loginPage);

	   LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	   
       loginPage.setUserName("Admin");
       loginPage.setPassword("admin123");
       loginPage.clickOnLoginButton();
       Thread.sleep(5000);
       
       
       Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);
       
       dashboard.clickOnProfile();
       Thread.sleep(10000);
       dashboard.clickOnProfileLogOut();
       Thread.sleep(5000);
   }
}
