package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.driverManger.DriverManger;
import utilities.commonHelper.ElementHelper;

public class CheckoutPage {
    WebDriver driver;

    By addressSection = By.id("address_delivery");
    By commentTextArea = By.name("message");
    By placeOrderBtn = By.linkText("Place Order");

    public CheckoutPage(){
        driver = DriverManger.getDriver();
    }

    public boolean isAddressDisplayed(){
        return ElementHelper.isElementDisplayed(driver, addressSection);
    }

    public void enterComment(String comment){
        ElementHelper.sendText(comment, driver, commentTextArea);
    }

    public void clickPlaceOrder(){
        ElementHelper.click(driver, placeOrderBtn);
    }
}