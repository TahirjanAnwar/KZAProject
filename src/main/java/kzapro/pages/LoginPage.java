package kzapro.pages;

import kzapro.utilities.TestUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{

    TestUtilities testUtilities;

    @FindBy(linkText = "Log in")
    WebElement loginLink;
    @FindBy(id = "user")
    WebElement userNameTextBox;
    @FindBy(id = "login")
    WebElement loginWithAtlassianLink;
    @FindBy(name = "password")
    WebElement passwordTextBox;
    @FindBy(xpath = "//span[text()='Log in']")
    WebElement loginPasswordLink;


    public LoginPage() {
        PageFactory.initElements(driver,this);
    }


    public void clickLoginLink()
    {
        loginLink.click();
    }

    public void enterUserName(String userName)
    {
        userNameTextBox.sendKeys(userName);
    }

    public void clickLoginWithAtlassianLin()
    {
        loginWithAtlassianLink.click();
        testUtilities.sleep(2);
    }

    public void enterPassword(String password)
    {
        passwordTextBox.sendKeys(password);
    }

    public void clickLoginPassword()
    {
        loginPasswordLink.click();
    }






}
