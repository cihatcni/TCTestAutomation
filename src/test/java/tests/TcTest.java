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

        HomePage home = new HomePage(driver);

        final String searchText = "Samsung Galaxy S20";

        home.clickSearchButton();
        home.clickAndSetTextToSearch(searchText);
        SearchPage searchPage = home.clickSearchButtonInBar();
        searchPage.clickDevices();
        String deviceName = searchPage.getFirstDeviceName();
        log.info("The name of the device found is " + deviceName);
        Assert.assertEquals(deviceName,searchText);

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

        HomePage homePage = new HomePage(driver);

        PasajHomePage pasajHomePage =homePage.clickPasaj();
        pasajHomePage.moveAndClickMacbookHeader();
        pasajHomePage.clickMacbook();

        float result = pasajHomePage.getInstallmentValue();

        log.info("Price : " + result);

        Assert.assertTrue(result > 10000);

    }



}