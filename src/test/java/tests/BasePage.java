package tests;

import driver_init.DriverInit;
import functions.CustomWaiters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import pages.LoginAccount;
import pages.Ordering;
import pages.SearchPage;

public class BasePage {
    protected WebDriver driver = DriverInit.startDriver();
    protected CustomWaiters waiters = new CustomWaiters(driver);
    protected SearchPage SearchPage = new SearchPage(driver);
    protected LoginAccount LoginAccount = new LoginAccount(driver);
    protected pages.Ordering Ordering = new Ordering(driver);
    @BeforeSuite
    public void init(){
        driver = DriverInit.startDriver();
    }
  /* @AfterSuite
    public void stop(){
        driver.quit();
    }*/
}
