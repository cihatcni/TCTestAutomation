package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    By searchButton = By.xpath("/html/body/header/div[2]/div/div[2]/div[2]/div/a[1]");
    By searchText = By.xpath("//*[@id=\"header-search\"]/div[1]/div/div/form/div/input");
    By searchButtonInBar = By.xpath("//*[@id=\"header-search\"]/div[1]/div/div/form/div/button/i");
    By pasajButton = By.xpath("/html/body/header/div[2]/div/nav/a[1]");

    //Method to click login button
    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void clickAndSetTextToSearch(String text) {
        driver.findElement(searchText).click();
        driver.findElement(searchText).sendKeys(text);
    }

    public void clickSearchButtonInBar() {
        driver.findElement(searchButtonInBar).click();
    }

    public void clickPasaj() {
        driver.findElement(pasajButton).click();
    }
    
}