package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.driverManger.DriverManger;
import utilities.commonHelper.ElementHelper;

public class ProductsPage {
    WebDriver driver;

    By productItems = By.cssSelector(".productinfo");
    By searchInput = By.id("search_product");
    By searchButton = By.id("submit_search");
    By modalViewCart = By.xpath("//div[@id='cartModal']//p[@class='text-center']/a");

    public ProductsPage(){
        driver = DriverManger.getDriver();
    }

    public int getProductsCount(){
        return ElementHelper.getElements(driver, productItems).size();
    }

    public void searchProduct(String name){
        ElementHelper.sendText(name, driver, searchInput);
        ElementHelper.click(driver, searchButton);
    }

    public void openFirstProduct(){
        ElementHelper.click(driver, By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[5]/div/div[2]/ul/li/a"));
    }

    public void addProductToCartByIndex(int index){
        By productWrapper = By.xpath("(//div[@class='product-image-wrapper'])[" + index + "]");
        ElementHelper.scrollToElement(driver, productWrapper);
        ElementHelper.hoverOver(driver, productWrapper);

        By addToCartBtn = By.xpath("(//div[@class='product-image-wrapper'])[" + index + "]//a[contains(@class,'add-to-cart')]");
        ElementHelper.click(driver, addToCartBtn);

        ElementHelper.waitForVisibility(driver, By.id("cartModal"));
    }

    public void closeCartModal(){
        By continueShoppingBtn = By.xpath("//div[@id='cartModal']//button[@data-dismiss='modal']");
        ElementHelper.waitForVisibility(driver, continueShoppingBtn);
        ElementHelper.click(driver, continueShoppingBtn);
    }

    public void viewCartFromModal(){
        ElementHelper.click(driver, modalViewCart);
    }
}
