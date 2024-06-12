package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Ordering extends BasePage{
    public Ordering(WebDriver driver) {
        super(driver);
    }
    private final static class Locators {
        private static final By changeSorting = By.xpath("//div[@class='sort-by__select']");
        private static final By addToCart = By.xpath("(//button[@class='v-btn--cart'])[1]");
        private static final By cartPopUp = By.xpath("//div[@class='v-modal__cmp cart-popup checkout_modal']");
        private static final By plusButton = By.xpath("(//*[local-name()='svg' and contains(@class, 'qty__up')])");
        private static final By showInList = By.xpath("//button[@title='Список']");
        private static final By createAnOrder = By.xpath("//button[@class='order-now']");

    }

  public Ordering changeSort(String sortOption){waiters.clickableStateOfElement(Locators.changeSorting);
        workWithElements.hoverOverSort(Locators.changeSorting);
        By optionLocator = workWithElements.buildSortOptionLocator(sortOption);
        workWithElements.click(optionLocator);
        return this;
  }
  public Ordering addingToCart() throws InterruptedException {
        waiters.clickableStateOfElement(Locators.showInList);
        workWithElements.click(Locators.showInList);
        waiters.clickableStateOfElement(Locators.addToCart);
        workWithElements.click(Locators.addToCart);
        return this;
  }
  public Ordering cart(){
        waiters.waitForVisibility(Locators.cartPopUp);
        waiters.clickableStateOfElement(Locators.plusButton);
        waiters.waitForVisibility(Locators.cartPopUp);
        workWithElements.clickMultipleTimes(Locators.plusButton, 2);
        waiters.waitForVisibility(Locators.cartPopUp);
        return this;
  }
  public Ordering creatingOrder(){
        waiters.clickableStateOfElement(Locators.plusButton);
        workWithElements.click(Locators.createAnOrder);
        return this;
  }
}

