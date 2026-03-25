package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ContactListScreen extends BaseScreen {
    public ContactListScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.sheygam.contactapp:id/emptyTxt")
    WebElement noContactsText;
    @AndroidFindBy(xpath = "//*[@content-desc='More options']")
    WebElement btnMoreOptions;
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/title' and @text='Logout']")
    WebElement btnLogOut;

    public boolean isNoContactTextPresent(String text, int time){
        return isTextInElementPresent(noContactsText, text, time);
    }
    public void clickMoreOptions(){
        btnMoreOptions.click();
    }
    public void clickBtnLogout(){
        btnLogOut.click();
    }
}
