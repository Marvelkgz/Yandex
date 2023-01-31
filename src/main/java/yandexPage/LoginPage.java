package yandexPage;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@class='b-inline']")
    public WebElement clickButtonLoginIn;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement clickButtonLoginMail;

    @FindBy(xpath = "//input[@id='passp-field-login']")
    public WebElement logInWithEmailOrNumberPhone;

    @FindBy(xpath = "//button[@id='passp:sign-in']")
    public WebElement submitLogIn;

    @FindBy(xpath = "//input[@id='passp-field-passwd']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@id='passp:sign-in']")
    public WebElement clickCreateAccount;

    public LoginPage clickLogIn(){
        helper.click(clickButtonLoginIn);
        return this;
    }
    public LoginPage clickLogInMail(){
        helper.click(clickButtonLoginMail);
        return this;
    }
    public LoginPage inputEmail(String email){
        helper.sendKeys(logInWithEmailOrNumberPhone,email);
        helper.click(submitLogIn);
        return this;
    }
    public LoginPage inputPassword(String password){
        helper.sendKeys(inputPassword,password);
        helper.click(clickCreateAccount);
        return this;
    }
}
