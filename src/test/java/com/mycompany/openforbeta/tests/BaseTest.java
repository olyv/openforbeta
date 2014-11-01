package com.mycompany.openforbeta.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 *  This class contains methods common for test and setup-teardown methods
 */
public class BaseTest
{
    protected static WebDriver driver;

    protected static WebDriver getDriver()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// timeout
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeSuite
    public void setUp()
    {
        if (driver == null)
        {
            driver = getDriver();
        }
    }

    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
}