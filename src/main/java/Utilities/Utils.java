package Utilities;

import static Engines.ObjectsEngine.Allowbutton;
import static Engines.ObjectsEngine.Dialogbox;
import static Engines.ObjectsEngine.Listview;
import static Engines.ObjectsEngine.capturebutton;
import static Scripts.Baseclass.driver;
import static Utilities.Constants.Galleryimagname;
import static Utilities.Constants.Screenshotpath;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Utils {

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


        if(driver.findElements(Dialogbox).size()!=0) {
            Permissionhandler();
        }else{

        }

        if(uploadtype.equalsIgnoreCase("Camera")){

            driver.findElement(AppiumBy.accessibilityId("Camera")).click();
            Thread.sleep(500);
            driver.findElement(capturebutton).click();
        }else{
            driver.findElement(AppiumBy.accessibilityId("GALLERY")).click();
            driver.findElement(Listview).click();
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + Galleryimagname + "\"));"));
            driver.findElement(By.xpath("//android.widget.TextView[@text='"+Galleryimagname+"']")).click();
        }

    }

    public static void Permissionhandler(){

        for (int i = 0; i < 4; i++) {
            if(driver.findElement(Dialogbox).isDisplayed()) {
                driver.findElement(Allowbutton).click();
            }
        }
    }

    public static void scrollto(String txt){

        try {
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + txt + "\"));"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    @AfterMethod
    public void captureScreen(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
            File target = new File(Screenshotpath + result.getName() + ".png");

            FileUtils.copyFile(source, target);
        }

    }

}
