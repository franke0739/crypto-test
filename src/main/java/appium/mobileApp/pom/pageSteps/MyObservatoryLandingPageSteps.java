package appium.mobileApp.pom.pageSteps;

import cucumber.api.Scenario;
import appium.mobileApp.pom.pageObjects.MyObservatoryLandingPageObjects;
import org.openqa.selenium.WebDriver;

public class MyObservatoryLandingPageSteps extends BasePageSteps<MyObservatoryLandingPageObjects>{
    public MyObservatoryLandingPageSteps(WebDriver androidDriver, Scenario scn){super(androidDriver, scn);}

    public void waitReminderDialogToLoad(){
        waitForVisibilityOf(MyObservatoryLandingPageObjects.reminderDialogLocator, "MyObservatoryLandingPageObjects.reminderDialogLocator");
        waitForVisibilityOf(MyObservatoryLandingPageObjects.closeReminderButtonLocator, "MyObservatoryLandingPageObjects.closeReminderButtonLocator");
    }

    public void clickCloseReminderButton(){
        click(MyObservatoryLandingPageObjects.closeReminderButtonLocator, "MyObservatoryLandingPageObjects.closeReminderButtonLocator");
    }

    public void waitLandingPageToLoad(){
        waitForVisibilityOf(MyObservatoryLandingPageObjects.navigateHamburgerButtonLocator, "MyObservatoryLandingPageObjects.navigateHamburgerButtonLocator");
        waitForVisibilityOf(MyObservatoryLandingPageObjects.radarButtonLocator, "MyObservatoryLandingPageObjects.radarButtonLocator");
        waitForVisibilityOf(MyObservatoryLandingPageObjects.satelliteButtonLocator, "MyObservatoryLandingPageObjects.satelliteButtonLocator");
        waitForVisibilityOf(MyObservatoryLandingPageObjects.weatherButtonLocator, "MyObservatoryLandingPageObjects.weatherButtonLocator");
    }

    public void clickHamburgerButton(){
        click(MyObservatoryLandingPageObjects.navigateHamburgerButtonLocator, "MyObservatoryLandingPageObjects.navigateHamburgerButtonLocator");
    }

    public void waitLeftDrawerToLoad(){
        waitForVisibilityOf(MyObservatoryLandingPageObjects.leftDrawerLocator, "MyObservatoryLandingPageObjects.leftDrawerLocator");
    }

    public void clickNineDayForecastButton(){
        click(MyObservatoryLandingPageObjects.nineDayForecastButtonLocator, "MyObservatoryLandingPageObjects.nineDayForecastButtonLocator");
    }

}
