package tests;

import org.testng.annotations.Test;

public class LoginAccount extends BasePage{
     @Test(priority = 1)
     public void openMainPage()throws InterruptedException{
         LoginAccount.openMainPage()
                 .closeCachbackButton();
     }
@Test(priority = 2)
    public void clickLoginIconOnMainPage() throws InterruptedException{
    LoginAccount.clickLoginIcon();

}
@Test(priority = 3)
    public void enterOnMainPopUpAuthByPhone() throws InterruptedException{
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
@Test(priority = 4)
    public void enterByLoginAndPass() throws InterruptedException{
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
@Test(priority = 5)
public void enterByPhoneAndPass() throws InterruptedException{
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
@Test(priority = 6)
    public void enterByGoogleAuth(){
         LoginAccount.googleAuthorization()
                 .closeAuthorization();
}
@Test(priority = 7)
    public void enterByFacebookAuth(){
         LoginAccount.facebookAuthorization()
                 .closeAuthorization();
}
}
