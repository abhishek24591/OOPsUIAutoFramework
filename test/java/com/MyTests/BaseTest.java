/**
 * 
 */
package com.MyTests;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mypages.BasePage;
import com.mypages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author abhishekdeshmukh
 *
 */
public class BaseTest {

	WebDriver driver;
	public Page page;

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUp(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("browserName", "chrome");
			try {
				driver = new RemoteWebDriver(new URL("http://65.0.32.160:4444/wd/hub"),cap);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
//			File pathBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//			FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
//			DesiredCapabilities desired = DesiredCapabilities.firefox();
//			FirefoxOptions options = new FirefoxOptions();
//			desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
//			driver = new FirefoxDriver(options);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("browserName", "firefox");
			try {
				driver = new RemoteWebDriver(new URL("http://65.0.32.160:4444/wd/hub"),cap);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("no browser is defined in xml file ... ");
		}

		driver.get("https://app.hubspot.com/login");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		page = new BasePage(driver); // this is very IMP to spread driver to all page classes
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
