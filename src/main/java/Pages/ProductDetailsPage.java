package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.driverManger.DriverManger;
import utilities.commonHelper.ElementHelper;

public class ProductDetailsPage {
    WebDriver driver;

    By productName = By.cssSelector(".product-information h2");
    By productCategory = By.cssSelector(".product-information p");
    By productPrice = By.cssSelector(".product-information span span");
    By productDescription = By.cssSelector(".product-information p:nth-of-type(1)");
    By quantityInput = By.id("quantity");
    By addToCartBtn = By.xpath("//button[@type='button']");
    By viewCartLink = By.xpath("//p[@class='text-center']/a");

    public ProductDetailsPage(){
        driver = DriverManger.getDriver();
    }

    public String getProductName(){
        return ElementHelper.getText(driver, productName);
    }

    public String getCategory(){
        return ElementHelper.getText(driver, productCategory);
    }

    public String getPrice(){
        return ElementHelper.getText(driver, productPrice);
    }

    public String getDescription(){
        return ElementHelper.getText(driver, productDescription);
    }

    public void setQuantity(int quantity) {
        WebElement input = driver.findElement(quantityInput);
        input.sendKeys(Keys.HOME);
        ElementHelper.sendText(String.valueOf(quantity), driver, quantityInput);
        String actualValue = input.getAttribute("value");
        if (!actualValue.equals(String.valueOf(quantity))) {
            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("arguments[0].value = arguments[1];", input, String.valueOf(quantity));
        }
    }

    public void addToCart(){
        ElementHelper.click(driver, addToCartBtn);
    }

    public void viewCart(){
        ElementHelper.click(driver, viewCartLink);
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_info")));
    }
}