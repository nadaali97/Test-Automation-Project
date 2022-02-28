package cucumberOptions;

import base.TestBase;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/GooglePage.feature", glue = "stepDefinitions",tags="@Selenium", plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class GoogleTestRunner extends AbstractTestNGCucumberTests {

}