package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.DriverManager;

public class BaseTest {
    @Test
            //(groups = {"smoke", "regression"});
    public void OpenBrowser() throws InterruptedException{
        WebDriver driver = DriverManager.initDriver();
        driver.get("https://www.google.com");
        Thread.sleep(5000);
        driver.quit();
    }
}
