package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

    By searchButton = By.xpath("/html/body/header/div[2]/div/div[2]/div[2]/div/a[1]");
    By searchText = By.xpath("//*[@id=\"header-search\"]/div[1]/div/div/form/div/input");
    By searchButtonInBar = By.xpath("//*[@id=\"header-search\"]/div[1]/div/div/form/div/button/i");
    By pasajButton = By.xpath("/html/body/header/div[2]/div/nav/a[1]");

    public HomePage(WebDriver driver) {
        init(driver);
    }

    public void clickSearchButton() {
        actions.clickElement(searchButton);
    }

    public void clickAndSetTextToSearch(String text) {
        actions.clickElement(searchText);
        actions.sendTextToElement(searchText,text);
    }

    public SearchPage clickSearchButtonInBar() {
        actions.clickElement(searchButtonInBar);
        return new SearchPage(driver);
    }

    public PasajHomePage clickPasaj() {
        actions.clickElement(pasajButton);
        return new PasajHomePage(driver);
    }

}