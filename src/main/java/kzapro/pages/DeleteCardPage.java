package kzapro.pages;

import kzapro.utilities.TestBase;
import kzapro.utilities.TestUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCardPage extends TestBase {

    @FindBy(xpath = "//span[@class='list-card-title js-card-name']")
    WebElement cardTab;
    @FindBy (xpath = "//span[@title='Archive']")
    WebElement archiveButton;

    @FindBy (xpath = "//span[normalize-space()='Delete']")
    WebElement  deleteButton;

    @FindBy (xpath = "//input[@value='Delete']")
    WebElement confirmDelete;

   public DeleteCardPage() {
       PageFactory.initElements(driver,this);
   }

   public void clickCardTab(){
       TestUtilities.sleep(3);
       cardTab.click();
   }

   public void clickArchiveButton(){
       TestUtilities.sleep(3);
       archiveButton.click();
   }

   public void clickDeleteCardPage(){
       TestUtilities.sleep(3);
       deleteButton.click();
   }
   public void clickConfirmDelete(){
       TestUtilities.sleep(4);
       confirmDelete.click();
   }

}
