package Utilities;

import Scripts.Baseclass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

import static Engines.ObjectsEngine.*;
import static Utilities.Utils.*;
import static Utilities.ExcelUtils.Description;
import static Utilities.ExcelUtils.TestDatas;
import static io.appium.java_client.touch.offset.PointOption.point;


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


    public static void Scrollup() throws InterruptedException {

        Thread.sleep(1000);
        try {
            driver.hideKeyboard();
           driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void Scrolldown() throws InterruptedException {

        Thread.sleep(1000);
        try {
            driver.hideKeyboard();
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(100000)"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static boolean Verify() throws InterruptedException {

        String source = driver.getPageSource();
        boolean result  = source.contains(TestDatas);

        return result;
    }


}



