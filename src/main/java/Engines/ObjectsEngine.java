package Engines;

import Utilities.ExcelUtils;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static Scripts.Baseclass.driver;
import static Utilities.ExcelUtils.TestDatas;

public class ObjectsEngine {


    public static By Locator;


    //ISP FillForm Textboxes Datas----------------------------------------------------------------

    public static void Nationalitytxtbox(){
        driver.findElement(By.xpath("//android.widget.EditText[@text='Nationality*\n" + "Select Nationality']")).sendKeys(TestDatas);
        driver.findElement(By.xpath(" //android.widget.EditText[@text='Country*']")).click();
    }

    public static void Countrytxtbox() {
        driver.findElement(By.xpath("//android.widget.EditText[@text='Country*\n" + "Select Country']")).sendKeys(TestDatas);
        driver.findElement(By.xpath("//android.widget.EditText[@text='State*']")).click();
    }

    public static void State() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.EditText[@text='State*\n" + "Select State']")).sendKeys(TestDatas);
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId(TestDatas)).click();
    }

    public static void Area() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.EditText[@text='Area*\n" + "Select Area']")).sendKeys(TestDatas);
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId(TestDatas)).click();
    }

    public static void AadharnotxtBox() throws InterruptedException {
        driver.findElement(Aadharnotxtbox).sendKeys(TestDatas);
    }


    public static By Aadharnotxtbox = By.xpath("//android.widget.EditText[@text='Aadhaar No*\n" + "Aadhaar No']");
    public static By capturebutton = By.xpath("//android.widget.Button[@index='1']");
    public static By Listview = By.xpath("//android.widget.TextView[@content-desc=\"List View\"]");
    public static By Dialogbox = By.id("com.android.permissioncontroller:id/grant_dialog");
    public static By Allowbutton = By.xpath("//android.widget.Button[@index='0']");



    public static void element() {

        switch (ExcelUtils.locatorname) {
            case "id":
                Locator = ObjectsEngine.getId(ExcelUtils.locatorvalue);
                break;
            case "name":
                Locator = ObjectsEngine.getname(ExcelUtils.locatorvalue);
                break;
            case "className":
                Locator = ObjectsEngine.getclassname(ExcelUtils.locatorvalue);
                break;
            case "xpath":
                Locator = ObjectsEngine.getxpath(ExcelUtils.locatorvalue);
                break;
            case "linktext":
                Locator = ObjectsEngine.getlinktext(ExcelUtils.locatorvalue);
                break;
        }

    }


    public static By getId(String locatorvalue) {

        return By.id(locatorvalue);

    }

    public static By getname(String locatorvalue) {

        return By.name(locatorvalue);
    }

    public static By getclassname(String locatorvalue) {

        return By.className(locatorvalue);
    }

    public static By getxpath(String locatorvalue) {

        return By.xpath(locatorvalue);
    }

    public static By getlinktext(String locatorvalue) {

        return By.linkText(locatorvalue);
    }

    public static By getpartiallinktext(String locatorvalue) {

        return By.partialLinkText(locatorvalue);
    }

    public static By getCssselector(String locatorvalue) {

        return By.cssSelector(locatorvalue);
    }

    public static By getTagname(String locatorvalue) {

        return By.tagName(locatorvalue);
    }
}
