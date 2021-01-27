package base;

import org.openqa.selenium.WebDriver;
import services.ElementActions;
import services.Validations;

public class PageBase {


    protected WebDriver driver;
    protected ElementActions actions;
    protected Validations validations;

    public void init(WebDriver driver) {
        this.driver = driver;
        actions = new ElementActions(driver);
        validations = new Validations(driver);
    }


}
