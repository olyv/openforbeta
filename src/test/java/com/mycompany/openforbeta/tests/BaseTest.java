package com.mycompany.openforbeta.tests;

import com.mycompany.openforbeta.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
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
        if (driver == null)
        {
            driver = chooseDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// timeout
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static WebDriver chooseDriver()
    {
        String browser = java.lang.System.getProperties().getProperty("webbrowser");
        
        if (browser == null)
        {
            browser = "firefox";
        }
        if (browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome"))
        {
            if (System.getProperty("os.name").equalsIgnoreCase("linux"))
            {
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver-linux64");
                driver = new ChromeDriver();
            }
            else if (System.getProperty("os.name").equalsIgnoreCase("windows 7"))
            {
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
            }
        }
        else
        {
            System.out.println(browser + " is not defined. Check spelling");
        }

        return driver;
    }

    @BeforeClass
    public void setUp()
    {
        driver = getDriver();
    }

    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }

}
