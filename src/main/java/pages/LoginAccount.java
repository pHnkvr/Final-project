package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Urls;

public class LoginAccount extends BasePage{

    public LoginAccount(WebDriver driver) {
        super(driver);
    }
    private final static class Locators {
        private static final By closeCachbackButton = By.xpath("//button[@class='close']");
        private static final By closeCachbackImage = By.xpath("//a[@class='img_a']");
        private static final By loginProfile = By.xpath("//button[@aria-label='Профіль']");
        private static final By authPopUp = By.xpath("//div[@class='auth']");
        private static final By phonePlaceholder = By.name("telephone");
        private static final By errorMessage = By.xpath("//span[@class='a-input__message base-message is-error']");
        private static final By enterByLoginAndPass = By.xpath("//button[@type='submit']//span[contains(text(), 'Логін та пароль')]");
        private static final By submitButton = By.xpath("//button[@type='submit']//span[contains(text(), 'Увійти')]");
        private static final By emailPhonePlaceholder = By.xpath("//input[@name='phoneEmail']");
        private static final By passwordPlaceholder = By.xpath("//input[@name='password']");
        private static final By returnToLoginPopUp = By.xpath("//span[contains(text(), 'Iнший спосіб входу')]");
        private static final By googleAuth = By.xpath("//span[contains(text(), 'Google')]");
        private static final By facebookAuth = By.xpath("//span[contains(text(), 'Facebook')]");
    }
    public LoginAccount openMainPage() throws InterruptedException{
       {
            driver.get(Urls.page);
            return this;
        }
    }
    public LoginAccount closeCachbackButton(){
        try {
            waiters.waitForVisibility(LoginAccount.Locators.closeCachbackImage);
            workWithElements.click(LoginAccount.Locators.closeCachbackButton);
        }catch (Exception e){}
        return this;
    }
    public LoginAccount clickLoginIcon(){
        workWithElements.click(Locators.loginProfile);
        return this;
    }
    public LoginAccount inputPhoneNumber(String number){
        waiters.waitForVisibility(Locators.authPopUp);
        workWithElements.inputText(Locators.phonePlaceholder, number);
        workWithElements.pressEnter(Locators.phonePlaceholder);
        return this;
    }
    public LoginAccount errorResult(){
        waiters.waitForVisibility(Locators.errorMessage);
        workWithElements.printMessage(Locators.errorMessage);
        return this;
    }
    public LoginAccount enterByLoginAndPassword(){
        workWithElements.click(Locators.enterByLoginAndPass);
        return this;
    }
    public LoginAccount clearPlaceholder(){
        workWithElements.clearInput(Locators.emailPhonePlaceholder);
        workWithElements.clearInput(Locators.passwordPlaceholder);
        return this;
    }
    public LoginAccount submitEnterButton(){
        workWithElements.click(Locators.submitButton);
        return this;
    }
    public LoginAccount emailPlaceholder(String phoneOrEmail){
        workWithElements.inputText(Locators.emailPhonePlaceholder, phoneOrEmail);
        return this;
    }
    public LoginAccount phonePlaceholder(String phomeOrEmail){
        workWithElements.inputText(Locators.emailPhonePlaceholder, phomeOrEmail);
        return this;
    }
    public LoginAccount passwordPlaceholder(String pass){
        workWithElements.inputText(Locators.passwordPlaceholder, pass);
        return this;
    }
    public LoginAccount returnToLogin(){
        workWithElements.click(Locators.returnToLoginPopUp);
        return this;
    }
    public LoginAccount googleAuthorization(){
        workWithElements.click(Locators.googleAuth);
        return this;
    }
    public LoginAccount facebookAuthorization(){
        workWithElements.click(Locators.facebookAuth);
        return this;
    }
    public LoginAccount closeAuthorization(){
        workWithElements.closePopUpWindow(driver);
        return this;
    }

}
