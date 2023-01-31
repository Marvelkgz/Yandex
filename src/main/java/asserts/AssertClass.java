package asserts;

import helperMethods.Helper;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertClass extends Helper {

    public void assertText(String expected, WebElement actual,String message){
        waitElementToBeDisplayed(actual);
        assertEquals(expected,actual.getText(),"Comparing " + message +" " +": ");
    }
}
