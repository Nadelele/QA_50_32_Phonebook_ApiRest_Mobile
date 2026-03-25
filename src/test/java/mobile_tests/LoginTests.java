package mobile_tests;


import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.LoginRegistrationScreen;
import screens.SplashScreen;
import static utils.PropertiesReader.*;

public class LoginTests extends TestBase{
    LoginRegistrationScreen loginRegistrationScreen;

    @BeforeMethod
    public void getLoginRegistrationScreen() {
        new SplashScreen(driver);
        loginRegistrationScreen = new LoginRegistrationScreen(driver);

    }
    @Test
    public void LoginPositiveTest() {
        loginRegistrationScreen.typeForm(new User(getProperty("base.properties", "login"),
                getProperty("base.properties", "password")));
        loginRegistrationScreen.clickBtnLogin();
        Assert.assertTrue(new ContactListScreen(driver).isMoreOptionsVisible());
    }

}
