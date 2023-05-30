package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Base;
import utilities.ReadExcelFile;

import java.io.IOException;

public class SignInPage extends Base {

    private By usernameField = By.xpath("/html/body/div[2]/div/form/p[2]/input[1]");
    private By passwordField = By.xpath("/html/body/div[2]/div/form/p[2]/input[2]");
    private By signinButton = By.xpath("//*[@id=\"Catalog\"]/form/input");
    private By signupButton = By.linkText("Register Now!");
    private String ruteProject = System.getProperty("user.dir");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    ReadExcelFile readFile = new ReadExcelFile();

    public void enterUsername () throws IOException {

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,2,1);
        type(getData, usernameField);

    }

    public void enterFailUserName () throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,2,3);
        type(getData, usernameField);

    }

    public void enterPassword () throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,2,2);
        clearText(passwordField);
        type(getData, passwordField);

    }

    public  void enterFailPassword() throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,2,3);
        clearText(passwordField);
        type(getData, passwordField);

    }

    public void enterNewPassword() throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,7,2);
        clearText(passwordField);
        type(getData, passwordField);

    }

    public void clickSigninButton() throws InterruptedException{

        click(signinButton);
        Thread.sleep(3000);

    }

    public void clickSignUpButton() throws InterruptedException{

        click(signupButton);
        Thread.sleep(2000);

    }

}
