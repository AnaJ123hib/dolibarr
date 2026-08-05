package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;

public class Hooks {
    @Before
    public void beforeScenario(){

        System.out.println("Starting scenario");

    }
    @After
    public void afterScenario(){
        Serenity.getWebdriverManager().closeCurrentDrivers();
    }
}
