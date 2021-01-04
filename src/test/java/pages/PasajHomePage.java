package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasajHomePage {

    WebDriver driver;

    public PasajHomePage(WebDriver driver) {
        this.driver=driver;
    }

    By basketButton = By.xpath("/html/body/header/div[1]/div[2]/a");
    By emptyBasketLabel = By.xpath("//*[@id=\"basket\"]/div/div/form/div[1]/div/div/h3");
    By macbookHeader = By.xpath("/html/body/footer/div[1]/div/nav/div/div[3]/ul/li[11]/a");
    By macbookLabel = By.xpath("//*[@id=\"all-devices-section\"]/div[26]/a/div[1]/span");
    By installment = By.xpath("//*[@id=\"product-detail\"]/div[1]/div/div/div[2]/form/div[2]/label/div[1]/span[2]/span");
    By sixMonths = By.xpath("//*[@id=\"product-detail\"]/div[1]/div/div/div[2]/form/div[2]/label/div[2]/a[1]");
    By nineMonths = By.xpath("//*[@id=\"product-detail\"]/div[1]/div/div/div[2]/form/div[2]/label/div[2]/a[2]");

    public void clickBasket() {
        driver.findElement(basketButton).click();
    }

    public boolean isBasketEmpty(){
        try {
            driver.findElement(emptyBasketLabel);
        }
        catch (NoSuchElementException exception) {
            return false;
        }
        return true;
    }

    public void moveAndClickMacbookHeader() {
        moveToElement(macbookHeader);
        driver.findElement(macbookHeader).click();
    }

    public void clickMacbook() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until((ExpectedCondition<Boolean>) d -> driver.findElement(macbookLabel).getText().contains("Apple MacBook Pro Touch Bar"));
        moveToElement(macbookLabel);
        driver.findElement(macbookLabel).click();
    }

    public float getInstallmentValue() {
        WebElement element = driver.findElement(installment);
        String text = element.getText();
        text = text.replace(".", "");
        text = text.replace(",", ".");
        return Float.parseFloat(text);
    }

    public float getSixMonthsInstallmentValue() {
        WebElement element = driver.findElement(sixMonths);
        String text = element.getAttribute("data-price");
        text = text.replace(".", "");
        text = text.replace(",", ".");
        return Float.parseFloat(text);
    }

    public float getNineMonthsInstallmentValue() {
        WebElement element = driver.findElement(nineMonths);
        String text = element.getAttribute("data-price");
        text = text.replace(".", "");
        text = text.replace(",", ".");
        return Float.parseFloat(text);
    }

    private void moveToElement(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

}