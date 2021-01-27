package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasajHomePage extends PageBase {

    By basketButton = By.xpath("/html/body/header/div[1]/div[2]/a");
    By emptyBasketLabel = By.xpath("//*[@id=\"basket\"]/div/div/form/div[1]/div/div/h3");
    By macbookHeader = By.xpath("/html/body/footer/div[1]/div/nav/div/div[3]/ul/li[11]/a");
    By macbookLabel = By.xpath("//*[@id=\"all-devices-section\"]/div[40]/a/div[1]/span");
    By installment = By.xpath("//*[@id=\"product-detail\"]/div[1]/div/div/div[2]/form/div[2]/label/div[1]/span[2]/span");
    By sixMonths = By.xpath("//*[@id=\"product-detail\"]/div[1]/div/div/div[2]/form/div[2]/label/div[2]/a[1]");
    By nineMonths = By.xpath("//*[@id=\"product-detail\"]/div[1]/div/div/div[2]/form/div[2]/label/div[2]/a[2]");

    public PasajHomePage(WebDriver driver) {
        init(driver);
    }

    public void clickBasket() {
        actions.clickElement(basketButton);
    }

    public boolean isBasketEmpty(){
        return validations.isElementDisplayed(emptyBasketLabel);
    }

    public void moveAndClickMacbookHeader() {
        actions.moveToElement(macbookHeader);
        actions.clickElement(macbookHeader);
    }

    public void clickComputerNameContainsText(String str) {
        actions.waitUntilElementDisplayedContainsString(macbookLabel, str);
        actions.moveToElement(macbookLabel);
        actions.clickElement(macbookLabel);
    }

    public float getInstallmentValue() {
        String text = actions.getElementText(installment);
        return parsePriceString(text);
    }

    public float getSixMonthsInstallmentValue() {
        String text = actions.getNonVisibleElementAttributeValue(sixMonths, "data-price");
        return parsePriceString(text);
    }

    public float getNineMonthsInstallmentValue() {
        String text = actions.getNonVisibleElementAttributeValue(nineMonths, "data-price");
        return parsePriceString(text);
    }

    private float parsePriceString(String text) {
        text = text.replace(".", "");
        text = text.replace(",", ".");
        return Float.parseFloat(text);
    }



}