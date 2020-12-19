package cucumber.steps.mobileApp;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.steps.BaseCucumberSteps;
import org.openqa.selenium.WebDriver;
import util.BaseUtil;
import util.TestContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonMobileAppSteps extends BaseCucumberSteps {

    public WebDriver androidDriver;
    public Scenario scn;

    @Before
    public void start(Scenario scn) throws IOException {
        BaseUtil baseUtil = new BaseUtil(scn);
        Properties pro = new Properties();

        String propertiesFile = "application.properties";

        InputStream is = baseUtil.getFileFromResourceAsStream(propertiesFile);
        pro.load(is);

        testContext().setScenario(scn);
        testContext().setProperties(pro);

    }

    @After
    public void end(Scenario scn){
        BaseUtil baseUtil = new BaseUtil(scn);

        androidDriver = testContext().getAndroidDriver();

        if(!scn.isFailed()) {
            //baseUtil.closeAndriodDriver(androidDriver, scn);
        }

        TestContext.CONTEXT.reset();
    }
}
