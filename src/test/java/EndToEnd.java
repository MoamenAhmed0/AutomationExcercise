import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utilities.commonHelper.AssertionHelper;
import utilities.commonHelper.Global;
import utilities.driverManger.DriverManger;
import utilities.extentReport.ExtentReportListener;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;
import static utilities.driverManger.DriverManger.driver;

@Listeners(ExtentReportListener.class)
public class EndToEnd extends BaseTest {

    HomePage home;
    SignUpPage signUp;
    ProductsPage products;
    ProductDetailsPage details;
    CartPage cart;
    CheckoutPage checkout;
    PaymentPage payment;
    ContactUsPage contact;
    Global global;

    @BeforeTest
    public void setupPages(){
        home = new HomePage();
        signUp = new SignUpPage();
        products = new ProductsPage();
        details = new ProductDetailsPage();
        cart = new CartPage();
        checkout = new CheckoutPage();
        payment = new PaymentPage();
        contact = new ContactUsPage();
        global = Global.getInstance();
    }

    @Test
    public void fullJourney(){
        // register new user and login
        home.clickOnSignup_LoginBtn();
        signUp.enterName().enterEmail()
                .clickSignupButton()
                .enterTitle("Mrs").enterPassword()
                .chooseDays("1").chooseMonth("May").chooseYear("2000")
                .checkNewsletter().checkSpecialOffer()
                .enterFirstName("Test").enterLastName("User").enterAddress("Address")
                .selectCountry("India").enterState("State").enterCity("City")
                .enterZipcode("12345").enterMobileNumber().clickCreateAccountBtn()
                .assertAccountCreatedSuccessfully("https://www.automationexercise.com/account_created","ACCOUNT CREATED!");
        signUp.clickContinue();

        // Browse products and search
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

        // Cart verification for first product
        //AssertionHelper.assertTrue(cart.isProductPresent(firstProduct,2),"First product not in cart");

        // Add second product
        home.goToProducts();
        products.addProductToCartByIndex(2);
        products.closeCartModal();
        home.goToCart();
        AssertionHelper.assertEqual(cart.getProductsCount(),2);

        // Checkout and place order
        cart.proceedToCheckout();
        checkout.enterComment("Please deliver fast");
        checkout.clickPlaceOrder();
        payment.enterPaymentDetails("Test User","4111111111111111","123","12","2025");
        payment.confirmOrder();
        AssertionHelper.assertTrue(payment.getSuccessMessage().contains("Congratulations!"),"Order not placed");

        // Contact Us
        home.goToContactUs();
        contact.submitForm("Test User", global.getEmail(), "Subject", "Message body");
        AssertionHelper.assertTrue(contact.getSuccessMessage().contains("Success!"),"Contact us failed");

        // Logout and session validation
        home.logout();
        AssertionHelper.assertUrl(DriverManger.getDriver(),"https://www.automationexercise.com/login");
    }
}

