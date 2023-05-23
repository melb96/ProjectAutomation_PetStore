package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Base;
import utilities.ReadExcelFile;

import java.io.IOException;

public class HomePage extends Base {

    private By signinButton = By.linkText("Sign In");
    private By signOutButton = By.linkText("Sign Out");
    private By searchField = By.xpath("//*[@id=\"SearchContent\"]/form/input[1]");
    private By searchButton = By.xpath("//*[@id=\"SearchContent\"]/form/input[2]");
    private By birdImage = By.xpath("//*[@id=\"MainImageContent\"]/map/area[1]");
    private By returnMenuButton = By.linkText("Return to Main Menu");
    private By cartButton = By.xpath("//*[@id=\"MenuContent\"]/a[1]/img");
    private By fishButton = By.xpath("//*[@id=\"QuickLinks\"]/a[1]/img");
    private By dogButton = By.xpath("//*[@id=\"QuickLinks\"]/a[2]/img");
    private By reptileButton = By.xpath("//*[@id=\"QuickLinks\"]/a[3]/img");
    private By catButton = By.xpath("//*[@id=\"QuickLinks\"]/a[4]/img");
    private By birdButton = By.xpath("//*[@id=\"QuickLinks\"]/a[5]/img");
    private By myAccount = By.linkText("My Account");
    private By homeButton = By.xpath("//*[@id=\"LogoContent\"]/a/img");
    private String ruteProject = System.getProperty("user.dir");

    ReadExcelFile readFile = new ReadExcelFile();

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSignInButton() throws InterruptedException {

        click(signinButton);
        Thread.sleep(3000);

    }

    public void clickSignOutButton() throws InterruptedException {

        click(signOutButton);
        Thread.sleep(3000);

    }

    public void typeSearchField() throws IOException, InterruptedException {

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,5,1);
        clearText(searchField);
        type(getData, searchField);
        click(searchButton);
        Thread.sleep(3000);

    }

    public void typeInvalidSearch () throws IOException, InterruptedException {

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,5,2);
        clearText(searchField);
        type(getData, searchField);
        click(searchButton);
        Thread.sleep(3000);

    }

    public void returnMenu() throws InterruptedException {


        click(returnMenuButton);
        Thread.sleep(2000);

    }

    public void clickCart() throws InterruptedException {

        click(cartButton);
        Thread.sleep((2000));

    }

    public void clickBirds() throws InterruptedException{

        click(birdImage);
        Thread.sleep((2000));

    }

    public void clickFishButton () throws InterruptedException {

        click(fishButton);
        Thread.sleep(3000);

    }

    public void clickDogButton () throws InterruptedException {

        click(dogButton);
        Thread.sleep(3000);

    }

    public void clickReptileButton () throws InterruptedException {

        click(reptileButton);
        Thread.sleep(3000);

    }

    public void clickCatButton () throws InterruptedException {

        click(catButton);
        Thread.sleep(3000);

    }

    public void clickBirdButton () throws InterruptedException {

        click(birdButton);
        Thread.sleep(3000);

    }

    public void clickMyAccount () throws InterruptedException{

        click(myAccount);
        Thread.sleep(3000);

    }

    public void clickHomeButton() throws InterruptedException{

        click(homeButton);
        Thread.sleep(3000);

    }

}
