package com.mycompany.openforbeta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Describes signup page
 */
public class SignUpPage extends BasePage
{
    public static final String WRONG_CAPTCHA = "Error: Image code wrong, please try again.";
    public static final String ALREADY_TAKEN_USERNAME = "Error: The username you entered is already taken.";

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='confirmpassword']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='captcha']")
    private WebElement captchaField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id='resultsignup']/p")
    private WebElement signupResultMessage;

    public SignUpPage(WebDriver driver)
    {
        super(driver);
    }

    public void enterUserCredentials(String name, String password, String email)
    {
        usernameField.sendKeys(name);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        emailField.sendKeys(email);
        submitButton.click();
    }

    public String getresultMessage()
    {
        return signupResultMessage.getText();
    }

    // it's going to be a method to get valid captcha for validation working signup scenario
    //private void getValidCpatcha()
}
