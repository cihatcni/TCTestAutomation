package tests;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.PasajHomePage;
import pages.SearchPage;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;


public class TcTest {

    WebDriver driver;
    private static final Logger log  = Logger.getLogger(TcTest.class.getName());

    @BeforeSuite
    public void settings() {
        PropertyConfigurator.configure("src/test/java/resources/log4j.properties");
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void searchTest() {

        driver.get("https://www.turkcell.com.tr/");
        driver.manage().deleteAllCookies();

        HomePage home = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);

        String searchText = "Samsung Galaxy S20";

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

        driver.get("https://www.turkcell.com.tr/");
        driver.manage().deleteAllCookies();

        HomePage homePage = new HomePage(driver);
        PasajHomePage pasajHomePage = new PasajHomePage(driver);

        homePage.clickPasaj();
        pasajHomePage.clickBasket();
        Assert.assertTrue(pasajHomePage.isBasketEmpty());

    }

    @Test
    public void OpenPasajAndCheckInstallments() {

        driver.get("https://www.turkcell.com.tr/");
        driver.manage().deleteAllCookies();

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

    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }

}