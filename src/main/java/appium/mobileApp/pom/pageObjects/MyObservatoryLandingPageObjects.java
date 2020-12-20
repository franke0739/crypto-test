package appium.mobileApp.pom.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyObservatoryLandingPageObjects extends BasePageObjects{

    public MyObservatoryLandingPageObjects(WebDriver androidDriver){super(androidDriver);}

    public static By closeReminderButtonLocator = By.id("btn_friendly_reminder_skip");

    public static By reminderDialogLocator = By.id("card");

    public static By radarButtonLocator = By.xpath("//android.widget.ImageView[@content-desc='Radar Images']");

    public static By satelliteButtonLocator = By.xpath("//android.widget.ImageView[@content-desc='Satellite Images']");

    public static By weatherButtonLocator = By.xpath("//android.widget.ImageView[@content-desc='Weather Photos']");

    public static By navigateHamburgerButtonLocator = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");

    public static By leftDrawerLocator = By.id("left_drawer");

    public static By nineDayForecastButtonLocator = By.xpath("//android.widget.ListView[@resource-id='hko.MyObservatory_v1_0:id/left_drawer']/android.widget.LinearLayout[11]");

}
