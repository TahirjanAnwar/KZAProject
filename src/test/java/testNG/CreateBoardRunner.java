package testNG;

import kzapro.pages.*;
import kzapro.utilities.TestUtilities;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateBoardRunner extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    CreateBoardPage createBoardPage;
    KZAboardPage kzAboardPage;
    UpdateCardPage updateCardPage;
    DeleteCardPage deleteCardPage;
    DeleteBoardPage deleteBoardPage;


    @BeforeMethod
    public void setUp()
    {
        initialization();
        loginPage=new LoginPage();
        loginPage.clickLoginLink();
        loginPage.enterUserName(prop.getProperty("userEmail"));
        loginPage.clickLoginWithAtlassianLin();
        loginPage.enterPassword(prop.getProperty("userPassword"));
        loginPage.clickLoginPassword();

    }

    @Test(priority = 1)
    public void createBoard()
    {
        homePage=new HomePage();
        createBoardPage=homePage.clickLink();
        createBoardPage=new CreateBoardPage();
        createBoardPage.addBoardTitle(prop.getProperty("boardName"));
        createBoardPage.clickButton();
        TestUtilities.sleep(3);
        createBoardPage.clickCancelButton();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='KZA Board']")).isDisplayed());
    }

    @Test(priority = 2)
    public void addList()
    {
        homePage=new HomePage();
        kzAboardPage=homePage.clickKzaBoard();
        TestUtilities.sleep(5);
        kzAboardPage=new KZAboardPage();
        kzAboardPage.clickAddListForToDoTextBox(prop.getProperty("toDoListName"));
        kzAboardPage.clickAddListForToDoLink();
        TestUtilities.sleep(3);
        kzAboardPage.addListForInProgressTextBox(prop.getProperty("inProgressListName"));
        kzAboardPage.clickAddListForInProgressLink();
        TestUtilities.sleep(3);
        kzAboardPage.addListForDoneTextBox(prop.getProperty("doneListName"));
        kzAboardPage.clickAddListForDoneLink();
        TestUtilities.sleep(3);
        kzAboardPage.clickCancelButton();
        TestUtilities.sleep(3);
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='placeholder']")).isDisplayed());
    }

    @Test(priority = 3)
    public void addCartToList()
    {

        homePage=new HomePage();
        homePage.clickKzaBoard();
        TestUtilities.sleep(5);
        kzAboardPage=new KZAboardPage();
        kzAboardPage.clickAddCart(prop.getProperty("cardName"));
        kzAboardPage.clickAddCartButton();
        kzAboardPage.clickCancelButtonForAddCart();
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Add another card']")).isDisplayed());

    }
    @Test(priority = 4)
    public void updateCard()
    {
        homePage=new HomePage();
        homePage.clickKzaBoard();
        TestUtilities.sleep(5);
        updateCardPage=new UpdateCardPage();
        updateCardPage.clickCardTab();
        TestUtilities.sleep(5);
        updateCardPage.clickMoveButton();
        updateCardPage.clickSelectListSection();
        updateCardPage.clickConfirmButton();
        updateCardPage.clickCloseButton();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='placeholder']")).isDisplayed());


    }

    @Test(priority = 5)
    public void deleteCard()
    {
        homePage=new HomePage();
        homePage.clickKzaBoard();
        TestUtilities.sleep(5);
        deleteCardPage=new DeleteCardPage();
        deleteCardPage.clickCardTab();
        TestUtilities.sleep(2);
        deleteCardPage.clickArchiveButton();
        TestUtilities.sleep(2);
        deleteCardPage.clickDeleteCardPage();
        deleteCardPage.clickConfirmDelete();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='placeholder']")).isDisplayed());

    }

    @Test (priority = 6)
    public void deleteBoard()
    {
        homePage=new HomePage();
        homePage.clickKzaBoard();
        TestUtilities.sleep(5);
        deleteBoardPage=new DeleteBoardPage();
        deleteBoardPage.clickShowMenuButton();
        TestUtilities.sleep(5);
        deleteBoardPage.clickOpenMoreButton();
        TestUtilities.sleep(2);
        deleteBoardPage.clickCloseBoardButton();
        deleteBoardPage.clickConfirmCloseButton();
        deleteBoardPage.clickPermanentlyDeleteButton();
        deleteBoardPage.clickConfirmDeleteButton();
        TestUtilities.sleep(5);
        Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Board not found.']")).isDisplayed());

    }


    @Test(enabled = false)
    public void test()
    {
        homePage=new HomePage();
        createBoardPage=homePage.clickLink();
        createBoardPage=new CreateBoardPage();
        createBoardPage.addBoardTitle(prop.getProperty("boardName"));
        createBoardPage.clickButton();
        kzAboardPage=new KZAboardPage();
        kzAboardPage.clickAddListForToDoTextBox(prop.getProperty("toDoListName"));
        kzAboardPage.clickAddListForToDoLink();
        TestUtilities.sleep(3);
        kzAboardPage.addListForInProgressTextBox(prop.getProperty("inProgressListName"));
        kzAboardPage.clickAddListForInProgressLink();
        TestUtilities.sleep(3);
        kzAboardPage.addListForDoneTextBox(prop.getProperty("doneListName"));
        kzAboardPage.clickAddListForDoneLink();
        kzAboardPage.clickCancelButton();
        TestUtilities.sleep(3);
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='placeholder']")).isDisplayed());

    }




    @AfterMethod
    public void tearDown()
    {
        driver.close();
        driver.quit();
    }






}