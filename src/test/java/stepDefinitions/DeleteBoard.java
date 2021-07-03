package stepDefinitions;

import cucumber.api.java.en.*;
import kzapro.pages.DeleteBoardPage;
import kzapro.utilities.TestBase;
import kzapro.utilities.TestUtilities;
import org.junit.Assert;
import org.openqa.selenium.By;


public class DeleteBoard extends TestBase {
    DeleteBoardPage deleteBoardPage;

    @When("Click show menu button")
    public void click_show_menu_button() {
        deleteBoardPage=new DeleteBoardPage();
        deleteBoardPage.clickShowMenuButton();
        TestUtilities.sleep(2);
    }

    @Then("Click open more button")
    public void click_open_more_button() {

        deleteBoardPage.clickOpenMoreButton();
        TestUtilities.sleep(2);
    }

    @When("User click close board button")
    public void user_click_close_board_button() {
        deleteBoardPage.clickCloseBoardButton();
    }

    @Then("Click confirm close button")
    public void click_confirm_close_button() {
        deleteBoardPage.clickConfirmCloseButton();
    }

    @When("User click Permanently delete button")
    public void user_click_Permanently_delete_button() {
        deleteBoardPage.clickPermanentlyDeleteButton();
    }
    @And("Click confirm delete buttons")
    public void Click_confirm_delete_buttons(){
        deleteBoardPage.clickConfirmDeleteButton();
    }

    @Then("Board should be deleted")
    public void board_should_be_deleted() {
        TestUtilities.sleep(5);
        Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Board not found.']")).isDisplayed());
        driver.close();
        driver.quit();
    }
}
