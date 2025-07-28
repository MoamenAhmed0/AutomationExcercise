import Pages.HomePage;
import Pages.SignUpPage;

import org.testng.annotations.*;
import utilities.datareaders.DataProviderUtils;
import utilities.extentReport.ExtentReportListener;

import java.io.IOException;
import java.util.Iterator;

@Listeners(ExtentReportListener.class)
public class SignUp extends BaseTest{
    HomePage homepage;
    SignUpPage signUpPage;
    @BeforeTest
    public void setup(){
        homepage=new HomePage();
        signUpPage =new SignUpPage();
    }
    @Test
    public void signUp() {
        /* Test Case steps */
        homepage.clickOnSignup_LoginBtn();
        signUpPage.enterName().enterEmail().
                clickSignupButton().
                enterTitle("Mrs").
                enterPassword().
                chooseDays("1").chooseMonth("May").chooseYear("2019").
                checkNewsletter().checkSpecialOffer().
                enterFirstName("ro").enterLastName("Araby").enterAddress("Address").
                selectCountry("India").enterState("cairo").enterCity("z").
                enterZipcode("020").enterMobileNumber().clickCreateAccountBtn();

        /* Test case Assertions
        * first way
        *         String ActualMessage = signUpPage.returnActualAccountCreatedMessage();
       AssertionHelper.assertEqual( ActualMessage , "Account Created!");
       AssertionHelper.assertUrl(DriverManger.getDriver(), "https://www.automationexercise.com/account_created");
        */
       // second way call assertion method from business class .

        signUpPage.assertAccountCreatedSuccessfully("https://www.automationexercise.com/account_created","ACCOUNT CREATED!");

    }


     // using Data Provider ...
     @DataProvider(name = "signupData")
     public static Iterator<Object[]> signupData() throws IOException {
         // هنا بنغير  اسم الملف حسب اللي عايزين نشتغل عليه (CSV, Excel, JSON)
         String filePath = "src/test/resources/Signupdata.json";
         return DataProviderUtils.getData(filePath);
     }
    @Test(dataProvider = "signupData")
    public void signUpWithDataProvider(String title,
                       String day, String month, String year, String firstName,
                       String lastName, String address, String country, String state,
                       String city, String zipcode) {
        homepage.clickOnSignup_LoginBtn();
        signUpPage.enterName().enterEmail().clickSignupButton().enterTitle(title).enterPassword()
                .chooseDays(day).chooseMonth(month).chooseYear(year)
                .checkNewsletter().checkSpecialOffer()
                .enterFirstName(firstName).enterLastName(lastName)
                .enterAddress(address)
                .selectCountry(country).enterState(state).enterCity(city)
                .enterZipcode(zipcode).enterMobileNumber()
                .clickCreateAccountBtn();

        signUpPage.assertAccountCreatedSuccessfully(
                "https://www.automationexercise.com/account_created",
                "ACCOUNT CREATED!"
        );
    }
}
