package stepDefinitions;

import cucumber.api.java.en.*;
import kzapro.pages.HomePage;
import kzapro.pages.LoginPage;
import kzapro.pages.LogOutPage;
import kzapro.pages.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginNegativeAndPositiveTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    LogOutPage logOutPage;

    @Given("User Launch Chrome Browser with URL")
    public void user_Launch_Chrome_Browser() {

        initialization();
    }

    @When("User Enters Email as {string} and Password as {string}")
    public void user_Enters_Email_as_and_Password_as(String email, String pws) {

        loginPage=new LoginPage();
        loginPage.clickLoginLink();
        loginPage.enterUserName(email);
        loginPage.clickLoginWithAtlassianLin();
        loginPage.enterPassword(pws);

    }
    @When("Click on Login")
    public void click_on_Login() {

        loginPage.clickLoginPassword();

    }

    @Then("HomePage should be displayed")
    public void homepage_should_be_displayed() {

        homePage = new HomePage();
        Assert.assertTrue(homePage.verifyHomePage());


    }

    @When("User Click on Logout link")
    public void user_Click_on_Logout_link() {

        logOutPage = new LogOutPage();
        logOutPage.logOut();

    }

    @Then("Close Browser")
    public void close_Browser() {

        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Trello Logo']")).isDisplayed());
        driver.close();
        driver.quit();

    }

}

