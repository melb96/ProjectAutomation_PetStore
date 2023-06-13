package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Base;
import utilities.ReadExcelFile;

import java.io.IOException;

public class HomePage extends Base {

    private final By signinButton = By.linkText("Sign In");
    private final By signOutButton = By.linkText("Sign Out");
    private final By searchField = By.xpath("//*[@id=\"SearchContent\"]/form/input[1]");
    private final By searchButton = By.xpath("//*[@id=\"SearchContent\"]/form/input[2]");
    private final By birdImage = By.xpath("//*[@id=\"MainImageContent\"]/map/area[1]");
    private final By catImage = By.xpath("/html/body/div[2]/div[2]/div[2]/div/map/area[5]");
    private final By returnMenuButton = By.linkText("Return to Main Menu");
    private final By cartButton = By.xpath("//*[@id=\"MenuContent\"]/a[1]/img");
    private final By dogButton = By.xpath("//*[@id=\"QuickLinks\"]/a[2]/img");
    private final By myAccount = By.linkText("My Account");
    private final String ruteProject = System.getProperty("user.dir");

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

    public void clickCats() throws InterruptedException{

        click(catImage);
        Thread.sleep((2000));

    }


    public void clickDogButton () throws InterruptedException {

        click(dogButton);
        Thread.sleep(3000);

    }


    public void clickMyAccount () throws InterruptedException{

        click(myAccount);
        Thread.sleep(3000);

    }


}
