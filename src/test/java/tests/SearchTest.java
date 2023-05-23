package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import java.io.IOException;

public class SearchTest {

    private WebDriver driver;
    HomePage homePage;

    @Before
    public void setUp() throws InterruptedException {

        homePage = new HomePage(driver);
        driver = homePage.chromeDriverConnection();
        homePage.visit();
        homePage.maximize();
        Thread.sleep(3000);

    }

    @Test
    public void testValidSearch() throws IOException, InterruptedException{

        homePage.typeSearchField();
        Assert.assertEquals(homePage.getTextLocator(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[3]")),"Chihuahua");

    }

    @Test
    public void testInvalidSearch() throws IOException, InterruptedException{

        homePage.typeInvalidSearch();
        boolean isElementFound = homePage.isDisplayed(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[3]"));
        Assert.assertFalse("Element is not found", isElementFound);

    }

    @After
    public void tearDown() throws InterruptedException{

        homePage.returnMenu();
        driver.quit();

    }

}