package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;

import java.io.IOException;

public class EditAccountTest {

    private WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
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

        myAccountPage = new MyAccountPage(driver);

        Thread.sleep(3000);

    }

    @Test
    public void editPasswordAccount() throws IOException, InterruptedException{

        homePage.clickMyAccount();
        myAccountPage.enterNewPassword();
        myAccountPage.enterRepeatNewPassowrd();
        myAccountPage.saveChanges();
        homePage.clickSignOutButton();
        homePage.clickSignInButton();
        signInPage.enterUsername();
        signInPage.enterNewPassword();

        Assert.assertTrue(homePage.getTextLocator(By.cssSelector("#WelcomeContent")).contains("Welcome"));

        Thread.sleep(3000);

    }

    @Test
    public void editDataAccount() throws IOException, InterruptedException{

        homePage.clickMyAccount();
        myAccountPage.enterNewFirstName();
        myAccountPage.enterNewLastName();
        myAccountPage.enterNewEmail();
        myAccountPage.selectNewLanguaje();
        myAccountPage.saveChanges();
        Thread.sleep(3000);
        homePage.clickSignOutButton();
        homePage.clickSignInButton();
        signInPage.enterUsername();
        signInPage.enterPassword();
        signInPage.clickSigninButton();
        homePage.clickMyAccount();

        String actualText = myAccountPage.getTextLocator(By.xpath("/html/body/div[2]/div/form/table[2]/tbody/tr[1]/td[2]/input"));
        String expectedText = "Mateo";

        Assert.assertEquals(expectedText,actualText);

        Thread.sleep(5000);

    }

    @AfterTest
    public void tearDown() throws InterruptedException{

        Thread.sleep(2000);
        driver.quit();

    }

}
