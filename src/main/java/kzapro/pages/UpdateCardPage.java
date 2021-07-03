package kzapro.pages;

import kzapro.utilities.TestUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UpdateCardPage extends TestBase{

    @FindBy(xpath = "//span[@class='list-card-title js-card-name']")
    WebElement cardTab;
    @FindBy(xpath = "//span[normalize-space()='Move']")
    WebElement moveButton;
    @FindBy (xpath = "//select[@class='js-select-list']")
    WebElement selectListSection;
    @FindBy(xpath = "//input[@value='Move']")
    WebElement confirmMoveButton;
    @FindBy(xpath = "//a[@class='icon-md icon-close dialog-close-button js-close-window']")
    WebElement closeButton;

    public UpdateCardPage(){
        PageFactory.initElements(driver,this);
    }
    public void clickCardTab(){
        TestUtilities.waitForElement(driver,cardTab);
        cardTab.click();
    }

    public void clickMoveButton(){
        TestUtilities.sleep(2);
        moveButton.click();}

    public void clickSelectListSection(){
        TestUtilities.sleep(3);
        selectListSection.click();
        Select sel = new Select(selectListSection);
        sel.selectByVisibleText("In Progress");
    }
    public void clickConfirmButton(){
        TestUtilities.sleep(1);
        confirmMoveButton.click();}

    public void clickCloseButton(){
        TestUtilities.sleep(1);
        closeButton.click();}

}
