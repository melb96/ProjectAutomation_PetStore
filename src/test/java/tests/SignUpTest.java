package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;
import pages.SignInPage;

import java.io.IOException;

public class SignUpTest{

    private WebDriver driver;
    HomePage homePage;
    SignUpPage signUpPage;
    SignInPage signInPage;

    @BeforeTest
    public void setUp() throws InterruptedException {

        signUpPage = new SignUpPage(driver);
        driver = signUpPage.chromeDriverConnection();
        signUpPage.visit();
        signUpPage.maximize();
        Thread.sleep(3000);

        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);

    }

    @Test
    public void repeatTestSignUp () throws IOException, InterruptedException {

        homePage.clickSignInButton();
        signInPage.clickSignUpButton();

        signUpPage.enterId();
        signUpPage.enterPassword();
        signUpPage.repeatPassword();
        signUpPage.enterName();
        signUpPage.enterLastName();
        signUpPage.enterEmail();
        signUpPage.enterPhone();
        signUpPage.enterAddress();
        signUpPage.enterCity();
        signUpPage.enterState();
        signUpPage.enterZip();
        signUpPage.enterCountry();
        signUpPage.selectLanguaje();
        signUpPage.selectCategory();
        signUpPage.enableMyList();
        signUpPage.enableMyBanner();

        signUpPage.clickSignUpButton();

        Assert.assertTrue(homePage.getTextLocator(By.xpath("/html/body/h1")).contains("HTTP Status 500 – Internal Server Error"));

        Thread.sleep(3000);

    }

    @Test
    public void testSignUp() throws IOException, InterruptedException{

        homePage.clickSignInButton();
        signInPage.clickSignUpButton();

        signUpPage.enterId();
        signUpPage.enterPassword();
        signUpPage.repeatPassword();
        signUpPage.enterName();
        signUpPage.enterLastName();
        signUpPage.enterEmail();
        signUpPage.enterPhone();
        signUpPage.enterAddress();
        signUpPage.enterAddress2();
        signUpPage.enterCity();
        signUpPage.enterState();
        signUpPage.enterZip();
        signUpPage.enterCountry();
        signUpPage.selectLanguaje();
        signUpPage.selectCategory();
        signUpPage.enableMyList();
        signUpPage.enableMyBanner();
        signUpPage.clickSignUpButton();
        homePage.clickSignInButton();
        signInPage.enterUsername();
        signInPage.enterPassword();
        signInPage.clickSigninButton();

        Assert.assertTrue(homePage.getTextLocator(By.cssSelector("#WelcomeContent")).contains("Welcome"));

        Thread.sleep(3000);

    }

    @AfterTest
    public void tearDown() throws InterruptedException{

      Thread.sleep(5000);
      driver.quit();

    }


}