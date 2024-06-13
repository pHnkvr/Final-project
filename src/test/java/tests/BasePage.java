package tests;

import driver_init.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.LoginAccount;
import pages.Ordering;
import pages.SearchPage;
import test_rail_integration.TestRailIntegration;

@Listeners(TestRailIntegration.class)
public class BasePage {
    protected WebDriver driver = DriverInit.startDriver();
    protected SearchPage SearchPage = new SearchPage(driver);
    protected LoginAccount LoginAccount = new LoginAccount(driver);
    protected pages.Ordering Ordering = new Ordering(driver);
    @BeforeSuite
    public void init(){
        driver = DriverInit.startDriver();
    }
    @AfterSuite
    public void stop(){
        driver.quit();
    }
}
