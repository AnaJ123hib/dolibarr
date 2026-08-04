package pages.authentication;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
    @FindBy (name = "username" ) private WebElementFacade usernameInput;
    @FindBy (name = "password" ) private WebElementFacade passwordInput;
    @FindBy (css = ".butActionLogin" ) private WebElementFacade loginButton;
    @FindBy (css = "#a1profdemofun2") private WebElementFacade webDemoButton;
    @FindBy (css = ".jnotify-notification-error") private WebElementFacade errorMessage;

    public void openSite() {
        open();
        webDemoButton.click();
    }

    public void login(String username, String password) {
        usernameInput.type(username);
        passwordInput.type(password);
        loginButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isVisible();
    }
}
