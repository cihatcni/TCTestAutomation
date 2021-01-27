package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations extends ElementService {


    public Validations(WebDriver driver) {
        super(driver);
    }

    public void verifyElementTextEqualsText(By by, String text) {
        String elementText = getElementText(by);
        Assert.assertEquals(elementText, text);
    }


}
