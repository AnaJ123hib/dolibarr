package pages.commerce;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class OrderListPage extends PageObject {
    @FindBy(className = "listwithfilterbefore") public WebElementFacade listTable;
    @FindBy(css = "a[href='/fourn/commande/list.php?leftmenu=orders_suppliers']")
    public WebElementFacade listButton;

    public void navigateToList() {
        listButton.click();
    }

    public boolean isListDisplayed(){
        return listTable.isVisible();
    }
}
