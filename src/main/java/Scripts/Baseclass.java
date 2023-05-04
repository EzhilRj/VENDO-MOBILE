package Scripts;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static Utilities.Constants.*;

public class Baseclass {


    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;


    @BeforeTest
    public void StartApp() throws IOException {


        service = new AppiumServiceBuilder().withAppiumJS(new File(ServerPath)).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        UiAutomator2Options options =  new UiAutomator2Options();
        options.setDeviceName(Devicename);
        options.setApp(Apppath);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest(enabled = false)
    public void TearApp(){

        service.stop();
        driver.quit();

    }





}
