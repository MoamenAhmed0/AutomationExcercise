import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utilities.commonHelper.AssertionHelper;
import utilities.extentReport.ExtentReportListener;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;
import static utilities.driverManger.DriverManger.driver;

@Listeners(ExtentReportListener.class)
public class ProductCartTest extends BaseTest {
    HomePage home;
    ProductsPage products;
    ProductDetailsPage details;
    CartPage cart;

    @BeforeTest
    public void setupPages() {
        home = new HomePage();
        products = new ProductsPage();
        details = new ProductDetailsPage();
        cart = new CartPage();
    }

    @Test
    public void searchAndAddProductsToCart() {
        home.goToProducts();
        products.searchProduct("tshirt");
        products.openFirstProduct();
        String firstProduct = details.getProductName();
        details.setQuantity(2);
        details.addToCart();
        details.viewCart();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_info")));
        assertTrue(cart.getProductsCount() > 0);
        cart.isProductPresent(firstProduct, 2);

        home.goToProducts();
        products.addProductToCartByIndex(3);
        products.closeCartModal();
        home.goToCart();
        AssertionHelper.assertEqual(cart.getProductsCount(), 2);
    }
}
