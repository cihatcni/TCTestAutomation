package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PasajHomePage;
import pages.SearchPage;


public class TcTest extends TestBase {


    @Test
    public void searchTest() {

        final String searchText = "Samsung Galaxy S20";

        HomePage home = new HomePage(driver);
        home.clickSearchButton();
        home.clickAndSetTextToSearch(searchText);
        SearchPage searchPage = home.clickSearchButtonInBar();

        searchPage.clickDevices();
        String deviceName = searchPage.getFirstDeviceName();
        log.info("The name of the device found is " + deviceName);
        searchPage.checkFirstDeviceName(searchText);

    }

    @Test
    public void OpenPasajAndCheckBasket() {

        HomePage homePage = new HomePage(driver);
        PasajHomePage pasajHomePage = homePage.clickPasaj();
        pasajHomePage.clickBasket();
        Assert.assertTrue(pasajHomePage.isBasketEmpty());

    }

    @Test
    public void OpenPasajAndCheckInstallments() {

        final String computerName = "Apple MacBook Pro Touch Bar";

        HomePage homePage = new HomePage(driver);
        PasajHomePage pasajHomePage =homePage.clickPasaj();
        pasajHomePage.moveAndClickMacbookHeader();
        pasajHomePage.clickComputerNameContainsText(computerName);

        float result = pasajHomePage.getInstallmentValue();
        log.info("Price : " + result);

        Assert.assertTrue(result > 10000);

    }



}