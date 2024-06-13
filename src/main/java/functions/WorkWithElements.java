package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Set;

public class WorkWithElements {
    private WebDriver driver;
    private CustomWaiters waiters;

    public WorkWithElements(WebDriver driver, CustomWaiters waiters) {
        this.driver = driver;
        this.waiters = waiters;
    }


    public void click(By locator) {
        waiters.waitForVisibility(locator);
        driver.findElement(locator).click();
    }

    public void inputText(By locator, String text) {
        waiters.waitForVisibility(locator);
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void pressEnter(By locator) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(Keys.ENTER);
    }

    public void printMessage(By locator) {
        waiters.waitForVisibility(locator);
        WebElement element = driver.findElement(locator);
        String text = element.getText();
        System.out.println(text);
    }

    public void closePopUpWindow(WebDriver driver) {
        Set<String> windowHandles = driver.getWindowHandles();
        String mainWindowHandle = driver.getWindowHandle();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                driver.close();
                break;
            }
        }
        driver.switchTo().window(mainWindowHandle);
    }

    public void clearInput(By locator) {
        WebElement element = driver.findElement(locator);
        element.clear();
    }

    public void assertTextResult(By locator, String expectedMessage) {
        WebElement element = driver.findElement(locator);
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedMessage, "Message is not equals");
    }

    public void assertTextResultIgnoringCase(By locator, String expectedMessage) {
        WebElement element = driver.findElement(locator);
        String actualText = element.getText();
        Assert.assertTrue(actualText.equalsIgnoreCase(expectedMessage), "Message is not equals (case insensitive)");

    }
    public void hoverOverSort(By locator) {
        WebElement sortElement = waiters.waitForVisibility(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(sortElement).perform();
    }
    public By buildSortOptionLocator(String sortOption) {
        return By.xpath("//ul[@class='sort-by__list']//li[@title='" + sortOption + "']");
    }
    public void clickMultipleTimes(By locator, int times) {
        for (int i = 0; i < times; i++) {
            click(locator);
        }
    }


}