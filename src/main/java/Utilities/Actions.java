package Utilities;

import Engines.ObjectsEngine;
import Scripts.Baseclass;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileLock;
import java.util.List;

import static Engines.ObjectsEngine.*;
import static Scripts.Baseclass.driver;
import static Utilities.AppiumUtills.*;
import static Utilities.Constants.*;
import static Utilities.Constants.Apppath;
import static Utilities.ExcelUtils.Description;
import static Utilities.ExcelUtils.TestDatas;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;


public class Actions extends Baseclass {

    public static WebDriverWait wait;

    private static AndroidDriver driver;

    public Actions(AndroidDriver driver) {

        Actions.driver = driver;

    }
    public static void Enter() throws InterruptedException {

        driver.findElement(Locator).click();

        if(Locator.toString().contains("Nationality")){
            Nationalitytxtbox();
        }else if (Locator.toString().contains("Country")) {
            Countrytxtbox();
        }else if (Locator.toString().contains("State")) {
            State();
        }else if (Locator.toString().contains("Area")) {
            Area();
        }else if (Locator.toString().contains("Aadhaar No")) {
            AadharnotxtBox();
        }else{
            driver.findElement(Locator).sendKeys(TestDatas);
        }

    }

    public static void click() throws InterruptedException, IOException {

        if(Description.equalsIgnoreCase("Image Type")){
            uploadImage(TestDatas);
        }else{
            driver.findElement(Locator).click();
        }

        if(Locator.toString().contains("android.widget.RadioButton")){
            List<WebElement> Radioptions  = driver.findElements(Locator);
            if(TestDatas.equalsIgnoreCase("Male")){
                Radioptions.get(0).click();
            }else{
                Radioptions.get(1).click();
            }
        }
    }

    public static void Scroll() throws InterruptedException {

        Thread.sleep(1000);
        driver.hideKeyboard();
        try {
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + TestDatas + "\"));"));
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

}



