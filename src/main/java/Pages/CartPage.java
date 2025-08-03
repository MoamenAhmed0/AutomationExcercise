// src/main/java/Pages/CartPage.java
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.driverManger.DriverManger;
import utilities.commonHelper.ElementHelper;

import java.util.List;

public class CartPage {
    WebDriver driver;

    By cartRows = By.cssSelector("#cart_info table tbody tr");
    By productName = By.cssSelector(".cart_description h4 a");
    // Updated locator for quantity button
    By productQuantity = By.cssSelector("td.cart_quantity > button");
    By proceedToCheckoutBtn = By.cssSelector(".check_out");

    public CartPage(){
        driver = DriverManger.getDriver();
    }

    public int getProductsCount(){
        return ElementHelper.getElements(driver, cartRows).size();
    }

    public boolean isProductPresent(String name, int quantity){
        String target = name.trim().toLowerCase();
        List<WebElement> rows = ElementHelper.getElements(driver, cartRows);
        for(WebElement row: rows){
            String prodName = row.findElement(productName).getText().trim().toLowerCase();
            // Read quantity from button text
            String qtyText = row.findElement(productQuantity).getText().trim();
            int qty = Integer.parseInt(qtyText.replaceAll("[^0-9]", ""));
            if(prodName.equals(target) && qty == quantity){
                return true;
            }
        }
        return false;
    }

    public void proceedToCheckout(){
        ElementHelper.click(driver, proceedToCheckoutBtn);
    }
}