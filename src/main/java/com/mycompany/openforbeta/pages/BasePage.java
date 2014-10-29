package com.mycompany.openforbeta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage
{
    protected WebDriver driver;

    @FindBy(xpath = "//a[text()='Login']")
    protected WebElement loginLink;

    @FindBy(xpath = "//a[text()='Signup']")
    protected WebElement signupLink;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void getUrl(String url)
    {
        driver.get(url);
    }
}
