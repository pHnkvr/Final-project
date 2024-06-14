package tests;

import org.testng.annotations.Test;


public class SearchPage extends BasePage{
    @Test(priority = 1)
    public void openMainPage_C17() throws InterruptedException {
        SearchPage.openMainPage()
                .closeCashbackButton()
                .inputField("EcoFlow River");
    }
    @Test(priority = 2)
    public void showResultsInList_C18() throws InterruptedException{
        SearchPage.ShowInList();
    }
    @Test(priority = 3)
    public void changeRangeOfPrice_C19() throws InterruptedException{
        SearchPage.inputPrice("20000", "50000")
                .showProductPopupMessage();
    }
    @Test(priority = 4)
    public void findWrongRequest_C20()throws InterruptedException{
        SearchPage.inputCatalogSearch("инфляция")
                .isMessageEqualsForRandomWord("инфл@ция", 0);
    }
    @Test(priority = 5)
    public void findRequestWithSpecialSymbol_C21()throws InterruptedException{
        SearchPage.inputCatalogSearch("Ec)Fl)w r!v3r");
    }
    @Test(priority = 6)
    public void findExpectedRequest_C22()throws InterruptedException{
        SearchPage.inputCatalogSearch("EcoFlow River")
                .isMessageEqualsForNotRandomWord("ecoflow river", 193); // тест зависит от того, сколько в локаторе showActualResult найдено результатов
    }
}
