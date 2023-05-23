package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.Base;

public class CartPage extends Base {

    private By updateCartButton = By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[3]/td[1]/input");
    private By removeButton = By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[8]/a");
    private By checkoutButton = By.linkText("Proceed to Checkout");
    private By quantityField = By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[5]/input");
    private By cardField = By.xpath("//*[@id=\"Catalog\"]/form/table/tbody/tr[2]/td[2]/select");
    private By boxAddress = By.xpath("//*[@id=\"Catalog\"]/form/table/tbody/tr[14]/td/input");
    private By continueButton = By.xpath("//*[@id=\"Catalog\"]/form/table/tbody/tr[14]/td/input");
    private By continue2Button = By.xpath("//*[@id=\"Catalog\"]/form/input");
    private By confirmButton = By.linkText("Confirm");


    public CartPage(WebDriver driver) {

        super(driver);

    }

    public void clickUpdateButton () throws InterruptedException{

        click(updateCartButton);
        Thread.sleep(2000);

    }

    public void clickRemoveButton () throws InterruptedException {

        click(removeButton);
        Thread.sleep(1000);

    }

    public void clickCheckoutButton () throws InterruptedException {

        click(checkoutButton);
        Thread.sleep(3000);

    }

    public void enterQuantity () throws InterruptedException {

        clearText(quantityField);
        type("3", quantityField);

    }

    public void enterZeroQuantityField () {

        clearText(quantityField);
        type("0", quantityField);

    }

    public void selectCard(){

        Select cardList = new Select(findElement(cardField)); cardList.selectByVisibleText("MasterCard");

    }

    public void enableBoxAddress(){

        click(boxAddress);

    }

    public void clickContinueButton(){

        click(continueButton);

    }

    public void clickContinue2Button() throws InterruptedException{

        click(continue2Button);
        Thread.sleep(2000);

    }

    public void clickConfirmButton() throws  InterruptedException{

        click(confirmButton);
        Thread.sleep(5000);

    }


}
