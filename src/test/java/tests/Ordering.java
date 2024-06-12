package tests;

import org.testng.annotations.Test;

public class Ordering extends BasePage {
@Test(priority = 1)
    public void openMainPage() throws InterruptedException {
    SearchPage.openMainPage()
            .closeCashbackButton()
            .inputField("EcoFlow River");
}
@Test(priority = 2)
    public void changeRangeOfPrice() throws InterruptedException{
        SearchPage.inputPrice("20000", "50000")
                .showProductPopupMessage();
    }
    @Test(priority = 3)
    public void chooseSort()throws InterruptedException{
        Ordering.changeSort("від дешевих до дорогих");

    }
    @Test(priority = 4)
    public void addToCart()throws InterruptedException{
        Ordering.addingToCart()
                .cart();

    }
    @Test(priority = 5)
    public void order()throws InterruptedException{
        Ordering.creatingOrder();
    }
}
