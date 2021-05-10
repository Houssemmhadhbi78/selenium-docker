package resources;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BasesTest {
	// WebDriver is a protected variable which can access only by parent and childs
	// class.
	public WebDriver driver;

	@BeforeTest
	public void setupDriver() throws MalformedURLException {
		// Browser => chrome / firefox
		// Where Selenium Grid is present => HUB_HOST => localhost/10.0.1.3/ hostname

		String host = "localhost";
		DesiredCapabilities dc;

		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			dc = DesiredCapabilities.firefox();
		} else {
			dc = DesiredCapabilities.chrome();
		}

		if (System.getProperty("HUB_HOST") != null) {

			host = System.getProperty("HUB_HOST");
		}

		String completeUrl = "http://" + host + ":4444/wd/hub";

		this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
	}

	@AfterTest
	public void closeBrowser() {
		this.driver.quit();
	}
}
