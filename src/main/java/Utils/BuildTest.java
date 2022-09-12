package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuildTest {


	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		String path = System.getProperty("user.dir") + "/src/main/java/Utils/Data.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		System.out.println(browserName);
		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "F:/CromeDriver/chromedriver.exe");
			if (browserName.contains("headless")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
		} else if (browserName.equals("firefox")) {
			// firefox code
			// WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			// IE code
		}

		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		// String png= System.currentTimeMillis()+ ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\Reports\\" + testCaseName
				+ formater.format(calendar.getTime()) + ".png";
		FileUtils.copyFile(source, new File(destinationFile));

		return destinationFile;
	}
}
