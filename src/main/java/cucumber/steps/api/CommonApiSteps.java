package cucumber.steps.api;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.steps.BaseCucumberSteps;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import util.BaseUtil;
import util.TestContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonApiSteps extends BaseCucumberSteps {

    @Before
    public void start(Scenario scn) throws IOException {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        BaseUtil baseUtil = new BaseUtil(scn);
        Properties pro = new Properties();

        InputStream is = baseUtil.getFileFromResourceAsStream("application.properties");
        pro.load(is);

        testContext().setScenario(scn);
        testContext().setProperties(pro);
    }

    @After
    public void end(Scenario scn){
        TestContext.CONTEXT.reset();
    }


}
