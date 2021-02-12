package testRunners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = {"src\\test\\Resources\\features\\twitterPost.feature"},
		glue = {"stepDefinition\\INSDef"},
		plugin = {"pretty" ,  "html:test-output","html:target/report/cucumber", "json:target/report/json/login.json"},
		monochrome = true
)

public class insta_testRunner {

}
