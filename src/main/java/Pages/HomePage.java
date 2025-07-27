package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.driverManger.DriverManger;
import utilities.commonHelper.ElementHelper;

public class HomePage {
    WebDriver driver ;
    By Signup_Login = By.linkText("Signup / Login");

    public HomePage() {
        this.driver = DriverManger.getDriver();
    }
    public void clickOnSignup_LoginBtn(){
        ElementHelper.click(driver,Signup_Login);
    }

}
