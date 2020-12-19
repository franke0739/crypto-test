package util;

import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.InputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class BaseUtil {

    public Scenario scn;
    public Timestamp timestamp;
    public IOSDriver<IOSElement> driver;
    public AppiumDriver androidDriver;
    public String webDriverSessionId;
    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public BaseUtil(Scenario scn){
        this.scn = scn;
    }

    public void writeSteps(String message){
        timestamp = new Timestamp(System.currentTimeMillis());
        scn.write(String.format("[%s]   %s", SDF.format(timestamp), message));
    }

    public IOSDriver<IOSElement> createIosDriver(URL appiumUrl){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.2");
        capabilities.setCapability(MobileCapabilityType.APP, "./src/main/resources/locspc.app");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        driver = new IOSDriver<IOSElement>(appiumUrl, capabilities);
        return driver;
    }

    public AppiumDriver createAndroidDriver(Scenario scn, String avd, URL appiumUrl, String apkPath, String appPackage, String appActivity){
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
            capabilities.setCapability("avd",avd);
            capabilities.setCapability(MobileCapabilityType.APP, apkPath);
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
            capabilities.setCapability("autoGrantPermissions", "true");
            capabilities.setCapability("automationName", "UiAutomator2");
            androidDriver = new AppiumDriver<>(appiumUrl, capabilities);
            webDriverSessionId = ((RemoteWebDriver) androidDriver).getSessionId().toString();
            writeSteps("Start LocalDriver: " + androidDriver);
            return androidDriver;
        }
        catch (Throwable e){
            writeSteps(e.getMessage());
            return null;
        }
    }

    public InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            writeSteps("File not found: " + fileName);
            throw new IllegalArgumentException("File not found: " + fileName);
        } else {
            return inputStream;
        }
    }

}
