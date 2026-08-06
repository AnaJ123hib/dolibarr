package components;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class Dropdown extends PageObject {
    public void selectOption(WebElementFacade element, String value){
        if(value != null && !value.isBlank()) {
            element.click();
            findBy("//li[@class='select2-results__option' " +
                    "and normalize-space()='" + value + "']").click();
        }
    }
}
