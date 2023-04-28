package Engines;

import Utilities.ExcelUtils;
import org.openqa.selenium.By;

public class ObjectsEngine {


    public static By Locator;


    //ISP FillForm Textboxes Datas----------------------------------------------------------------
    public static By Nationalitytxtbox = By.xpath("//android.widget.EditText[@text='Nationality*\n" + "Select Nationality']");
    public static By Countrytxtbox = By.xpath("//android.widget.EditText[@text='Country*\n" + "Select Country']");
    public static By Statetxtbox = By.xpath("//android.widget.EditText[@text='State*\n" + "Select State']");
    public static By Areatxtbox = By.xpath("//android.widget.EditText[@text='Area*\n" + "Select Area']");
    public static By Aadharnotxtbox = By.xpath("//android.widget.EditText[@text='Aadhaar No*\n" + "Aadhaar No']");






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
