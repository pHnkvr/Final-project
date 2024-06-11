package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Urls;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final static class Locators {
        private static final By closeCachbackButton = By.xpath("//button[@class='close']");
        private static final By closeCashbackImage = By.xpath("//a[@class='img_a']");
        private static final By findPlaceholder = By.id("search-form__input");
        private static final By showInList = By.xpath("//button[@title='Список']");
        private static final By priceSection = By.xpath("(//section[@class='f-range'])[1]");
        private static final By minPrice = By.xpath("(//input[@class='f-range__form-input'])[1]");
        private static final By maxPrice = By.xpath("(//input[@class='f-range__form-input'])[2]");
        private static final By showProduct = By.xpath("//span[@class='f-popup__message']");
        private static final By noSuchResult = By.xpath("//span[contains(., 'Знайдено товарів: 0')]");
    }

    public SearchPage openMainPage() throws InterruptedException {
        driver.get(Urls.page);
        return this;
    }

    public SearchPage closeCashbackButton() {
        try {
            waiters.waitForVisibility(Locators.closeCashbackImage);
            workWithElements.click(Locators.closeCachbackButton);
        } catch (Exception e) {
        }
        return this;
    }

    public SearchPage inputField(String searchText) {
        workWithElements.inputText(Locators.findPlaceholder, searchText);
        workWithElements.pressEnter(Locators.findPlaceholder);
        return this;
    }

    public SearchPage ShowInList() {
        workWithElements.click(Locators.showInList);
        return this;
    }

    public SearchPage inputPrice(String minPrice, String maxPrice) {
        waiters.waitForVisibility(Locators.priceSection);
        workWithElements.inputText(Locators.minPrice, minPrice);
        workWithElements.inputText(Locators.maxPrice, maxPrice);
        return this;
    }

    public SearchPage showProductPopupMessage() {
        try {
            waiters.waitForVisibility(Locators.showProduct);
            workWithElements.click(Locators.showProduct);
        } catch (Exception e) {
        }
        return this;
    }

    public SearchPage inputWrongCatalogSearch(String searchText) {
        workWithElements.inputText(Locators.findPlaceholder, searchText);
        workWithElements.pressEnter(Locators.findPlaceholder);
        return this;
    }

    public SearchPage isMessageEquals(String searchText, int numberOfResults) {
        String expectedMessage = String.format("Результати пошуку для '%s'. Знайдено товарів: %d", searchText, numberOfResults);
        waiters.waitForVisibility(Locators.noSuchResult);
        workWithElements.assertTextResult(Locators.noSuchResult, expectedMessage);
        return this;

    }
}