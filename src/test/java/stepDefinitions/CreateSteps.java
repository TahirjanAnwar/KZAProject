package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kzapro.pages.*;
import kzapro.utilities.TestUtilities;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CreateSteps extends TestBase{


        LoginPage loginPage;
        HomePage homePage;
        CreateBoardPage createBoardPage;
        @Given("I launch chrome browser")
        public void i_launch_chrome_browser() {

            initialization();

        }

    @And("User enters Email")
    public void userEntersEmail() {

        loginPage=new LoginPage();
        loginPage.clickLoginLink();
        loginPage.enterUserName(prop.getProperty("userEmail"));
    }


    @Then("click Log with in atlassian button")
    public void click_Log_with_in_atlassian_button() {

        loginPage.clickLoginWithAtlassianLin();

    }

    @And("User enters Password")
    public void userEntersPassword() {

        loginPage.enterPassword(prop.getProperty("userPassword"));
        loginPage.clickLoginPassword();
    }

    @When("User Clicks Create new board link")
    public void user_Clicks_Create_new_board_link() {

        homePage=new HomePage();
        homePage.clickLink();

    }

    @When("User enters new board name")
    public void user_enters_new_board_name() {

        createBoardPage=new CreateBoardPage();
        createBoardPage.clickButton();
        createBoardPage.addBoardTitle(prop.getProperty("boardName"));

    }

    @When("create board button")
    public void create_board_button() {

        createBoardPage.clickButton();

    }

    @And("click cancel arrow")
    public void clickCancelArrow() {
        createBoardPage.clickCancelButton();
    }

    @Then("add list page should be displayed")
    public void add_list_page_should_be_displayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='KZA Board']")).isDisplayed());
        driver.close();
        driver.quit();
    }



}

