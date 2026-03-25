package mobile_tests;

import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.ErrorScreen;
import screens.LoginRegistrationScreen;
import screens.SplashScreen;

import static utils.UserFactory.positiveUser;

public class RegistrationTests extends TestBase {
    LoginRegistrationScreen loginRegistrationScreen;
    ContactListScreen contactListScreen;
    User user;

    @BeforeMethod
    public void getLoginRegistrationScreen() {
        new SplashScreen(driver);
        loginRegistrationScreen = new LoginRegistrationScreen(driver);

    }

    @Test
    public void RegistrationPositiveTest() {
        loginRegistrationScreen.typeForm(positiveUser());
        loginRegistrationScreen.clickBtnRegistration();
        Assert.assertTrue(new ContactListScreen(driver)
                .isNoContactTextPresent("No Contacts. Add One more!", 5));
    }

    @Test
    public void RegistrationNegativeTest_WrongEmailFormat() {
        user = positiveUser();
        user.setUsername("");
        loginRegistrationScreen.typeForm(user);
        loginRegistrationScreen.clickBtnRegistration();
        Assert.assertTrue(new ErrorScreen(driver).validateErrorText("{username=must not be blank}", 5));

    }
    @Test
    public void RegistrationNegativeTest_WrongPasswordFormat_NumberOfSymbols() {
        user = positiveUser();
        user.setPassword("sdxcv");
        loginRegistrationScreen.typeForm(user);
        loginRegistrationScreen.clickBtnRegistration();
        Assert.assertTrue(new ErrorScreen(driver).validateErrorText("{password= At least 8 characters; Must contain at least 1 uppercase letter, " +
                "1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]}", 5));
    }
    @Test
    public void RegistrationNegativeTest_WrongPasswordFormat_WOSpecialSymbol() {
        user = positiveUser();
        user.setPassword("QWEasd123");
        loginRegistrationScreen.typeForm(user);
        loginRegistrationScreen.clickBtnRegistration();
        Assert.assertTrue(new ErrorScreen(driver).validateErrorText("{password= Should contain special characters [@$#^&*!]}", 5));
    }

    @Test
    public void registrationNegativeTest_UserAlreadyExists() {
        user = positiveUser();
        loginRegistrationScreen.typeForm(user);
        loginRegistrationScreen.clickBtnRegistration();
        contactListScreen = new ContactListScreen(driver);
        contactListScreen.clickMoreOptions();
        contactListScreen.clickBtnLogout();
        loginRegistrationScreen.isBtnRegistrationPresent("REGISTRATION", 5); //used like pause
        loginRegistrationScreen.typeForm(user);
        loginRegistrationScreen.clickBtnRegistration();
        Assert.assertTrue(new ErrorScreen(driver).validateErrorText("User already exists", 5));

    }

}
