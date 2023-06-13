package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.Base;
import utilities.ReadExcelFile;

import java.io.IOException;

public class MyAccountPage extends Base {

    private final By newPassowrd = By.xpath("/html/body/div[2]/div/form/table[1]/tbody/tr[2]/td[2]/input");
    private final By repeatNewPassowrd = By.xpath("//*[@id=\"Catalog\"]/form/table[1]/tbody/tr[3]/td[2]/input");
    private final By firstNameField = By.xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[1]/td[2]/input");
    private final By lastNameField = By.xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[2]/td[2]/input");
    private final By emailField = By.xpath("/html/body/div[2]/div/form/table[2]/tbody/tr[3]/td[2]/input");
    private final By languajeListField = By.xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[1]/td[2]/select");
    private final By saveButton = By.xpath("//*[@id=\"Catalog\"]/form/input");
    private final String ruteProject = System.getProperty("user.dir");

    ReadExcelFile readFile = new ReadExcelFile();

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void enterNewPassword() throws IOException {

        clearText(newPassowrd);
        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,7,2);
        type(getData, newPassowrd);


    }

    public void enterRepeatNewPassowrd () throws IOException{

        clearText(repeatNewPassowrd);
        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,7,2);
        type(getData, repeatNewPassowrd);

    }

    public void enterNewFirstName() throws IOException{

        clearText(firstNameField);
        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,7,3);
        type(getData, firstNameField);

    }

    public void enterNewLastName() throws IOException{

        clearText(lastNameField);
        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,7,4);
        type(getData, lastNameField);

    }

    public void enterNewEmail () throws IOException{

        clearText(emailField);
        String filepath =  ruteProject+getProperties("ruteExcel");
        String sheetName = getProperties("nameSheet");
        String getData = readFile.getCellValue(filepath,sheetName,7,5);
        type(getData, emailField);

    }

    public void selectNewLanguaje() {

        Select languajeList = new Select(findElement(languajeListField)); languajeList.selectByVisibleText("english");

    }

    public void saveChanges(){

        click(saveButton);

    }

}
