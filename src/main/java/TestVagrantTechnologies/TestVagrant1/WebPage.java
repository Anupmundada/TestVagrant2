package TestVagrantTechnologies.TestVagrant1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebPage {
	public WebDriver driver;

	By WikiReleaseDate = By.xpath("//body[1]/div[3]/div[3]/div[5]/div[1]/table[1]/tbody[1]/tr[12]/td[1]/div[1]");
	By WikiCountryName = By.xpath("//td[normalize-space()='India']");
	By IBDMReleaseDate = By.xpath("//a[normalize-space()='January 7, 2022 (United States)']");
	By IBDMCountryName = By.xpath("//a[normalize-space()='India']");

	public WebPage(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getReleaseDateofWifi() {
		return driver.findElement(WikiReleaseDate);
	}

	public WebElement getCountryNameofWifi() {
		return driver.findElement(WikiCountryName);
	}

	public WebElement getReleaseDateofIBDM() {
		return driver.findElement(IBDMReleaseDate);
	}

	public WebElement getCountryNameofIBDM() {
		return driver.findElement(IBDMCountryName);
	}

}
