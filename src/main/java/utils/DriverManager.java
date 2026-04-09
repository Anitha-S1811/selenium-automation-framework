package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    public static WebDriver initDriver(){
        String browser = System.getProperty("browser", "chrome");
        return switch (browser.toLowerCase()) {
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            default -> new ChromeDriver();
        };


    }

}
