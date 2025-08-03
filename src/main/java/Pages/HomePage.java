package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.driverManger.DriverManger;
import utilities.commonHelper.ElementHelper;

public class HomePage {
    WebDriver driver ;
    By Signup_Login = By.linkText("Signup / Login");
    By cartLink = By.linkText("Cart");
    By contactUsLink = By.linkText("Contact us");
    By logoutLink = By.linkText("Logout");
    By cartBadge = By.cssSelector("a[href='/view_cart'] span");

    public HomePage() {
        this.driver = DriverManger.getDriver();
    }
    public void clickOnSignup_LoginBtn(){
        ElementHelper.click(driver,Signup_Login);
    }

    public void goToProducts(){
        // direct navigation avoids intermittent overlay issues that block the Products link
        driver.navigate().to("https://www.automationexercise.com/products");
    }

    public void goToCart(){
        ElementHelper.click(driver,cartLink);
    }

    public void goToContactUs(){
        ElementHelper.click(driver,contactUsLink);
    }

    public void logout(){
        ElementHelper.click(driver,logoutLink);
    }

    public String getCartBadge(){
        return ElementHelper.getText(driver,cartBadge);
    }

}