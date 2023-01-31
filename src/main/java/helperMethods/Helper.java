package helperMethods;

import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Helper {

    public Helper waitElementToBeClickable(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public Helper waitElementToBeDisplayed(WebElement element){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public Helper click(WebElement element){
       waitElementToBeDisplayed(element);
       waitElementToBeClickable(element);
       element.click();
        return this;
    }

    public Helper sendKeys(WebElement element, String str){
        waitElementToBeDisplayed(element);
        element.sendKeys(str);
        return this;
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public Helper pause(Integer milliseconds){
        try{
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return this;
    }

    public Helper javascriptScrollDownThePage(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,650)");
        return this;
    }

    public Helper jsClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()",element);
        return this;
    }

    public Helper clear(WebElement element){
        waitElementToBeDisplayed(element);
        element.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        element.sendKeys(Keys.BACK_SPACE);
        return this;
    }
}
