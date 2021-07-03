package kzapro.utilities;

import kzapro.pages.TestBase;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtilities extends TestBase {

    public static long PAGE_LOAD_TIMEOUT=20;
    public static long IMPLICIT_WAIT =10;




    public static void waitForElement(WebDriver driver, WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
