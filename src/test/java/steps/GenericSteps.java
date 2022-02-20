package steps;

import Utils.Controlers;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class GenericSteps {
    @Then("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int status) {
        Assert.assertEquals(status, Controlers.getResponse().statusCode());
    }
}
