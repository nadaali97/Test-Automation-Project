
package stepDefinitions;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Constants;


public class Hooks extends TestBase {

  // LocalDate currentDate=LocalDate.now();
	
    @Before
    public void setup() {
    	
	openBrowser();
	
    }

    @After
    public void exit() {
	closeBrowser();
	
    }
}
