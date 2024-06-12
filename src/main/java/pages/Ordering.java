package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Ordering extends BasePage{
    public Ordering(WebDriver driver) {
        super(driver);
    }
    private final static class Locators {
        private static final By changeSorting = By.xpath("//span[@class='sort-by__current']");
        private static final By sortByList = By.xpath("//ul[@class='sort-by__list']");
        private static By sortByOption(String optionTitle) {
            return By.xpath("//li[@title='" + optionTitle + "']");
    }

  public Ordering changeSort(String sortOption){
        workWithElements.click(Locators.changeSorting);
        workWithElements.click(Locators.sortByList);
        return this;
  }
}

