package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.SignInPage;

import java.io.IOException;

public class SignInTest{

    private WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;

    @BeforeTest
    public void setUp() throws InterruptedException {

    signInPage = new SignInPage(driver);
    driver = signInPage.chromeDriverConnection();
    signInPage.visit();
    signInPage.maximize();
    Thread.sleep(3000);

    homePage = new HomePage(driver);

    }

    @Test
    public void testSignIn() throws IOException, InterruptedException{

        homePage.clickSignInButton();
        signInPage.enterUsername();
        signInPage.enterPassword();
        signInPage.clickSigninButton();

        Assert.assertTrue(homePage.getTextLocator(By.cssSelector("#WelcomeContent")).contains("Welcome"));

        Thread.sleep(3000);

    }

    @Test
    public void testFailSingIn() throws IOException, InterruptedException{

        homePage.clickSignInButton();
        signInPage.enterFailUserName();
        signInPage.enterFailPassword();
        signInPage.clickSigninButton();

        Assert.assertTrue(signInPage.getTextLocator(By.xpath("//*[@id=\"Content\"]/ul/li")).contains("Signon failed"));

        Thread.sleep(3000);

    }

    @AfterTest

    public void tearDown(){

        driver.quit();

    }


}
