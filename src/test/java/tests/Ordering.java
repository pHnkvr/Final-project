package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import test_rail_integration.TestRailIntegration;


public class Ordering extends BasePage {
    @Test(priority = 1)
    public void openMainPage_C15() throws InterruptedException {
        SearchPage.openMainPage()
                .closeCashbackButton()
                .inputField("EcoFlow River");
    }

    @Test(priority = 2)
    public void changeRangeOfPrice_C11() throws InterruptedException {
        SearchPage.inputPrice("20000", "50000")
                .showProductPopupMessage();
    }

    @Test(priority = 3)
    public void chooseSort_C12() throws InterruptedException {
        Ordering.changeSort("від дешевих до дорогих");

    }

    @Test(priority = 4)
    public void addToCart_C13() throws InterruptedException {
        Ordering.addingToCart()
                .cart();

    }

    @Test(priority = 5)
    public void order_C14() throws InterruptedException {
        Ordering.creatingOrder();
    }

    @Test(priority = 6)
    public void cancelOrder_C16() throws InterruptedException {
        Ordering.cancelOrdering();
    }
}

