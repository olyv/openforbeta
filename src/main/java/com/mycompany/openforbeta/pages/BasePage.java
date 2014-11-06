package com.mycompany.openforbeta.pages;

import com.mycompany.openforbeta.pages.common.LoginPageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    protected static Logger logger = LogManager.getLogger("com.mycompany.openforbeta");

    @FindBy(xpath = "//a[text()='Login']")
    protected WebElement loginLink;

    @FindBy(xpath = "//a[text()='Signup']")
    protected WebElement signupLink;

    @FindBy(xpath = "//div[@class='loginlink navigation']//a[1]")
    private WebElement looggedInUserName;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getUrl(String url)
    {
        driver.get(url);
    }

    public LoginPageObject openLoginPopup()
    {
        loginLink.click();
        logger.info("user clicked link to open login poup");
        return PageFactory.initElements(driver, LoginPageObject.class);
    }

    public String getLoggdInUsername()
    {
        String userName = looggedInUserName.getText();
        logger.info("found logged in " + userName);
        return userName;
    }

    public SignUpPage openSignUpPage()
    {
        signupLink.click();
        logger.info("user clicked link to signup");
        return PageFactory.initElements(driver, SignUpPage.class);
    }
}
