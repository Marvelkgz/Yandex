package driver;

import dataProvider.ConfigReader;
import org.openqa.selenium.WebDriver;

public class Driver {

    private Driver(){
        //Singleton pattern
    }

    private static WebDriver driver;

    public static WebDriver getDriver(){
      if (driver == null){
          switch (ConfigReader.getProperty("browser").toLowerCase().trim()){
                  case "firefox":
                      driver = FireFoxWebDriver.loadFireFoxDriver();
              case "edge":
                  driver = EdgeWebDriver.loadEdgeDriver();
                  break;
              default:
                  driver = ChromeWebDriver.loadChromeDriver();
          }
      }
        return driver;
    }

    public static void closeDriver(){
        try{
            if (driver != null){
                driver.close();
                driver.quit();
                driver = null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
