package utilities.driverManger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.config.LoadProperties;

import java.time.Duration;

public class DriverManger {
      static WebDriver driver ;
     // get it from properities file
      static String BrowserName= LoadProperties.BROWSER;
      static String URL=LoadProperties.URL;

    public  static  void initiation() {

        if (BrowserName.trim().equalsIgnoreCase("chrome"))  {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (BrowserName.trim().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (BrowserName.trim().equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (BrowserName.trim().equalsIgnoreCase("remote")) {

  //      driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"));
        }else{
            System.out.print(" browser name not correct!!");
        }
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public  static WebDriver  getDriver(){
        if (driver==null){
            initiation();
        }
        return driver;
    }
    public static  void  closeDriver(){
        driver.quit();
    }
}
