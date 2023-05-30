package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.Base;
import utilities.ReadExcelFile;

import java.io.IOException;

public class SignUpPage extends Base {

    private By idField = By.xpath("/html/body/div[2]/div/form/table[1]/tbody/tr[1]/td[2]/input");
    private By passwordField = By.xpath("/html/body/div[2]/div/form/table[1]/tbody/tr[2]/td[2]/input");
    private By repeatPasswordField = By.xpath("/html/body/div[2]/div/form/table[1]/tbody/tr[3]/td[2]/input");
    private By nameField = By.xpath("/html/body/div[2]/div/form/table[2]/tbody/tr[1]/td[2]/input");
    private By lastnameField = By.xpath("/html/body/div[2]/div/form/table[2]/tbody/tr[2]/td[2]/input");
    private By emailField = By.xpath("/html/body/div[2]/div/form/table[2]/tbody/tr[3]/td[2]/input");
    private By phoneField = By.xpath("/html/body/div[2]/div/form/table[2]/tbody/tr[4]/td[2]/input");
    private By addressField = By.xpath("/html/body/div[2]/div/form/table[2]/tbody/tr[5]/td[2]/input");
    private By addressField2 = By.xpath("/html/body/div[2]/div/form/table[2]/tbody/tr[6]/td[2]/input");
    private By cityField = By.xpath("/html/body/div[2]/div/form/table[2]/tbody/tr[7]/td[2]/input");
    private By stateField = By.xpath("/html/body/div[2]/div/form/table[2]/tbody/tr[8]/td[2]/input");
    private By zipField = By.xpath("/html/body/div[2]/div/form/table[2]/tbody/tr[9]/td[2]/input");
    private By countryField = By.xpath("/html/body/div[2]/div/form/table[2]/tbody/tr[10]/td[2]/input");
    private By languajeField = By.xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[1]/td[2]/select");
    private By categoryField = By.xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[2]/td[2]/select");
    private By myListBox = By.xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[3]/td[2]/input");
    private By myBannerBox = By.xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[4]/td[2]/input");
    private By signupButton = By.xpath("/html/body/div[2]/div/form/input");
    private String ruteProject = System.getProperty("user.dir");

    ReadExcelFile readFile = new ReadExcelFile();

    public SignUpPage(WebDriver driver){

        super(driver);

    }

    public void enterId() throws IOException {

        String filepath = ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,4,1);
        type(getData, idField);

    }

    public void enterPassword() throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,4,2);
        clearText(passwordField);
        type(getData, passwordField);

    }

    public void repeatPassword() throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,4,2);
        clearText(repeatPasswordField);
        type(getData, repeatPasswordField);

    }

    public void enterName() throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,4,3);
        clearText(nameField);
        type(getData, nameField);

    }

    public void enterLastName() throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,4,4);
        clearText(lastnameField);
        type(getData, lastnameField);

    }

    public void enterEmail () throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,4,5);
        clearText(emailField);
        type(getData, emailField);

    }

    public void enterPhone () throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        int getData = readFile.getCellNumericValue(filepath,sheetName,4,6);
        clearText(phoneField);
        type(String.valueOf(getData),phoneField);

    }

    public void enterAddress () throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,4,7);
        clearText(addressField);
        type(getData, addressField);

    }

    public void enterAddress2 () throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,4,7);
        clearText(addressField2);
        type(getData, addressField2);

    }

    public void enterCity () throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,4,8);
        clearText(cityField);
        type(getData, cityField);

    }

    public void enterState () throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,4,9);
        clearText(stateField);
        type(getData, stateField);

    }

    public void enterZip () throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        int getData = readFile.getCellNumericValue(filepath,sheetName,4,10);
        clearText(zipField);
        type(String.valueOf(getData), zipField);

    }

    public void enterCountry () throws IOException{

        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,4,11);
        clearText(countryField);
        type(getData, countryField);

    }

    public void selectLanguaje() throws IOException{

        Select languajeList = new Select(findElement(languajeField)); languajeList.selectByVisibleText("japanese");

    }

    public void selectCategory() throws IOException{

        Select categoryList = new Select(findElement(categoryField)); categoryList.selectByVisibleText("DOGS");

    }

    public void enableMyList() {

        click(myListBox);

    }

    public void enableMyBanner() {

        click(myBannerBox);

    }

    public void clickSignUpButton(){

       click(signupButton);

    }

}
