package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import test_rail_integration.TestRailIntegration;

@Listeners(TestRailIntegration.class)
public class LoginAccount extends BasePage {

    @Test(priority = 1)
    public void openMainPage_C4() throws InterruptedException {
        LoginAccount.openMainPage()
                .closeCachbackButton();
    }

    @Test(priority = 2, dependsOnMethods = "openMainPage_C4")
    public void clickLoginIconOnMainPage_C5() throws InterruptedException {
        LoginAccount.clickLoginIcon();
    }

    @Test(priority = 3, dependsOnMethods = "clickLoginIconOnMainPage_C5")
    public void enterOnMainPopUpAuthByPhone_C6() throws InterruptedException {
        LoginAccount.inputPhoneNumber("638268797")
                .returnToLogin()
                .inputPhoneNumber("63826879")
                .errorResult()
                .inputPhoneNumber("6382687991")
                .returnToLogin()
                .inputPhoneNumber("")
                .errorResult()
                .inputPhoneNumber(";63826879")
                .errorResult();
    }

    @Test(priority = 4, dependsOnMethods = "enterOnMainPopUpAuthByPhone_C6")
    public void enterByLoginAndPass_C7() throws InterruptedException {
        LoginAccount.enterByLoginAndPassword()
                .emailPlaceholder("a@mail.com")
                .passwordPlaceholder("qwerty12345")
                .returnToLogin()
                .enterByLoginAndPassword()
                .clearPlaceholder()
                .submitEnterButton()
                .emailPlaceholder("")
                .passwordPlaceholder("")
                .emailPlaceholder("aaaaaa")
                .passwordPlaceholder("")
                .emailPlaceholder("a!@mail.com")
                .passwordPlaceholder("")
                .emailPlaceholder("4@mail.com")
                .passwordPlaceholder("")
                .emailPlaceholder("a@mail.com")
                .passwordPlaceholder("")
                .returnToLogin();
    }

    @Test(priority = 5, dependsOnMethods = "enterByLoginAndPass_C7")
    public void enterByPhoneAndPass_C8() throws InterruptedException {
        LoginAccount.enterByLoginAndPassword()
                .phonePlaceholder("+380638268794") //random number, not mine
                .passwordPlaceholder("qwerty12345")
                .returnToLogin()
                .enterByLoginAndPassword()
                .clearPlaceholder()
                .submitEnterButton()
                .phonePlaceholder("")
                .passwordPlaceholder("")
                .phonePlaceholder("2")
                .phonePlaceholder("+!01234567891")
                .phonePlaceholder("+38063826879412121")
                .phonePlaceholder("+1")
                .returnToLogin();
    }

    @Test(priority = 6, dependsOnMethods = "enterByPhoneAndPass_C8")
    public void enterByGoogleAuth_C9() {
        LoginAccount.googleAuthorization()
                .closeAuthorization();
    }

    @Test(priority = 7, dependsOnMethods = "enterByGoogleAuth_C9")
    public void enterByFacebookAuth_C10() {
        LoginAccount.facebookAuthorization()
                .closeAuthorization();
    }
}
