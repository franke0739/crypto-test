package appium.mobileApp.pom.pageSteps;

import cucumber.api.Scenario;
import org.openqa.selenium.By;
import appium.mobileApp.pom.pageObjects.BasePageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class BasePageSteps <T extends BasePageObjects> {

    public WebDriver androidDriver;
    public Scenario scn;
    public Timestamp timestamp;
    protected WebDriverWait longWait, shortWait;
    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public BasePageSteps(WebDriver androidDriver, Scenario scn){
        this.androidDriver = androidDriver;
        this.scn = scn;
        this.longWait =  new WebDriverWait(androidDriver, 30);
        this.shortWait = new WebDriverWait(androidDriver, 5);
    }

    public void writeSteps(String message){
        timestamp = new Timestamp(System.currentTimeMillis());
        scn.write(String.format("[%s]   %s", SDF.format(timestamp), message));
    }

    public void sleep(int t, String reason) {
        String step = "Sleep ";
        try {
            Thread.sleep(t * (long) 1000);
            writeSteps(step + t + " second/s Reason: " + reason);
        } catch (Throwable e) {
            writeSteps(step + e.getMessage());
            throw new AssertionError(e.getMessage());
        }
    }


    protected void click(By locator, String elementName){
        String step = "Click ";
        findElement(locator).click();
        writeSteps(step + elementName + " by Selenium Class");
    }

    protected WebElement findElement(By locator){
        return androidDriver.findElement(locator);
    }


    protected void waitForVisibilityOf(By locator, String elementName){
        String step = "WaitForVisibilityOf ";
        if(locator!=null) {
            double start = System.currentTimeMillis();
            longWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            double finish = System.currentTimeMillis();
            String totalTime = Double.toString((finish - start) / 1000) + "seconds";
            writeSteps(step + elementName + " - " + totalTime);
        }
        else{
            System.out.println("Null WebElement");
        }
    }

    protected String getElementText(By locator){
        String step = "GetElementText ";
        String text;
        if(locator!=null) {
            text = findElement(locator).getText();
            writeSteps(step + text);
            return text;
        }
        else{
            System.out.println("Null Locator");
            return null;
        }
    }
}
