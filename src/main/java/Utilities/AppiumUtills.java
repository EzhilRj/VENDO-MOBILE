package Utilities;

import Engines.ObjectsEngine;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static Engines.ObjectsEngine.Locator;
import static Scripts.Baseclass.driver;
import static Utilities.Constants.Galleryimagname;
import static Utilities.Constants.TClocation;
import static Utilities.ExcelUtils.Locators;
import static Utilities.ExcelUtils.TestDatas;

public class AppiumUtills {

    public String Screenshot(String Testcasename, AppiumDriver driver) throws IOException {

        File source = driver.getScreenshotAs(OutputType.FILE);
        String destination = "E:\\Automation Workspace\\VENDO_MOBILE\\Screenshots"+Testcasename+".png";
        FileUtils.copyFile(source, new File(destination));
        return destination;

    }

    public List<HashMap<String, String>> getjsondata(String jsonfilepath) throws IOException {

        String jsoncontent = FileUtils.readFileToString(new File(jsonfilepath));

        ObjectMapper objectMapper = new ObjectMapper();
        List<HashMap<String,String>> data = objectMapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;

    }

    public static void uploadImage(String uploadtype) throws InterruptedException, IOException {

        if(uploadtype.equalsIgnoreCase("Camera")){
            Permissionhandler();
            driver.findElement(AppiumBy.accessibilityId("Camera")).click();
            driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();

        }else{
            driver.findElement(AppiumBy.accessibilityId("GALLERY")).click();
            driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"List View\"]")).click();
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + Galleryimagname + "\"));"));
            driver.findElement(By.xpath("//android.widget.TextView[@text='"+Galleryimagname+"']")).click();

        }
    }

    public static void Permissionhandler(){

        for (int i = 0; i < 4; i++) {
            if(driver.findElement(By.id("com.android.permissioncontroller:id/grant_dialog")).isDisplayed()) {
                driver.findElement(By.xpath("//android.widget.Button[@index='0']")).click();
            }
        }
    }

    public static void TextReader() throws IOException {

        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Terms & Conditions\"]")).click();

        String getcontent = null;
        for (int i = 1; i < 16; i++) {

            getcontent = driver.findElement(By.xpath("//android.view.View[@index='" + i + "']")).getAttribute("content-desc\n");

        }

        List<String> lines = new ArrayList<>();
        lines.add(getcontent);
       // test
    }

    public static void Fill(WebElement Loc) throws InterruptedException {

        if(Locator.toString().contains("Nationality")){
            driver.findElement(ObjectsEngine.Nationalitytxtbox).sendKeys(TestDatas);
            driver.findElement(By.xpath(" //android.widget.EditText[@text='Country*']")).click();
        }else if (Locator.toString().contains("Country")) {
            driver.findElement(ObjectsEngine.Countrytxtbox).sendKeys(TestDatas);
            driver.findElement(By.xpath("//android.widget.EditText[@text='State*']")).click();
        }else if (Locator.toString().contains("State")) {
            driver.findElement(ObjectsEngine.Statetxtbox).sendKeys(TestDatas);
            Thread.sleep(1000);
            driver.findElement(AppiumBy.accessibilityId(TestDatas)).click();
        }else if (Locator.toString().contains("Area")) {
            driver.findElement(ObjectsEngine.Areatxtbox).sendKeys(TestDatas);
            Thread.sleep(1000);
            driver.findElement(AppiumBy.accessibilityId(TestDatas)).click();
        }else if (Locator.toString().contains("Aadhaar No")) {
            driver.findElement(ObjectsEngine.Aadharnotxtbox).sendKeys(TestDatas);
        }else{

            driver.findElement(Locator).sendKeys(TestDatas);
        }
    }

}
