package saucelabtest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabDemoTest {

	public WebDriver driver = null;

	public static final String USERNAME = "oauth-dhantole.deep-da78a";
	public static final String ACCESS_KEY = "17822d65-0140-4cfc-aa06-ac5dfd75e467";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY
			+ "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";
	
	@BeforeClass
	@Parameters({"browser", "version", "platform"})
	public void setup(String br, String	vr, String pf) throws MalformedURLException {
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("browserName", br);
	capabilities.setCapability("version", vr);
	capabilities.setCapability("platform", pf);
	driver = new RemoteWebDriver(new URL(URL),capabilities);
}

	public void verifyLogin() {

		// Open URL using get method
		driver.get("https://www.nopcommerce.com/en");

		driver.manage().window().maximize();

		// Capture title of the page
		System.out.println("Title of page is : " + driver.getTitle());

		Assert.assertEquals(driver.getTitle(),
				"Free and open-source eCommerce platform. ASP.NET based shopping cart. - nopCommerce");

	}

	public void tearDown() {
		driver.quit();
	}
}