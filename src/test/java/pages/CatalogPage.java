package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Base;

public class CatalogPage extends Base {

    private By birdExample = By.linkText("AV-CB-01");
    private By dogExample = By.linkText("K9-RT-01");
    private By itemID = By.linkText("EST-18");
    private By addToCart = By.linkText("Add to Cart");
    private By returnCatalogMenu = By.linkText("Return to BIRDS");
    private By returnItemId = By.linkText("Return to AV-CB-01");

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public void clickBirdExample () throws InterruptedException {

        click(birdExample);
        Thread.sleep(3000);

    }

    public void clickDogExample () throws InterruptedException {

        click(dogExample);
        Thread.sleep(3000);

    }

    public void clickItemId () throws  InterruptedException {

        click(itemID);
        Thread.sleep(3000);

    }

    public void clickAddToCart () throws InterruptedException {

        click(addToCart);
        Thread.sleep(3000);

    }

    public void clickReturnMenuCatalog () throws InterruptedException {

        click(returnCatalogMenu);
        Thread.sleep(3000);

    }

    public void clickReturnItemId () throws InterruptedException {

        click(returnItemId);
        Thread.sleep(3000);

    }



}
