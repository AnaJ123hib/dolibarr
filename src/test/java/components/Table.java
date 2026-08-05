package components;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class Table extends PageObject {
    @FindBy (className = "button_search") private WebElementFacade searchButton;
    public void findByFilter(WebElementFacade element, String value) {
        element.type(value);
        searchButton.click();
    }
}
