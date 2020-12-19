package cucumber.runner;

import com.aventstack.extentreports.ExtentReports;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(//plugin = { "pretty","html:target"},
        //strict = true,
        glue = {"cucumber.steps.api"},
        features = {"classpath:features/api"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "pretty"}
)
public class RunApiTest {

}
