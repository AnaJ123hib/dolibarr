package pages.customers;

import models.CustomerData;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import static components.FormUtils.*;

import java.util.Objects;

public class CreateCustomerPage extends PageObject {
    @FindBy (css = ".menu_contenu_adherents_card a") private WebElementFacade newMemberMenuButton;
    @FindBy (id = "select2-typeid-container") private WebElementFacade memberTypeDropdown;
    @FindBy (id = "phisicalinput") private WebElementFacade individualRadioButton;
    @FindBy (id = "moralinput") private WebElementFacade legalRadioButton;
    @FindBy (name = "societe") private WebElementFacade companyInput;
    @FindBy (id = "select2-civility_code-container") private WebElementFacade typeDropdown;
    @FindBy (name = "lastname") private WebElementFacade lastnameInput;
    @FindBy (name = "firstname") private WebElementFacade firstnameInput;
    @FindBy (id = "select2-gender-container") private WebElementFacade genderDropdown;
    @FindBy (name = "member_email") private WebElementFacade emailInput;
    @FindBy (name = "member_url") private WebElementFacade webUrlInput;
    @FindBy (name = "address") private WebElementFacade addressInput;
    @FindBy (id = "zipcode") private WebElementFacade zipcodeInput;
    @FindBy (id = "town") private WebElementFacade cityInput;
    @FindBy (id = "select2-selectcountry_id-container") private WebElementFacade countryDrodown;
    @FindBy (id = "select2-state_id-container") private WebElementFacade stateInput;
    @FindBy (name = "phone_perso") private WebElementFacade personalPhoneInput;
    @FindBy (name = "phone_mobile") private WebElementFacade mobilePhoneInput;
    @FindBy (id = "birth") private WebElementFacade birthInput;
    @FindBy (id = "select2-selection__rendered") private WebElementFacade membershipStateDropdown;
    @FindBy (css = ".button-save") private WebElementFacade createCustomerButton;

    @FindBy (className = "jnotify-message") private WebElementFacade errorMessage;
    @FindBy (className = "button-cancel") private WebElementFacade cancelButton;
    @FindBy(css = "div.refid") private WebElementFacade customerInfo;

    private void selectNature(String value) {
        if(value != null && !value.isBlank()){
            if(Objects.equals(value, "Individual")) {
                individualRadioButton.click();
            }
            else if(Objects.equals(value, "Legal entity")){
                legalRadioButton.click();
            }else {
                throw new IllegalArgumentException("Invalid nature: " + value);
            }
        }
    }
    public void navigateToNewMemberPage(){
        newMemberMenuButton.click();
    }
    public void fillCustomerForm(CustomerData customer) {
        selectIfNotInvalid(memberTypeDropdown, customer.getMemberType());
        selectNature(customer.getNatureOfMember());
        typeIfNotNull(companyInput, customer.getCompany());
        selectIfNotNull(typeDropdown, customer.getTitle());
        typeIfNotNull(lastnameInput, customer.getLastName());
        typeIfNotNull(firstnameInput, customer.getFirstName());
        selectIfNotNull(genderDropdown, customer.getGender());
        typeIfNotNull(emailInput, customer.getEmail());
        typeIfNotNull(webUrlInput, customer.getWeb());
        typeIfNotNull(addressInput, customer.getAddress());
        typeIfNotNull(zipcodeInput, customer.getZipCode());
        typeIfNotNull(cityInput, customer.getCity());
        selectIfNotNull(countryDrodown, customer.getCountry());
        typeIfNotNull(stateInput, customer.getState());
        typeIfNotNull(personalPhoneInput, customer.getPersonalPhone());
        typeIfNotNull(mobilePhoneInput, customer.getMobile());
        typeIfNotNull(birthInput, customer.getDateOfBirth());
        selectIfNotNull(membershipStateDropdown, customer.getPublicMembership());
    }
    public void saveCustomerData(){
        createCustomerButton.click();
    }
    public void setCustomerId(CustomerData customer) {
         customer.setId(customerInfo.getText().split("\\R")[0].trim());
    }

    public boolean isErrorMessageDisplayed(){
        return errorMessage.isVisible();
    }
    public void cancelCreateCustomer() {
        cancelButton.click();
    }

    public void leaveSpaceBlank(String field) {
        switch (field){
            case "Name":
                firstnameInput.clear(); break;
            case "Last name":
                lastnameInput.clear(); break;
        }
    }
}
