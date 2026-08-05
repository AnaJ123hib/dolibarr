package pages.customers;

import components.Table;
import models.CustomerData;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CustomerListPage extends PageObject {
    @FindBy (xpath = "//a[contains(@href,'adherents/list.php') and not(contains(@href,'statut='))]")
    private WebElementFacade listMenuButton;
    @FindBy (name = "search_ref") private WebElementFacade filterId;
    @FindBy (css = "a .usertext") private WebElementFacade userIdTable;
    private Table table;
    public void navigateToListMembers(){
        listMenuButton.click();
    }
    public void selectCustomer(CustomerData customer) {
        table.findByFilter(filterId, customer.getId());
        userIdTable.click();
    }
}
