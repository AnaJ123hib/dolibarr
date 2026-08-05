package pages.customers;

import models.CustomerData;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CustomerDetailsPage extends PageObject {
    @FindBy(xpath = "//a[contains(@class,'butAction') and contains(@href,'action=edit')]")
    private WebElementFacade modifyButton;
    @FindBy(xpath = "//span[@class='valignmiddle' and normalize-space()]")
    private WebElementFacade customerProfileName;
    public void goToModifyCustomer(){
        modifyButton.click();
    }
    public boolean isCustomerDisplayed(CustomerData customer) {
        return findAll("table tbody tr").stream()
                .anyMatch(row -> row.getText().contains(customer.getFirstName())
                        && row.getText().contains(customer.getLastName()));
    }

    public boolean customerUsernameIsDisplayed(CustomerData customer) {
        return customerProfileName.isVisible()
                && customerProfileName.getText().equals(customer.getUsername());
    }
}
