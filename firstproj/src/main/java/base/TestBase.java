package base;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.BrowserFactory;


public class TestBase {

    public static final String PROPERTY_WEBDRIVER_BROWSER = "browser.type";
    public static final String PROPERTY_WEB_URL = "web.url";

    protected static WebDriver driver;
    public static Properties prop;
    protected static final Logger LOGGER = Logger.getLogger(TestBase.class);
    
   	
	protected String executionDate;

    static {
	prop = readProperties("./src/test/resources/config/config.properties");
	
    }
    

    public static Properties readProperties(String filePath) {

    	try (FileInputStream testProperties = new FileInputStream(filePath)) {
    	    Properties tempProp = new Properties();
    	    tempProp.load(testProperties);
    	    LOGGER.info("Properties file reading done: " + filePath);
    	    return tempProp;
    	} catch (IOException e) {
    	    LOGGER.error("Properties file error: " + e.getMessage());
    	}
    	return null;
        }
	
	 @BeforeClass
	    public void openBrowser() {
		String browserType = prop.getProperty(PROPERTY_WEBDRIVER_BROWSER);
		String url = prop.getProperty(PROPERTY_WEB_URL);
		driver = BrowserFactory.getinstance().initializeBrowser(browserType);
		LOGGER.info("Opening Browser [" + browserType + "] with url [" + url + "]");
		driver.get(url);
	    }

	    @AfterClass
	    public void closeBrowser() {
		try {
		    LOGGER.info("Close Browser");
		    driver.close();
		    driver.quit();
		} catch (Exception ex) {
		    LOGGER.error("Close browser " + ex.getMessage(), ex);
		}

	    }
}
