package TestVagrantTechnologies.TestVagrant1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;

import Utils.BuildTest;

public class WebTestPageofWiki extends BuildTest {
	

	public static Logger log = LogManager.getLogger(WebPage.class.getName());
	public static String ReleaseDateofWiki;
	public static String CountryNameofWiki;

	@BeforeTest
	public void startup() throws InterruptedException, IOException {

		Thread.sleep(2000);
		driver = initializeDriver();
		log.info("Driver is initialize");
		Thread.sleep(2000);
		driver.get(prop.getProperty("UrlWiki"));
		log.info("URL is fetch successfully");
		driver.manage().window().maximize();

		System.out.println(driver.getTitle());
		navigationHomePage();

	}

	
	public void navigationHomePage() throws InterruptedException {

		WebPage WP = new WebPage(driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		ReleaseDateofWiki = WP.getReleaseDateofWifi().getText();
		System.out.println(ReleaseDateofWiki);
		
		CountryNameofWiki = WP.getCountryNameofWifi().getText();
		System.out.println(CountryNameofWiki);
		Thread.sleep(5000);
		

	}

	

}
