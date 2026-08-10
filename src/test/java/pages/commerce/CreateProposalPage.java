package pages.commerce;

import components.Dropdown;
import models.ProposalData;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CreateProposalPage extends PageObject {
    @FindBy(className = "menu_contenu_supplier_proposal_card")
    private WebElementFacade newProposalButton;
    @FindBy (id = "select2-socid-container") private WebElementFacade vendedorDropdown;
    @FindBy (id = "select2-cond_reglement_id-container") private WebElementFacade termsDropdown;
    @FindBy (id = "select2-selectmode_reglement_id-container") private WebElementFacade methodDropdown;
    @FindBy (id = "liv_") private WebElementFacade deliveryDatePicker;
    @FindBy (className = "button-save") private WebElementFacade saveButton;
    @FindBy (className = "button-cancel") private WebElementFacade cancelButton;
    Dropdown dropdown;

    public void navigateToNewProposal() {
        newProposalButton.click();
    }

    private void typeIfNotNull(WebElementFacade element, String value) {
        if(value != null && !value.isBlank()){
            element.type(value);
        }
    }
    private void selectIfNotInvalid(WebElementFacade element, int value) {
        if(value >= 0){
            dropdown.selectIndex(element, value);
        }
    }

    private void selectIfNotNull(WebElementFacade element, String value) {
        if(value != null && !value.isBlank()){
            dropdown.selectOption(element, value);
        }
    }

    public void fillProposalForm(ProposalData proposal) {
        selectIfNotInvalid(vendedorDropdown, proposal.getVendedorIndex());
        selectIfNotNull(termsDropdown, proposal.getPaymentTerms());
        selectIfNotNull(methodDropdown, proposal.getPaymentMethod());
        typeIfNotNull(deliveryDatePicker, proposal.getDeliveryDate());
    }

    public void saveProposal() { saveButton.click();}
    public void cancelProposal() {cancelButton.click();}
}
