package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.driverManger.DriverManger;
import utilities.commonHelper.ElementHelper;
import utilities.commonHelper.Global;


import static java.util.logging.Logger.global;

public class SignInPage {
    WebDriver driver;

    By SignIn_EmailAddress = By.xpath("//input[@data-qa='login-email']");
    By SignIn_Password = By.xpath("//input[@data-qa='login-password']");

    By LoginBtn = By.xpath("//button[text()='Login']");

    public SignInPage()
    {
        this.driver = DriverManger.getDriver();
    }

    public void enterEmail(String Email) {
        ElementHelper.sendText(Email,driver,SignIn_EmailAddress);
    }

    public void enterPassword(String password) {

        ElementHelper.sendText(password,driver,SignIn_Password);
    }
    public void clickLoginBtn() {
        ElementHelper.click(driver,LoginBtn);
    }
}
