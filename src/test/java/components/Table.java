package components;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class Table extends PageObject {
    @FindBy (className = "button_search") private WebElementFacade searchButton;
    public void findByFilter(WebElementFacade element, String value) {
        element.type(value);
        searchButton.click();
    }
    public String getValueFromFirstRow(int columnIndex) {
        List<WebElementFacade> cells = findAll("tr.row-with-select td");
        return cells.get(columnIndex - 1).getText().trim();
    }

    public boolean isThereResults() {
        List<WebElementFacade> cells = findAll("tr.row-with-select td");
        return !cells.isEmpty();
    }
}
