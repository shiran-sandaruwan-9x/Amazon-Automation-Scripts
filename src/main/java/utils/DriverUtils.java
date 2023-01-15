package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class DriverUtils {
    public static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver(){
        if (driver==null){
            driver = new ChromeDriver();
        }
        return driver;
    }
    @AfterSuite(alwaysRun = true)
    public void downDriver(){

    }


}
