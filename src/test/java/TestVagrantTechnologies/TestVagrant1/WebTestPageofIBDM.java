package TestVagrantTechnologies.TestVagrant1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.BuildTest;

public class WebTestPageofIBDM extends BuildTest {
	
	public static Logger log = LogManager.getLogger(WebPage.class.getName());
	public String ReleaseDateofIBDM;
	public String CountryNameofIBDM;

	@BeforeTest
	public void startup() throws IOException, InterruptedException {
		driver = initializeDriver();
		log.info("Driver is initialize");
		driver.get(prop.getProperty("UrlIBDM"));
		log.info("URL is fetch successfully");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());

		navigationHomePage();

	}

	
	public void navigationHomePage() throws InterruptedException {
		WebPage WP = new WebPage(driver);
		JavascriptExecutor rs = (JavascriptExecutor) driver;
		rs.executeScript("window.scrollBy(0,5000)");
		ReleaseDateofIBDM = WP.getReleaseDateofIBDM().getText();
		System.out.println(ReleaseDateofIBDM);
		CountryNameofIBDM = WP.getCountryNameofIBDM().getText();
		System.out.println(CountryNameofIBDM);
	}

	@Test (priority = 1)
	public void compareOfCountryName() {
		System.out.println("CountryNameofWiki:: " + WebTestPageofWiki.CountryNameofWiki);
		Assert.assertEquals(CountryNameofIBDM, WebTestPageofWiki.CountryNameofWiki);
	}

	@Test (priority = 2)
	public void compareOfReleaseDate() {
		System.out.println("ReleaseDateofWiki:: " + WebTestPageofWiki.ReleaseDateofWiki);
		Assert.assertEquals(ReleaseDateofIBDM, WebTestPageofWiki.ReleaseDateofWiki);
	}

	
}
