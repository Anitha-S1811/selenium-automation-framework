package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DriverManager;
public class FirstTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
         driver = DriverManager.initDriver();
    }

    @Test
    public void verifyGoogle(){
        driver.get("https://www.saucedemo.com");
        System.out.println("Googlle opened");
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println("Title" + driver.getCurrentUrl());
        System.out.println("-------" + driver.getPageSource());
        driver.getPageSource(); //returns entire page as html
        Assert.assertEquals(title, "Swag Labs");
    }
    @AfterMethod
    public void tearDown(){
        DriverManager.closeDriver();
    }
}
