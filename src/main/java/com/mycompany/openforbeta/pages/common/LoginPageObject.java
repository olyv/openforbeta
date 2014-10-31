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
    @FindBy(name = "lusername")
    private WebElement userNameField;

    @FindBy(name = "lpassword")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement submitButton;

    public LoginPageObject(WebDriver driver)
    {
        super(driver);
    }

    public void loginUser(String username, String password)
    {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
    }
}
