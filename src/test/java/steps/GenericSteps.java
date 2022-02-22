package steps;

import Utils.Controlers;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class GenericSteps {

    @Then("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int status) {
        Assert.assertEquals(status, Controlers.getResponse().statusCode());
    }

    @Then("valido que no campo {string} possui o valor {string}")
    public void validoQueNoCampoPossuiOValor(String tipo, String valor) {
        Assert.assertEquals(valor,Controlers.getResponse().jsonPath().get(tipo));
    }
}
