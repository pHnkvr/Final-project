package tests;

import org.testng.annotations.Test;

public class SearchPage extends BasePage{
    @Test(priority = 1)
    public void openMainPage() throws InterruptedException {
        SearchPage.openMainPage()
                .closeCachbackButton()
                .inputField("EcoFlow River");


    }
    @Test(priority = 2)
    public void changeRangeOfPrice() throws InterruptedException{
        SearchPage.inputPrice("20000", "50000")
                .showProductPopupMessage();

    }
}
