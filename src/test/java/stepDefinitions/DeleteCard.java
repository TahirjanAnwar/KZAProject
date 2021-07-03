package stepDefinitions;

import cucumber.api.java.en.*;
import kzapro.pages.DeleteCardPage;
import kzapro.pages.TestBase;
import kzapro.utilities.TestUtilities;
import org.junit.Assert;
import org.openqa.selenium.By;

public class DeleteCard extends TestBase {
    DeleteCardPage deleteCardPage;
    @Given("Click card")
    public void click_card() {
        deleteCardPage = new DeleteCardPage();
        deleteCardPage.clickCardTab();
    }

    @Given("Click Archive button")
    public void click_Archive_button() {
        deleteCardPage.clickArchiveButton();

    }

    @When("User click delete button")
    public void user_click_delete_button() {
        deleteCardPage.clickDeleteCardPage();

    }

    @When("Click confirm delete button")
    public void click_confirm_delete_button() {
        deleteCardPage.clickConfirmDelete();

    }

    @Then("Card should be deleted")
    public void card_should_be_deleted() {
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='placeholder']")).isDisplayed());
        TestUtilities.sleep(5);
        driver.close();
        driver.quit();
    }
}
