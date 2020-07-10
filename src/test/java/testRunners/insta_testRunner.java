package testRunners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = {"src\\test\\Resources\\features\\instagramLikeAuto.feature"},
		glue = {"stepDefinition\\instaLikeStedDef"},
		plugin = {"pretty" ,  "html:test-output","html:target/report/cucumber", "json:target/report/json/login.json"},
		monochrome = true
)

public class insta_testRunner {

}
