package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;

import java.io.IOException;

public class SignOutTest {

    private WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;

    @BeforeTest
    public void setUp() throws IOException, InterruptedException {

        homePage = new HomePage(driver);
        driver = homePage.chromeDriverConnection();
        homePage.visit();
        homePage.maximize();
        Thread.sleep(3000);

        signInPage = new SignInPage(driver);

        homePage.clickSignInButton();
        signInPage.enterUsername();
        signInPage.enterPassword();
        signInPage.clickSigninButton();

        Thread.sleep(3000);

    }

    @Test
    public void testSignOut() throws InterruptedException{

        homePage.clickSignOutButton();
        Assert.assertEquals(homePage.getTextLocator(By.linkText("Sign In")),"Sign In");

    }

    @AfterTest
    public void tearDown(){

        driver.quit();

    }

}
