package com.mycompany.openforbeta.pages;

import com.mycompany.openforbeta.pages.common.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class descibes header of very page. It contains 'login' and 'signup' links
 */
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

    public LoginPageObject openLoginPopup()
    {
        loginLink.click();
        return PageFactory.initElements(driver, LoginPageObject.class);
    }
}
