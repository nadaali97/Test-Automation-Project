package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/features/RestAssured.feature", glue = "RestAssuredTesting",tags="@Rest", plugin = {
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class RestAssuredTestRunner extends AbstractTestNGCucumberTests  {
	
}
