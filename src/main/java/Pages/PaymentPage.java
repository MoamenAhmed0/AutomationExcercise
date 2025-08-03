package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.driverManger.DriverManger;
import utilities.commonHelper.ElementHelper;

public class PaymentPage {
    WebDriver driver;

    By nameOnCard = By.name("name_on_card");
    By cardNumber = By.name("card_number");
    By cvc = By.name("cvc");
    By expMonth = By.name("expiry_month");
    By expYear = By.name("expiry_year");
    By payButton = By.cssSelector("#submit");
    By successMessage = By.cssSelector("#form > div > div > div > p");

    public PaymentPage(){
        driver = DriverManger.getDriver();
    }

    public void enterPaymentDetails(String name,String number,String cvcCode,String month,String year){
        ElementHelper.sendText(name, driver, nameOnCard);
        ElementHelper.sendText(number, driver, cardNumber);
        ElementHelper.sendText(cvcCode, driver, cvc);
        ElementHelper.sendText(month, driver, expMonth);
        ElementHelper.sendText(year, driver, expYear);
    }

    public void confirmOrder(){
        ElementHelper.click(driver, payButton);
    }

    public String getSuccessMessage(){
        return ElementHelper.getText(driver, successMessage);
    }
}
