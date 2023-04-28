package Scripts;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static Utilities.Constants.*;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;

public class Baseclass {

    public AppiumDriverLocalService service;
    public static AndroidDriver driver;

    String Nodepath = "C:\\Program Files\\nodejs\\node.exe";


    @BeforeTest
    public void StartApp() throws MalformedURLException {

        UiAutomator2Options options =  new UiAutomator2Options();
        options.setDeviceName(Devicename);
        options.setApp(Apppath);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest(enabled = false)
    public void TearApp(){

        driver.quit();

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
