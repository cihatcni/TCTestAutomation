package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementService {

    protected WebDriverWait wait;
    protected WebDriver driver;

    public ElementService(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public WebElement getElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean isElementDisplayed(By by) {
        try {
            WebElement element = getElement(by);
            return element.isDisplayed();
        }
        catch (Exception e) {
            return false;
        }
    }

    public void waitUntilElementDisplayedContainsString(By by, String str) {
        wait.until((ExpectedCondition<Boolean>) d -> driver.findElement(by).getText().contains(str));

    }

    public String getElementText(By by) {
        return getElement(by).getText();
    }

    public String getElementAttributeValue(By by, String atb) {
        return getElement(by).getAttribute(atb);
    }

    public String getNonVisibleElementAttributeValue(By by, String atb) {
        return driver.findElement(by).getAttribute(atb);
    }

}
