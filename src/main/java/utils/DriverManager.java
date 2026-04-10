package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {
//    public static WebDriver initDriver(){
//        String browser = System.getProperty("browser", "chrome");
//        return switch (browser.toLowerCase()) {
//            case "firefox" -> new FirefoxDriver();
//            case "edge" -> new EdgeDriver();
//            default -> new ChromeDriver();
//        };
    private static WebDriver driver;
    public static WebDriver initDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
    public WebDriver getDriver(){
        return driver;
    }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }


    }



}
