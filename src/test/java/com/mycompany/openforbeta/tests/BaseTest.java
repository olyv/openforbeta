package com.mycompany.openforbeta.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 *  This class contains methods common for test and setup-teardown methods
 */
public class BaseTest
{
    protected static WebDriver driver;

    protected static WebDriver getDriver()
    {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference(FirefoxProfile.PORT_PREFERENCE, 8081);

        driver = new FirefoxDriver(profile);
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