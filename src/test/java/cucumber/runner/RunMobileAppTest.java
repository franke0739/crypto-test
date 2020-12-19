package cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(//plugin = { "pretty","html:target"},
        //strict = true,
        glue = {"cucumber.steps.mobileApp"},
        features = {"classpath:features/mobileApp"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "pretty"}
)
public class RunMobileAppTest {
}
