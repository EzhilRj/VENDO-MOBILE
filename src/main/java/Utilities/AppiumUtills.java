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
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static Engines.ObjectsEngine.*;
import static Scripts.Baseclass.driver;
import static Utilities.Constants.Galleryimagname;
import static Utilities.Constants.TClocation;
import static Utilities.ExcelUtils.Locators;
import static Utilities.ExcelUtils.TestDatas;

public class AppiumUtills {

    private static boolean dialog;

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

        dialog = driver.findElement(Dialogbox).isDisplayed();

        if(uploadtype.equalsIgnoreCase("Camera")){

            if(dialog==true){

                Permissionhandler();

            }else {
                driver.findElement(AppiumBy.accessibilityId("Camera")).click();
                driver.findElement(capturebutton).click();
            }

        }else{
            if(dialog==true){

                Permissionhandler();

            }else {
                driver.findElement(AppiumBy.accessibilityId("GALLERY")).click();
                driver.findElement(Listview).click();
                driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + Galleryimagname + "\"));"));
                driver.findElement(By.xpath("//android.widget.TextView[@text='"+Galleryimagname+"']")).click();

            }

        }
    }

    public static void Permissionhandler(){

        for (int i = 0; i < 4; i++) {
            if(driver.findElement(Dialogbox).isDisplayed()) {
                driver.findElement(Allowbutton).click();
            }
        }
    }



}
