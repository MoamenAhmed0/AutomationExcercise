
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.SignUpPage;
import org.testng.annotations.*;
import utilities.commonHelper.AssertionHelper;
import utilities.driverManger.DriverManger;
import utilities.extentReport.ExtentReportListener;

    @Listeners(ExtentReportListener.class)
    public class Logout extends BaseTest {
        HomePage home;
        SignUpPage signUp;


            @BeforeTest
            public void setupPages () {
                home = new HomePage();
                signUp = new SignUpPage();
            }

            @Test
            public void logout () {
                home.clickOnSignup_LoginBtn();
                signUp.enterName().enterEmail()
                        .clickSignupButton()
                        .enterTitle("Mrs").enterPassword()
                        .chooseDays("1").chooseMonth("May").chooseYear("2000")
                        .checkNewsletter().checkSpecialOffer()
                        .enterFirstName("Test").enterLastName("User").enterAddress("Address")
                        .selectCountry("India").enterState("State").enterCity("City")
                        .enterZipcode("12345").enterMobileNumber().clickCreateAccountBtn()
                        .assertAccountCreatedSuccessfully("https://www.automationexercise.com/account_created", "ACCOUNT CREATED!");
                signUp.clickContinue();
                home.logout();
                AssertionHelper.assertUrl(DriverManger.getDriver(), "https://www.automationexercise.com/login");
            }
        }