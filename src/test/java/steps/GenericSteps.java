package steps;

import Utils.Controlers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.ArrayList;


public class GenericSteps {

    @Then("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int status) {
        Assert.assertEquals(status, Controlers.getResponse().statusCode());
    }

    @Then("valido que no campo {string} possui o valor {string}")
    public void validoQueNoCampoPossuiOValor(String tipo, String valor) {
        Assert.assertEquals(valor,Controlers.getResponse().jsonPath().get(tipo));
    }

    @And("valido que recebo uma lista vazia")
    public void validoQueReceboUmaListaVazia() {
        Assert.assertEquals(new ArrayList<>(0), Controlers.getResponse().jsonPath().get());
    }
}
