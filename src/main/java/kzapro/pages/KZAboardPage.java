package kzapro.pages;

import kzapro.utilities.TestUtilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KZAboardPage extends TestBase {

    @FindBy(css = "span.icon-sm.icon-add")
    WebElement addListForToDoTextBox;

    @FindBy(css = "input.list-name-input")
    WebElement listForInputTextBox;

    @FindBy(xpath = "//input[@value='Add list']")
    WebElement addListForToDoLink;
    @FindBy(xpath = "//input[@name='name']")
    WebElement addListForInProgressTextBox;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement addListForInProgressLink;
    @FindBy(xpath = "//input[@class='list-name-input']")
    WebElement addListForDoneTextBox;
    @FindBy(xpath = "//input[@value='Add list']")
    WebElement addListForDoneLink;
    @FindBy(xpath = "//a[@aria-label='Cancel list editing']")
    WebElement cancelListButton;
    @FindBy(xpath = "//span[@class='icon-sm icon-add']")
    WebElement addCartLink;
    @FindBy(xpath = "//textarea[@placeholder='Enter a title for this card…']")
    WebElement cardInputTextBox;
    @FindBy(xpath = "//input[@value='Add card']")
    WebElement addCartButton;
    @FindBy(xpath = "//a[@class='icon-lg icon-close dark-hover js-cancel']")
    WebElement cancelAddCartButton;

    public KZAboardPage() {
        PageFactory.initElements(driver, this);
    }


    public void clickAddListForToDoTextBox(String linkName) {

        //TestUtilities.waitForElement(driver, addListForToDoTextBox);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addListForToDoTextBox);
        TestUtilities.waitForElement(driver, listForInputTextBox);
        listForInputTextBox.sendKeys(linkName);
    }

    public void clickAddListForToDoLink() {
        TestUtilities.waitForElement(driver, addListForToDoLink);
        addListForToDoLink.click();
    }

    public void addListForInProgressTextBox(String linkName) {
        addListForInProgressTextBox.sendKeys(linkName);
    }

    public void clickAddListForInProgressLink() {
        addListForInProgressLink.click();
    }

    public void addListForDoneTextBox(String linkName) {
        addListForDoneTextBox.sendKeys(linkName);
    }

    public void clickAddListForDoneLink() {
        addListForDoneLink.click();
    }

    public void clickCancelButton() {
        cancelListButton.click();
    }

    public void clickAddCart(String cardName) {
        TestUtilities.waitForElement(driver,addListForToDoTextBox);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addCartLink);
        TestUtilities.waitForElement(driver, cardInputTextBox);
        cardInputTextBox.sendKeys(cardName);
    }

    public void clickAddCartButton() {
        TestUtilities.waitForElement(driver, addCartButton);
        addCartButton.click();

    }


    public void clickCancelButtonForAddCart() {
        TestUtilities.sleep(1);
        cancelAddCartButton.click();

    }
}
