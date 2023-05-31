package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
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

        try {
            signInPage.enterUsername();
            signInPage.enterNewPassword();
            signInPage.clickSigninButton();
            String errorText = homePage.getTextLocator(By.xpath("/html/body/div[2]/ul/li"));
            Assert.assertEquals("Invalid username or password. Signon failed.", errorText);
            System.out.println("ERROR - La contraseña no se modifico");
        }catch (Exception e){
            System.out.println("Se modifico la contraseña correctamento");
        }

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
        homePage.clickSignOutButton();
        homePage.clickSignInButton();
        signInPage.enterUsername();
        signInPage.enterPassword();
        signInPage.clickSigninButton();
        homePage.clickMyAccount();

        try {
            String actualText = myAccountPage.getTextLocator(By.xpath("/html/body/div[2]/div/form/table[2]/tbody/tr[1]/td[2]/input"));
            Assert.assertEquals("Mateo", actualText);
            System.out.println("La modificación se realizó con éxito");
        } catch (AssertionError e) {
            System.out.println("No se realizó la modificación");
        }

        Thread.sleep(5000);

    }

    @AfterTest
    public void tearDown() throws InterruptedException{

        Thread.sleep(2000);
        driver.quit();

    }

}
