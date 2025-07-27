package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.commonHelper.AssertionHelper;
import utilities.driverManger.DriverManger;
import utilities.commonHelper.ElementHelper;
import utilities.commonHelper.Global;


public class SignUpPage {
    WebDriver driver;
    By Name = By.name("name");
    By Email = By.xpath("//input[@data-qa='signup-email']");
    By SignupBtn = By.xpath("//button[text()='Signup']");
    By Password = By.id("password");
    By DaysDropdown = By.id("days");
    By MonthDropdown = By.id("months");
    By YearsDropdown = By.id("years");
    By Newsletter = By.xpath("//label[text()='Sign up for our newsletter!']");
    By SpecialOffer = By.xpath("//label[text()='Receive special offers from our partners!']");
    By First_name = By.id("first_name");
    By last_name = By.id("last_name");
    By Address = By.id("address1");
    By CountryDropdown = By.id("country");
    By State = By.id("state");
    By City = By.id("city");
    By Zipcode = By.id("zipcode");
    By Mobile_number = By.id("mobile_number");
    By Create_Account = By.xpath("//button[text()='Create Account']");
    By AccountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");
    Global global;

    public SignUpPage() {
        this.driver = DriverManger.getDriver();
        global = Global.getInstance();
    }

    public SignUpPage enterName() {
        global.setName(); // to  generate & store value
        ElementHelper.sendText(global.getName(), driver, Name);
        return this;
    }

    public SignUpPage enterEmail() {
        global.setEmail(); // to  generate & store value
        ElementHelper.sendText(global.getEmail(), driver, Email);

        return this;
    }

    public SignUpPage clickSignupButton() {
        ElementHelper.click(driver, SignupBtn);
        return this;
    }

    public SignUpPage enterFirstName(String fName) {
        ElementHelper.sendText(fName, driver, First_name);
        return this;
    }

    public SignUpPage enterLastName(String lName) {
        ElementHelper.sendText(lName, driver, last_name);
        return this;
    }

    public SignUpPage selectCountry(String countryName) {
        ElementHelper.selectTextFromDropDownByText(countryName, driver, CountryDropdown);
        return this;
    }

    public SignUpPage enterTitle(String title) {
        // ElementHelper.findElementByText(title,driver).sendKeys(title);
        ElementHelper.findElementByValue(title, driver).click();
        return this;
    }

    public SignUpPage enterPassword() {
        global.setPassword(); // to  generate & store value
        ElementHelper.sendText(global.getPassword(), driver, Password);
        return this;
    }

    public SignUpPage enterAddress(String address) {
        ElementHelper.sendText(address, driver, Address);
        return this;
    }

    public SignUpPage checkSpecialOffer() {
        ElementHelper.click(driver, SpecialOffer);
        return this;
    }

    public SignUpPage chooseDays(String day) {
        ElementHelper.selectTextFromDropDownByText(day, driver, DaysDropdown);
        return this;
    }

    public SignUpPage chooseMonth(String Month) {
        ElementHelper.selectTextFromDropDownByText(Month, driver, MonthDropdown);
        return this;
    }

    public SignUpPage chooseYear(String Year) {
        ElementHelper.selectTextFromDropDownByText(Year, driver, YearsDropdown);
        return this;
    }

    public SignUpPage checkNewsletter() {
        ElementHelper.click(driver, Newsletter);
        return this;
    }

    public SignUpPage enterState(String stateName) {
        ElementHelper.sendText(stateName, driver, State);
        return this;
    }

    public SignUpPage enterCity(String city) {
        ElementHelper.sendText(city, driver, City);
        return this;
    }

    public SignUpPage enterMobileNumber() {
        global.setMobileNumber();
        ElementHelper.sendText(global.getMobileNumber(), driver, Mobile_number);
        return this;
    }

    public SignUpPage enterZipcode(String zipCode) {
        ElementHelper.sendText(zipCode, driver, Zipcode);
        return this;
    }

    public SignUpPage clickCreateAccountBtn() {
        ElementHelper.click(driver, Create_Account);
        return this;
    }

    // fulfillments
    public SignUpPage assertAccountCreatedSuccessfully(String URL, String ExpectedMessage) {


        ElementHelper.getText(driver, AccountCreatedMessage);
        AssertionHelper.assertUrl(driver, URL);
        AssertionHelper.assertEqual(ElementHelper.getText(driver, AccountCreatedMessage), ExpectedMessage);

        return this;
    }
}

