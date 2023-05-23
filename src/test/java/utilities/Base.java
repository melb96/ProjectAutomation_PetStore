package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.ss.usermodel.CellType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Base {

    private WebDriver driver;
    private Properties prop;
    private String ruteProject = System.getProperty("user.dir");

    public Base(WebDriver driver) {
        this.driver = driver;
        loadProperties();
    }

    private void loadProperties(){

        prop = new Properties();

        try {
            InputStream input = new FileInputStream(ruteProject + "\\src\\test\\resources\\Setup.properties");
            {
                prop.load(input);
            }
        }catch (IOException e){
            System.out.println("No fue posible llamar archivo properties.");
            e.printStackTrace();
        }


    }

    public String getProperties(String key){

        return prop.getProperty(key);

    }

    public WebDriver chromeDriverConnection() {

        String browserProperty = getProperties("browserProperty");
        String ruteDriver = getProperties("ruteDriver");
        String ruteDriverComplete = ruteProject + ruteDriver;
        System.setProperty(browserProperty, ruteDriverComplete);
        driver = new ChromeDriver();

        return driver;

    }

    //Wrapping

    public WebElement findElement (By locator){

        return driver.findElement(locator);

    }

    public List<WebElement> findElements (By locator){

        return driver.findElements(locator);

    }

    public String getTextElement(WebElement element){

        return element.getText();

    }

    public String getTextLocator(By locator){

        return driver.findElement(locator).getText();

    }

    public void type(String inputText, By locator){

        driver.findElement(locator).sendKeys(inputText);

    }

    public void click (By locator){

        driver.findElement(locator).click();

    }

    public boolean isDisplayed (By locator) {

        try{
            WebElement element = findElement(locator);
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }

    }

    public void visit (){

        driver.get(getProperties("url"));

    }

    public void maximize () {

        driver.manage().window().maximize();

    }

    public void clearText (By locator) {

        driver.findElement(locator).clear();

    }


}
