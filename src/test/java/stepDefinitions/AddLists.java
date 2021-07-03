package stepDefinitions;

import cucumber.api.java.en.*;
import kzapro.pages.HomePage;
import kzapro.pages.KZAboardPage;
import kzapro.utilities.TestBase;
import kzapro.utilities.TestUtilities;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AddLists extends TestBase {

    HomePage homePage;
    KZAboardPage kzAboardPage;

    @Given("I click Test KZA board")
    public void i_click_Test_KZA_board() {
        homePage=new HomePage();
        homePage.clickKzaBoard();
        TestUtilities.sleep(2);

    }

    @Given("enter ToDOList title")
    public void enter_ToDOList_title() {

        kzAboardPage=new KZAboardPage();
        kzAboardPage.clickAddListForToDoTextBox(prop.getProperty("toDoListName"));
    }

    @Then("Click ToDoaddlist button")
    public void click_ToDoaddlist_button() {

        kzAboardPage.clickAddListForToDoLink();
    }

    @When("I enter InProgress title")
    public void i_enter_InProgress_title() {

        kzAboardPage.addListForInProgressTextBox(prop.getProperty("inProgressListName"));
    }

    @When("click Progressaddlist button")
    public void click_Progressaddlist_button() {

        kzAboardPage.clickAddListForInProgressLink();

    }

    @When("I enter Done title")
    public void i_enter_Done_title() {
        kzAboardPage.addListForDoneTextBox(prop.getProperty("doneListName"));
        kzAboardPage.clickAddListForDoneLink();

    }

    @When("click cancel button")
    public void click_cancel_button() {

        TestUtilities.sleep(1);
        kzAboardPage.clickCancelButton();
        TestUtilities.sleep(1);

    }

    @Then("new lists should be displayed")
    public void new_lists_should_be_displayed() {

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='placeholder']")).isDisplayed());
        driver.close();
        driver.quit();

    }



}
