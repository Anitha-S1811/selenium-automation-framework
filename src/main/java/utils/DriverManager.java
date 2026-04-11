package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Properties;

public class DriverManager {
//    public static WebDriver initDriver(){
//        String browser = System.getProperty("browser", "chrome");
//        return switch (browser.toLowerCase()) {
//            case "firefox" -> new FirefoxDriver();
//            case "edge" -> new EdgeDriver();
//            default -> new ChromeDriver();
//        };
    private static WebDriver driver;

    public static WebDriver setupChrome(boolean headless){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //inside server
        if(headless){
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        return new ChromeDriver(options);
    }

    public static WebDriver setupFirefox(boolean headless){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        if(headless)
            options.addArguments("--headless");
        return new FirefoxDriver(options);
    }

    public static WebDriver initDriver(){
        String browser = ConfigReader.get("browser");
        switch (browser){
            case "chrome":
                 driver=  setupChrome(false);
                break;
            default:
                throw new RuntimeException("Browser " + browser + "not supported");
        }
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
