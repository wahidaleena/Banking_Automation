package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import extentReport.ExtentManager;
import utilities.Constants;


public class BaseClass {
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static Properties prop;

	public static void readProperty() throws IOException {

		prop = new Properties();
		FileInputStream f = new FileInputStream(System.getProperty("user.home")
				+ "//eclipse-workspace//com.parabank//src//main//resources//config//config.properties");
		prop.load(f);
	}
	@BeforeSuite
	public void createReport() {
		
		ExtentManager.createInstance();
		
	}
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) throws IOException {
		readProperty();
		switch (browser.toLowerCase()) {
		case "chrome":
			driver.set(new ChromeDriver());
			System.out.println("Executing chrome test");
			break;
		case "firefox":
			driver.set(new FirefoxDriver());
			System.out.println("Executing firefox test");
			break;
		default:
			throw new IllegalArgumentException("Invalid browser value: " + browser);
		}
		getDriver().get(prop.getProperty("base_url"));
		getDriver().manage().window().maximize();
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
		driver.remove();
	}
}