package stepDefinitions;

import cucumber.api.java.en.*;
import kzapro.pages.HomePage;
import kzapro.pages.KZAboardPage;
import kzapro.utilities.TestBase;
import kzapro.utilities.TestUtilities;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AddCardToTheList extends TestBase {

    HomePage homePage;
    KZAboardPage kzAboardPage;

    @Given("User click KZA board")
    public void user_click_KZA_board() {

        homePage=new HomePage();
        homePage.clickKzaBoard();
        TestUtilities.sleep(2);

    }


    @When("User enter card name")
    public void user_enter_card_name() {

        kzAboardPage=new KZAboardPage();
        kzAboardPage.clickAddCart(prop.getProperty("cardName"));

    }

    @Given("Click add cart button")
    public void click_add_cart_button() {

        kzAboardPage.clickAddCartButton();

    }

    @When("Click cancel button for add another card")
    public void click_cancel_button_for_add_another_card() {

        TestUtilities.sleep(2);
        kzAboardPage.clickCancelButtonForAddCart();

    }

    @Then("New card we added should be displayed")
    public void new_card_we_added_should_be_displayed() {

        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Add another card']")).isDisplayed());
        driver.close();
        driver.quit();

    }

}
