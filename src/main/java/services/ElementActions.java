package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions extends ElementService {

    public ElementActions(WebDriver driver) {
        super(driver);
    }

    public void clickElement(By by) {
        getElement(by).click();
    }

    public void sendTextToElement(By by, String str) {
        getElement(by).sendKeys(str);
    }

    public void moveToElement(By by) {
        WebElement element = getElement(by);
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

}
