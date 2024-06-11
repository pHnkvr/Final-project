package tests;

import org.testng.annotations.Test;

public class SearchPage extends BasePage{
    @Test(priority = 1)
    public void openMainPage() throws InterruptedException {
        SearchPage.openMainPage()
                .closeCashbackButton()
                .inputField("EcoFlow River");
    }
    @Test(priority = 2)
    public void showResultsInList() throws InterruptedException{
        SearchPage.ShowInList();
    }
    @Test(priority = 3)
    public void changeRangeOfPrice() throws InterruptedException{
        SearchPage.inputPrice("20000", "50000")
                .showProductPopupMessage();
    }
    @Test(priority = 4)
    public void findWrongRequest()throws InterruptedException{
        SearchPage.inputWrongCatalogSearch("инфляция")
                .isMessageEquals("инфляция", 0);
    }
    @Test(priority = 5)
    public void findRequestWithSpecialSymbol()throws InterruptedException{
        SearchPage.inputWrongCatalogSearch("Ec)Fl)w r!v3r")
                .isMessageEquals("Ec)Fl)w r!v3r", 192);

    }
}
