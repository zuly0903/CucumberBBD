package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {".//Features/Login.feature"},
		glue = "stepdefinition",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty",
				  "html:target/CucumberReport.html",
				  "json:target/CucumberJson",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "@regression"
	
		
				)
public class TestRunner {

}
