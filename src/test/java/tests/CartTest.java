package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;

import java.io.IOException;

public class CartTest {

    private WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    CatalogPage catalogPage;
    CartPage cartPage;
    MyAccountPage myAccountPage;

    @BeforeTest
    public void setUp() throws IOException, InterruptedException {

        signInPage = new SignInPage(driver);
        driver = signInPage.chromeDriverConnection();
        signInPage.visit();
        signInPage.maximize();
        Thread.sleep(3000);

        homePage = new HomePage(driver);

        homePage.clickSignInButton();
        signInPage.enterUsername();
        signInPage.enterPassword();
        signInPage.clickSigninButton();

        Thread.sleep(3000);

        catalogPage = new CatalogPage(driver);
        cartPage = new CartPage(driver);
        myAccountPage = new MyAccountPage(driver);


    }

    @Test

    public void testCart() throws InterruptedException{

        homePage.clickCart();
        homePage.returnMenu();
        homePage.clickBirds();
        catalogPage.clickBirdExample();
        catalogPage.clickItemId();
        catalogPage.clickAddToCart();
        cartPage.enterQuantity();
        cartPage.clickUpdateButton();
        cartPage.clickCheckoutButton();
        cartPage.selectCard();
        cartPage.enableBoxAddress();
        cartPage.clickContinueButton();
        cartPage.clickContinue2Button();
        cartPage.clickConfirmButton();

        Assert.assertTrue(cartPage.getTextLocator(By.xpath("//*[@id=\"Content\"]/ul/li")).contains("Thank you"));

        homePage.returnMenu();

        Thread.sleep(3000);

    }

    @Test
    public void enterZeroQuantity () throws InterruptedException{

        homePage.clickBirds();
        catalogPage.clickBirdExample();
        catalogPage.clickAddToCart();
        cartPage.enterZeroQuantityField();
        cartPage.clickUpdateButton();
        Assert.assertEquals(cartPage.getTextLocator(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td")),"Your cart is empty.");
        Thread.sleep(3000);
        homePage.returnMenu();

    }

    @Test
    public void removeElements () throws InterruptedException{

        homePage.clickBirds();
        catalogPage.clickBirdExample();
        catalogPage.clickAddToCart();
        homePage.returnMenu();
        homePage.clickDogButton();
        catalogPage.clickDogExample();
        catalogPage.clickAddToCart();

        String totalPartial = cartPage.getTextLocator(By.xpath("/html/body/div[2]/div[2]/div[1]/form/table/tbody/tr[3]/td[1]"));

        cartPage.clickRemoveButton();

        String newTotal = cartPage.getTextLocator(By.xpath("/html/body/div[2]/div[2]/div[1]/form/table/tbody/tr[3]/td[1]"));

        Assert.assertNotEquals(newTotal,totalPartial);
    }

    @Test
    public void checkOrders () throws InterruptedException{

        homePage.clickMyAccount();
        myAccountPage.clickMyOrdersButton();

        String orderNumber = cartPage.getTextLocator(By.xpath("/html/body/div[2]/table/tbody/tr[12]/td[1]/a"));

        myAccountPage.clickOrder();

        String dataOrder = cartPage.getTextLocator(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[1]/th"));

        Assert.assertTrue(dataOrder.contains(orderNumber));

        Thread.sleep(2000);

        homePage.returnMenu();

    }

    @AfterTest

    public void tearDown () throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }

}
