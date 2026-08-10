package components;

import net.serenitybdd.core.pages.WebElementFacade;

public class Dropdown {

    public void selectOption(WebElementFacade element, String value) {
        if (value != null && !value.isBlank()) {
            element.click();

            element.findBy(
                    "//li[@class='select2-results__option' " +
                            "and normalize-space()='" + value + "']"
            ).click();
        }
    }

    public void selectIndex(WebElementFacade element, int index) {
        if (index >= 0) {
            element.click();

            element.thenFindAll(
                    "//li[@class='select2-results__option']"
            ).get(index).click();
        }
    }
}