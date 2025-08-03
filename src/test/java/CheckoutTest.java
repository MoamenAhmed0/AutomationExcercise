import Pages.*;
import org.testng.annotations.*;
import utilities.commonHelper.AssertionHelper;
import utilities.commonHelper.Global;
import utilities.extentReport.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class CheckoutTest extends BaseTest {
    HomePage home;
    SignUpPage signUp;
    ProductsPage products;
    ProductDetailsPage details;
    CartPage cart;
    CheckoutPage checkout;
    PaymentPage payment;
    Global global;

    @BeforeTest
    public void setupPages() {
        home = new HomePage();
        signUp = new SignUpPage();
        products = new ProductsPage();
        details = new ProductDetailsPage();
        cart = new CartPage();
        checkout = new CheckoutPage();
        payment = new PaymentPage();
        global = Global.getInstance();
    }

    @Test
    public void placeOrder() {
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

        home.goToProducts();
        products.addProductToCartByIndex(3);
        products.closeCartModal();
        home.goToCart();

        cart.proceedToCheckout();
        checkout.enterComment("Please deliver fast");
        checkout.clickPlaceOrder();
        payment.enterPaymentDetails("Test User","4111111111111111","123","12","2025");
        payment.confirmOrder();
        AssertionHelper.assertTrue(payment.getSuccessMessage().contains("Congratulations!"),"Order not placed");
    }
}