package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.driverManger.DriverManger;
import utilities.commonHelper.ElementHelper;

import java.time.Duration;

public class ContactUsPage {
    WebDriver driver;

    By nameInput = By.cssSelector("input[data-qa='name']");
    By emailInput = By.cssSelector("input[data-qa='email']");
    By subjectInput = By.cssSelector("input[data-qa='subject']");
    By messageInput = By.cssSelector("textarea[data-qa='message']");
    By submitBtn = By.cssSelector("input[data-qa='submit-button']");
    By successAlert = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]");

    public ContactUsPage(){
        driver = DriverManger.getDriver();
    }

    public void submitForm(String name,String email,String subject,String message){
        ElementHelper.sendText(name, driver, nameInput);
        ElementHelper.sendText(email, driver, emailInput);
        ElementHelper.sendText(subject, driver, subjectInput);
        ElementHelper.sendText(message, driver, messageInput);
        ElementHelper.click(driver, submitBtn);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (org.openqa.selenium.NoAlertPresentException | org.openqa.selenium.TimeoutException e) {
            // No alert present or timeout, continue

        }
    }

    public String getSuccessMessage(){
        return ElementHelper.getText(driver, successAlert);
    }
}
