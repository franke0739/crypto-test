package appium.mobileApp.pom.pageSteps;

import cucumber.api.Scenario;
import appium.mobileApp.pom.pageObjects.MyObservatoryLandingPageObject;
import org.openqa.selenium.WebDriver;

public class MyObservatoryLandingPageSteps extends BasePageSteps<MyObservatoryLandingPageObject>{
    public MyObservatoryLandingPageSteps(WebDriver androidDriver, Scenario scn){super(androidDriver, scn);}

    public void waitReminderDialogToLoad(){
        waitForVisibilityOf(MyObservatoryLandingPageObject.reminderDialogLocator, "MyObservatoryLandingPageObject.reminderDialogLocator");
        waitForVisibilityOf(MyObservatoryLandingPageObject.closeReminderButtonLocator, "MyObservatoryLandingPageObject.closeReminderButtonLocator");
    }

    public void clickCloseReminderButton(){
        click(MyObservatoryLandingPageObject.closeReminderButtonLocator, "MyObservatoryLandingPageObject.closeReminderButtonLocator");
    }

    public void waitLandingPageToLoad(){
        waitForVisibilityOf(MyObservatoryLandingPageObject.navigateHamburgerButtonLocator, "MyObservatoryLandingPageObject.navigateHamburgerButton");
        waitForVisibilityOf(MyObservatoryLandingPageObject.radarButtonLocator, "MyObservatoryLandingPageObject.radarButton");
        waitForVisibilityOf(MyObservatoryLandingPageObject.satelliteButtonLocator, "MyObservatoryLandingPageObject.satelliteButton");
        waitForVisibilityOf(MyObservatoryLandingPageObject.weatherButtonLocator, "MyObservatoryLandingPageObject.weatherButton");
    }

    public void clickHamburgerButton(){
        click(MyObservatoryLandingPageObject.navigateHamburgerButtonLocator, "MyObservatoryLandingPageObject.navigateHamburgerButton");
    }

    public void waitLeftDrawerToLoad(){
        waitForVisibilityOf(MyObservatoryLandingPageObject.leftDrawerLocator, "MyObservatoryLandingPageObject.leftDrawer");
    }

    public void clickNineDayForecastButton(){
        click(MyObservatoryLandingPageObject.nineDayForecastButtonLocator, "MyObservatoryLandingPageObject.nineDayForecastButton");
    }

}
