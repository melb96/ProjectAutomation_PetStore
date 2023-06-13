package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Base;

public class CatalogPage extends Base {

    private final By birdExample = By.linkText("AV-CB-01");
    private final By dogExample = By.linkText("K9-RT-01");
    private final By catExample = By.linkText("FL-DLH-02");
    private final By itemID = By.linkText("EST-17");
    private final By addToCart = By.linkText("Add to Cart");

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public void clickBirdExample () throws InterruptedException {

        click(birdExample);
        Thread.sleep(3000);

    }

    public void clickCatExample () throws InterruptedException {

        click(catExample);
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


}
