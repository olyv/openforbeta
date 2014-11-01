package com.mycompany.openforbeta.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
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

    @BeforeClass(alwaysRun = true)
    public void setUp()
    {
        if (driver == null)
        {
            driver = getDriver();
        }

        System.out.println("**************************** setup ******************");
    }

    @AfterClass
    public void tearDown()
    {
        driver.close();
        System.out.println("**************************** tesrdown ******************");
    }
}