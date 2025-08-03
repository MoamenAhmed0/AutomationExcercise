import Pages.*;
import org.testng.annotations.*;
import utilities.commonHelper.AssertionHelper;
import utilities.commonHelper.Global;
import utilities.extentReport.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class ContactUsTest extends BaseTest {
    HomePage home;
    ContactUsPage contact;
    Global global;

    @BeforeTest
    public void setupPages() {
        home = new HomePage();
        contact = new ContactUsPage();
        global = Global.getInstance();
    }

    @Test
    public void submitContactForm() {
        home.goToContactUs();
        contact.submitForm("Test User", global.getEmail(), "Subject", "Message body");
        AssertionHelper.assertTrue(contact.getSuccessMessage().contains("Success!"),"Contact us failed");
    }
}