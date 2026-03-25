package mobile_tests;

import io.appium.java_client.AppiumDriver;
import manager.AppiumConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected static AppiumDriver driver;

    @BeforeMethod
    public  void setup(){
        driver = AppiumConfig.createAppiumDriver("pixel.properties");

    }


    @AfterMethod(enabled = false)
    public void tearDown(){
        if(driver!=null)
            driver.quit();
    }
}
