package yandexPage;

import BasePage.BasePage;
import driver.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class MailPage extends BasePage {

    @FindBy(xpath = "//a[@class='Button2 Button2_type_link Button2_view_action Button2_size_m Layout-m__compose--pTDsx qa-LeftColumn-ComposeButton ComposeButton-m__root--fP-o9']")
    public WebElement writeMessage;

    @FindBy(xpath = "//div[@id='compose-field-1']")
    public WebElement click;

    @FindBy(xpath = "//div[@class='ComposeContactsList-Item ContactsSuggestItemDesktop ContactsSuggestItemDesktop_active']")
    public WebElement clickSendMe;

    @FindBy(xpath = "//input[@id='compose-field-subject-4']")
    public WebElement writeTheme;

    @FindBy(xpath = "//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_htmlplaceholder']")
    public WebElement writeText;

    @FindBy(xpath = "//button[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']")
    public WebElement clickSend;

    @FindBy(xpath = "//button[@class='Button2 Button2_view_action Button2_size_m Layout-m__sync--3L1uJ qa-LeftColumn-SyncButton']")
    public WebElement refresh;

    private static final String UNREAD_XPATH = "//a[contains(@class,'is-unread')]//span[@title='%s']";
    @FindBy(xpath = "//a[contains(@class,'is-unread')]")
    public List<WebElement> unreadMessage;

    @FindBy(xpath = "(//a[contains(@class,'is-unread')])[2]")
    public WebElement clickUnreadMessage;

    @FindBy(xpath = "(//div[@class='qa-LeftColumn-FolderNodeContent'])[1]")
    public WebElement clickIncomingMessage;

    @FindBy(xpath = "(//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag'])[1]")
    public WebElement clickCheckBo;

    @FindBy(xpath = "//div[@title='Удалить (Delete)']")
    public WebElement clickDelete;

    public MailPage clickWriteMessage() {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        helper.click(writeMessage);
        return this;
    }

    public MailPage clickSendWhom() {
        helper.click(click);
        return this;
    }

    public MailPage clickSendMeMessage() {
        helper.click(clickSendMe);
        return this;
    }

    public MailPage writeThemeTest(String theme) {
        helper.sendKeys(writeTheme, theme);
        return this;
    }

    public MailPage writeMessage(String message) {
        helper.sendKeys(writeText, message);
        return this;
    }

    public MailPage clickSendMessage() {
        helper.click(clickSend);
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        return this;
    }

    public MailPage clickRefresh() {
        helper.click(refresh);
        return this;
    }

    public Integer getUnreadMessageSize() {
        return unreadMessage.size();
    }


    public void clickMyUnreadMessage(String str) {
        String xpath = String.format(UNREAD_XPATH, str);
        List<WebElement> listOfUnreadTitles = driver.findElements(By.xpath(xpath));

        for (int i = 0; i < listOfUnreadTitles.size(); i++) {
            if (listOfUnreadTitles.get(i).getText().contains(str)) {
                listOfUnreadTitles.get(i).click();
                helper.click(clickUnreadMessage);
            }
        }
    }

    public MailPage clickMyUnreadMessageAgain() {
        helper.click(clickUnreadMessage);
        return this;
    }
    public MailPage clickMyIncomingMessage() {
        helper.click(clickIncomingMessage);
        return this;
    }
    public MailPage clickCheckBox(){
        helper.click(clickCheckBo);
        return this;
    }

    public MailPage clickCheckBoxDelete(){
        helper.click(clickDelete);
        return this;
    }

}
