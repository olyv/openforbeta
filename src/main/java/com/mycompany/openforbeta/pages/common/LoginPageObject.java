package com.mycompany.openforbeta.pages.common;

import com.mycompany.openforbeta.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *  This class describes popup which appears when user clicks 'login link'
 */
public class LoginPageObject extends BasePage
{
    public static final String WRONG_LOGIN_MESSAGE = "Error: Wrong username/password combination.";

    @FindBy(name = "lusername")
    private WebElement userNameField;

    @FindBy(name = "lpassword")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement submitButton;

    @FindBy(className = "pasgood")
    private WebElement wrongLoginMessage;

    public String getWrongLoginMessage()
    {
        return wrongLoginMessage.getText();
    }

    public LoginPageObject(WebDriver driver)
    {
        super(driver);
    }

    public void loginUser(String username, String password)
    {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
        logger.info("User enterd username, and password, clicked submit");
    }
}
