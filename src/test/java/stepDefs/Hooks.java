package stepDefs;

import dataProvider.ConfigReader;
import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {




//    @After
//    public void closeDriver() {
//        Driver.getDriver().close();
//        Driver.getDriver().quit();
//    }

//    @After
//    public void tearDawn(Scenario scenario){
//        try{
//            if (scenario.isFailed()){
//                final byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//                scenario.attach(screenshot,"image/png","screenshot");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        Driver.closeDriver();
//    }


}
