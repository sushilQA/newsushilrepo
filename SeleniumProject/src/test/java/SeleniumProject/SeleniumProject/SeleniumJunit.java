package SeleniumProject.SeleniumProject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumJunit {

	WebDriver driver;
	FacebookSignUpPage facebookSignUpPage = new FacebookSignUpPage();
	String webSiteDomain = "https://www.facebook.com";

	@Test
	public void facebookSignUpPage() throws InterruptedException {
		facebookSignUpPage.facebookSignUpPage(webSiteDomain, driver);
		System.out.println("facebookSignUpPage");
		facebookSignUpPage.facebookBasicDetails(driver);
		facebookSignUpPage.birthDaySelectByVisibleText(driver, "24");
		facebookSignUpPage.birthMonthSelectByIndex(driver, 11);
		facebookSignUpPage.birthYearByVisibleText(driver, "1990");
		facebookSignUpPage.signUp(driver);

	}

	@Before
	public void browserSetup() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "../automationProject/chromedriver.exe");
		this.driver = new ChromeDriver();
		System.out.println("Chrom Browser is launch Sussessfully !");

	}
	
	@After
	public void after()
	{
		System.out.println("After Test facebookSignUpPage");
	}

	@BeforeClass
	public static void beforeClass()
	{
		System.out.println("Before Class SeleniumJunit ");
	}
	
	@AfterClass
	public static void afterClass()
	{
		System.out.println("After Class SeleniumJunit");
	}
	
	
}
