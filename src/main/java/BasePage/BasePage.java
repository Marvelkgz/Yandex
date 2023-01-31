package BasePage;

import driver.Driver;
import helperMethods.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import yandexPage.LoginPage;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    protected   Helper helper = new Helper();
    protected WebDriver driver = Driver.getDriver();


}
