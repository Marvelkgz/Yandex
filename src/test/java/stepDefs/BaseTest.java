package stepDefs;

import BasePage.BasePage;
import asserts.AssertClass;
import asserts.Assertions;
import driver.Driver;
import helperMethods.Helper;
import yandexPage.LoginPage;
import org.openqa.selenium.WebDriver;
import yandexPage.MailPage;


public abstract class BaseTest {


    protected Helper helper = new Helper();
    protected WebDriver driver = Driver.getDriver();
    protected LoginPage loginPage = new LoginPage();
    protected MailPage mailPage = new MailPage();
    protected Assertions assertions = new Assertions();
}
