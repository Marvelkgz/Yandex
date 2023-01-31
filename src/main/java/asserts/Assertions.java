package asserts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Assertions {

    @FindBy(xpath = "//div[@class='PSHeaderIcon PSHeaderIcon_Mail']")
    public WebElement assertMailPage;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement enterInMail;



}
