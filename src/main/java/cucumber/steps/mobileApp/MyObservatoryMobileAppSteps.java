package cucumber.steps.mobileApp;

import appium.mobileApp.pom.pageSteps.MyObservatoryLandingPageSteps;
import appium.mobileApp.pom.pageSteps.NineDayForecastPageSteps;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.steps.BaseCucumberSteps;
import io.appium.java_client.AppiumDriver;
import appium.mobileApp.pom.pageSteps.AgreementPageSteps;
import util.BaseUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class MyObservatoryMobileAppSteps extends BaseCucumberSteps {

    public Scenario scn;
    public AppiumDriver androidDriver;

    @Given("MyObservatory is installed and launched in Android Emulator")
    public void launch_app_in_android_emulator() throws MalformedURLException {
        scn = testContext().getScenario();
        BaseUtil baseUtil = new BaseUtil(scn);
        Properties pro = testContext().getProperties();
        String appiumUrl = pro.getProperty("appium.server.url");
        String apkPath = pro.getProperty("hk.observatory.andriod.apk.path");
        String appPackage = pro.getProperty("hk.observatory.andriod.apk.package");
        String appActivity = pro.getProperty("hk.observatory.andriod.apk.activity");
        String avd = pro.getProperty("android.avd");
        androidDriver = baseUtil.createAndroidDriver(scn, avd, new URL(appiumUrl), apkPath, appPackage, appActivity);
        testContext().setAndroidDriver(androidDriver);
    }

    @And("agree the agreement")
    public void click_agree_in_agreement_page() {
        androidDriver = testContext().getAndroidDriver();
        scn = testContext().getScenario();
        AgreementPageSteps agreementPageSteps = new AgreementPageSteps(androidDriver, scn);
        agreementPageSteps.waitAgreementPageToLoad();
        agreementPageSteps.clickAgreeButton();
        agreementPageSteps.sleep(1, "Wait next agreement page to load");
        agreementPageSteps.clickAgreeButton();
    }

    @And("close reminder dialog")
    public void close_reminder_dialog() {
        androidDriver = testContext().getAndroidDriver();
        scn = testContext().getScenario();
        MyObservatoryLandingPageSteps myObservatoryLandingPageSteps = new MyObservatoryLandingPageSteps(androidDriver, scn);
        myObservatoryLandingPageSteps.waitReminderDialogToLoad();
        myObservatoryLandingPageSteps.clickCloseReminderButton();
    }

    @When("access to 9-Day Forecast")
    public void go_to_9_day_forecast() {
        androidDriver = testContext().getAndroidDriver();
        scn = testContext().getScenario();
        MyObservatoryLandingPageSteps myObservatoryLandingPageSteps = new MyObservatoryLandingPageSteps(androidDriver, scn);
        NineDayForecastPageSteps nineDayForecastPageSteps = new NineDayForecastPageSteps(androidDriver, scn);
        myObservatoryLandingPageSteps.waitLandingPageToLoad();
        myObservatoryLandingPageSteps.clickHamburgerButton();
        myObservatoryLandingPageSteps.waitLeftDrawerToLoad();
        myObservatoryLandingPageSteps.clickNineDayForecastButton();
        nineDayForecastPageSteps.waitNineDayForecastPageToLoad();
    }

    @Then("get tomorrow weather forecast")
    public void get_tomorrow_weather_forecast() {
        androidDriver = testContext().getAndroidDriver();
        scn = testContext().getScenario();
        NineDayForecastPageSteps nineDayForecastPageSteps = new NineDayForecastPageSteps(androidDriver, scn);
        nineDayForecastPageSteps.getFirstDayForecastInfo();
    }



}
