package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends PageObject {
    @FindBy(css = "#tmenu_tooltip") private WebElementFacade menuBar;
    @FindBy (css = ".side-nav") private WebElementFacade sideMenu;
    @FindBy (css = ".fiche") private WebElementFacade ficheDashboard;

    public boolean isDisplayed() {
        return menuBar.isVisible()  &&
                sideMenu.isVisible() &&
                ficheDashboard.isVisible();
    }
}
