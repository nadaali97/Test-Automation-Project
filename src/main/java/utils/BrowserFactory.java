package utils;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.JsonParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;

public class BrowserFactory {

	private static BrowserFactory factory;
	private WebDriver currentDriver;

	public static BrowserFactory getinstance() {
		if (factory == null)
			factory = new BrowserFactory();
		return factory;
		

	}

	/*
	 * Factory method for getting browsers
	 */
	@SuppressWarnings("unchecked")
	public WebDriver initializeBrowser(String browser) {
		JSONObject cap;
		DesiredCapabilities capability;
		if (browser.equalsIgnoreCase(Constants.EDGE)) {
			WebDriverManager.edgedriver().setup();
			cap = JsonParser.readJson(Constants.EDGECAPSPATH);
			EdgeOptions options = new EdgeOptions();
		    capability = new DesiredCapabilities((Map<String, ?>) cap.get("desiredCapabilities"));
			options.addArguments((List<String>) cap.get("args"));
			options.merge(capability);
			currentDriver = new EdgeDriver(options);

			
		} else if (browser.equalsIgnoreCase(Constants.CHROME)) {
			WebDriverManager.chromedriver().setup();
			cap = JsonParser.readJson(Constants.CHCAPSPATH);
			ChromeOptions options = new ChromeOptions();
			capability = new DesiredCapabilities((Map<String, ?>) cap.get("desiredCapabilities"));
			options.addArguments((List<String>) cap.get("chromeArguments"));
		    options.merge(capability);
			currentDriver = new ChromeDriver(options);
		} else {
			throw new IllegalArgumentException("Browser " + browser + " not supported.");
		}
		return currentDriver;
	}

	public WebDriver getCurrentDriver() {
		return currentDriver;
	}
}