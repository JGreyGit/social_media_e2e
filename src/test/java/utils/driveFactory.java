package utils;

import constants.insta_constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class driveFactory extends insta_constants {


	public static WebDriver driver;

	private static readProperties configProperties = new readProperties("./src/test/Resources/config/config.properties");

	public static void initializeDriver() {
		String browser = configProperties.getPropertyValue("Browser");
		String geckoDriverPath = configProperties.getPropertyValue("gecko_driver_path");
		String chromeDriverPath = configProperties.getPropertyValue("chrome_driver_path");
		String url = configProperties.getPropertyValue("url");

		if (browser.equalsIgnoreCase(browswer_firefox)) {

			WebDriverManager.firefoxdriver().setup();

			// System.setProperty(webdriver_gecko_driver, geckoDriverPath);
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase(browswer_chrome)) {
			WebDriverManager.chromedriver().setup();
			// System.setProperty(webdriver_chrome_driver,chromeDriverPath);
			driver = new ChromeDriver();
		}


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(configProperties.getPropertyValue("twitterUrl"));

	}
}
