package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver=driver;
    }

    By devicesTab = By.xpath("//*[@id=\"search-results\"]/div/div[3]/div[1]/div/div[1]/div/div[2]/a");
    By firstDevice = By.xpath("//*[@id=\"tabDevices\"]/div[1]/a/div[1]/span");

    public void clickDevices() {
        driver.findElement(devicesTab).click();
    }

    public String getFirstDeviceName() {
        return driver.findElement(firstDevice).getText();
    }



}