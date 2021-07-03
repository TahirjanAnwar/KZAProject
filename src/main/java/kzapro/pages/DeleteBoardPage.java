package kzapro.pages;

import kzapro.utilities.TestBase;
import kzapro.utilities.TestUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteBoardPage extends TestBase {
    @FindBy (xpath = "//span[normalize-space()='Show menu']")
    WebElement showMenuButton;
    @FindBy (xpath = "//a[@class='board-menu-navigation-item-link js-open-more']")
    WebElement openMoreButton;
    @FindBy (xpath = "//a[@class='board-menu-navigation-item-link js-close-board']")
    WebElement closeBoardButton;
    @FindBy (xpath = "//input[@value='Close']")
    WebElement confirmCloseButton;
    @FindBy (xpath = "//a[@class='quiet js-delete']")
    WebElement permanentlyDeleteButton;
    @FindBy (xpath = "//input[@value='Delete']")
    WebElement confirmDeleteButton;
    public  DeleteBoardPage(){
        PageFactory.initElements(driver ,this);
    }

    public void clickShowMenuButton(){
        TestUtilities.sleep(2);
        showMenuButton.click();
    }
    public void clickOpenMoreButton(){
        TestUtilities.sleep(2);
        openMoreButton.click();
    }
    public void clickCloseBoardButton(){
        TestUtilities.sleep(2);
        closeBoardButton.click();
    }
    public void clickConfirmCloseButton(){
        TestUtilities.sleep(2);
        confirmCloseButton.click();
    }
    public void clickPermanentlyDeleteButton(){
        TestUtilities.sleep(2);
        permanentlyDeleteButton.click();
    }

    public void clickConfirmDeleteButton(){
        TestUtilities.sleep(2);
        confirmDeleteButton.click();
    }
}
