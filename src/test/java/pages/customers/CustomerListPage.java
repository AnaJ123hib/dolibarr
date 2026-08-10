package pages.customers;

import components.Table;
import models.CustomerData;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import static components.FormUtils.*;

public class CustomerListPage extends PageObject {
    @FindBy (xpath = "//a[contains(@href,'adherents/list.php') and not(contains(@href,'statut='))]")
    private WebElementFacade listMenuButton;
    @FindBy (name = "search_ref") private WebElementFacade filterId;
    @FindBy (id = "select2-search_type-container") private WebElementFacade filterMemberType;

    @FindBy (name = "search_firstname") private WebElementFacade filterName;

    @FindBy (css = "a .usertext") private WebElementFacade userIdTable;
    private Table table;
    public void navigateToListMembers(){
        listMenuButton.click();
    }
    public void selectCustomer(CustomerData customer, String filter) {
        switch (filter) {
            case "Name":
                table.findByFilter(filterName, customer.getFirstName()); break;
            case "Member type":
                selectIfNotInvalid(filterMemberType, customer.getMemberType()); break;
            case "ID":
            default:
                table.findByFilter(filterId, customer.getId()); break;
        }
    }

    public void selectCustomer(CustomerData customer) {
        table.findByFilter(filterId, customer.getId());
    }

    public String getValueFromTable(String searchType) {
        return switch (searchType) {
            case "ID" -> table.getValueFromFirstRow(3);
            case "Name" -> table.getValueFromFirstRow(5);
            case "Last Name" -> table.getValueFromFirstRow(6);
            case "Member type" -> table.getValueFromFirstRow(9);
            default -> throw new IllegalArgumentException("Search type not supported");
        };

    }

    public Boolean isThereResultsInCustomer() {
        return table.isThereResults();
    }
}
