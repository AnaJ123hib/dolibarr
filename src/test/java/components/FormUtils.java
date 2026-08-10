package components;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class FormUtils {
    private static final Dropdown dropdown = new Dropdown();
    public static void typeIfNotNull(WebElementFacade element, String value) {
        if (value != null && !value.isBlank()) {
            element.type(value);
        }
    }

    public static void selectIfNotNull(WebElementFacade element, String value) {
        if (value != null && !value.isBlank()) {
            dropdown.selectOption(element, value);
        }
    }

    public static void selectIfNotInvalid(WebElementFacade element, int value) {
        if (value >= 0) {
            dropdown.selectIndex(element, value);
        }
    }
}
