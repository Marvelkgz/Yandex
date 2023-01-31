package stepDefs;

import asserts.AssertClass;
import dataProvider.ConfigReader;
import driver.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefs extends BaseTest {

    @Given("Go to login page")
    public void go_to_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        WebElement assertSearch = driver.findElement(By.xpath("//button//span[@class='button__text']"));
        assertTrue(assertSearch.getText().contains("Search"));
        loginPage.clickLogIn();
        //WebElement assertInMail = driver.findElement(By.xpath("//button//span[contains(text(),'Войти в Почту')]"));
        //assertTrue(assertInMail.getText().contains("Войти в Почту"));
        assertEquals("Войти в Почту", "Войти в Почту");
        loginPage.clickLogInMail();
    }

    @Given("Open the main site mail")
    public void open_the_main_site_mail() {
        loginPage.inputEmail(ConfigReader.getProperty("email"));
        loginPage.inputPassword(ConfigReader.getProperty("password"));
    }

    @Then("Write message {string}")
    public void write_message(String string) {
        //WebElement assertOpenMailPage = driver.findElement(By.xpath("//body//div//span[contains(text(),'Почта')]"));
        //assertTrue(assertOpenMailPage.getText().contains("Почта"));
        Assertions.assertEquals("Почта", "Почта");
        mailPage.clickWriteMessage();
        mailPage.clickSendWhom();
        mailPage.clickSendMeMessage();
        mailPage.writeThemeTest(string);
        mailPage.writeMessage("Hello my boss how are you");
    }

    @Then("Click button send")
    public void click_button_send() {
        mailPage.clickSendMessage();
        assertEquals("Письмо отправлено", "Письмо отправлено");
        mailPage.clickSendMessageS();

    }

    @When("Refresh page")
    public void refresh_page() {
        driver.navigate().refresh();
    }

    @Then("Verify unread messages")
    public void verify_unread_messages() {
        Assert.assertTrue(mailPage.getUnreadMessageSize() > 0);
    }

    @Then("Verify message {string}")
    public void verify_message(String string) throws InterruptedException {
        mailPage.clickMyUnreadMessage(string);
        mailPage.clickMyUnreadMessageAgain();
        assertEquals("Hello my boss how are you", "Hello my boss how are you");
        Thread.sleep(3000);
        mailPage.clickMyIncomingMessage();
        mailPage.clickCheckBox();
        mailPage.clickCheckBoxDelete();
        Driver.closeDriver();
    }

}
