package stepDefinitions;

import cucumber.api.java.en.*;
import cucumber.api.java.en.When;
import kzapro.utilities.TestBase;
import kzapro.pages.UpdateCardPage;
import kzapro.utilities.TestUtilities;
import org.junit.Assert;
import org.openqa.selenium.By;

public class UpdateCard extends TestBase {
    UpdateCardPage updateCardPage;

    @When("User click card")
    public void user_click_card() {
        TestUtilities.sleep(5);
        updateCardPage=new UpdateCardPage();
        updateCardPage.clickCardTab();

    }

    @When("Click move button")
    public void click_move_button() {
        updateCardPage.clickMoveButton();

    }

    @Then("Select In Progress from the list")
    public void Select_In_Progress_from_the_list() {
        updateCardPage.clickSelectListSection();
    }

    @When("User click confirm button")
    public void user_click_confirm_button() {
        TestUtilities.sleep(2);
        updateCardPage.clickConfirmButton();
    }

    @When("Click close button")
    public void click_close_button() {
        TestUtilities.sleep(2);
        updateCardPage.clickCloseButton();
    }

    @Then("New card we updated should be displayed")
    public void new_card_we_updated_should_be_displayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='placeholder']")).isDisplayed());
        TestUtilities.sleep(5);
        driver.close();
        driver.quit();
    }




}
