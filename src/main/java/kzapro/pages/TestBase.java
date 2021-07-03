package kzapro.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import kzapro.utilities.TestUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        prop=new Properties();
        try {
            FileInputStream ip=new FileInputStream("C:\\Users\\Game PC-Maintake\\IdeaProjects\\KZAProject\\config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void initialization(){
        String browserName=prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("IE"))
        {
            WebDriverManager.iedriver().setup();
            driver=new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtilities.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }


}
