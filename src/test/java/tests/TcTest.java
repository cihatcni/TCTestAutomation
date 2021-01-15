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
        SearchPage searchPage = new SearchPage(driver);

        final String searchText = "Samsung Galaxy S20";

        home.clickSearchButton();
        home.clickAndSetTextToSearch(searchText);
        home.clickSearchButtonInBar();
        searchPage.clickDevices();
        String deviceName = searchPage.getFirstDeviceName();
        log.info("Founded device name is " + deviceName);
        Assert.assertEquals(deviceName,searchText);

    }

    @Test
    public void OpenPasajAndCheckBasket() {

        HomePage homePage = new HomePage(driver);
        PasajHomePage pasajHomePage = new PasajHomePage(driver);

        homePage.clickPasaj();
        pasajHomePage.clickBasket();
        Assert.assertTrue(pasajHomePage.isBasketEmpty());

    }

    @Test
    public void OpenPasajAndCheckInstallments() {

        HomePage homePage = new HomePage(driver);
        PasajHomePage pasajHomePage = new PasajHomePage(driver);

        homePage.clickPasaj();
        pasajHomePage.moveAndClickMacbookHeader();
        pasajHomePage.clickMacbook();

        float result = pasajHomePage.getInstallmentValue();
        float sixMonths = pasajHomePage.getSixMonthsInstallmentValue();
        float nineMonths = pasajHomePage.getNineMonthsInstallmentValue();

        log.info("TWELVE MONTHS: " + result);
        log.info("NINE MONTHS: " + nineMonths);
        log.info("SIX MONTHS: " + sixMonths);

        Assert.assertTrue(result > 1000);
        Assert.assertTrue(sixMonths > nineMonths);

    }



}