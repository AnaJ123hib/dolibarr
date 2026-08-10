package pages.commerce;

import models.OrderData;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import static components.FormUtils.*;

public class CreateOrderPage extends PageObject {
    @FindBy (css = "a[href='/fourn/commande/card.php?action=create&leftmenu=orders_suppliers']")
    private WebElementFacade createOrderButton;
    @FindBy (id = "select2-socid-container") private WebElementFacade vendedorDropdown;
    @FindBy (id = "select2-cond_reglement_id-container") private WebElementFacade termsDropdown;
    @FindBy (id = "select2-selectmode_reglement_id-container") private WebElementFacade methodDropdown;
    @FindBy (name = "refsupplier") private WebElementFacade redVendorInput;
    @FindBy (id = "liv_") private WebElementFacade deliveryDatePicker;
    @FindBy (className = "button-save") private WebElementFacade savesButton;
    @FindBy (className = "button-cancel") private WebElementFacade cancelButton;


    public void navigateToNewOrder(){createOrderButton.click();}

    public void fillOrderForm(OrderData order) {
        selectIfNotInvalid(vendedorDropdown, order.getVendorIndex());
        selectIfNotNull(termsDropdown, order.getPaymentTerms());
        selectIfNotNull(methodDropdown, order.getPaymentMethod());
        typeIfNotNull(deliveryDatePicker, order.getDeliveryDate());
        typeIfNotNull(redVendorInput, order.getRefVendor());
    }

    public void saveOrder(){savesButton.click();}
    public void cancelOrder(){cancelButton.click();}
}
