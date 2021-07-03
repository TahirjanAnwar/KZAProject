package kzapro.pages;

import kzapro.utilities.TestBase;
import kzapro.utilities.TestUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage extends TestBase {

    @FindBy(xpath = "//button[@title='Tahirjan (uyghur1)']")
    WebElement profileButton;
    @FindBy(xpath = "//span[text()='Log out']")
    WebElement logoutButton;

    public LogOutPage() {
        PageFactory.initElements(driver, this);
    }

    public void logOut() {
        profileButton.click();
        TestUtilities.sleep(2);
        logoutButton.click();
    }
}