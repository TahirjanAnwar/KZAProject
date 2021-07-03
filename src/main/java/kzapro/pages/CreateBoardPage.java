package kzapro.pages;

import kzapro.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateBoardPage extends TestBase {

    @FindBy(xpath = "//input[@placeholder='Add board title']")
    WebElement addBoardTitleTextBox;
    @FindBy(xpath = "//button[text()='Create board']")
    WebElement createBoardButton;
    @FindBy(xpath = "//a[@class='icon-lg icon-close dark-hover js-cancel-edit']")
    WebElement cancelButton;

    public CreateBoardPage(){
        PageFactory.initElements(driver,this);
    }
    public void addBoardTitle(String title)
    {
        addBoardTitleTextBox.clear();
        addBoardTitleTextBox.sendKeys(title);
    }

    public void clickButton()
    {
        createBoardButton.click();
    }
    public void clickCancelButton()
    {
        cancelButton.click();
    }
}
