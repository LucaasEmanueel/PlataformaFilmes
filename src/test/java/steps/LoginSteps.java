package steps;

import BD.Data;
import Utils.Inicializador;
import controlerTests.Controlers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import maps.LoginMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class LoginSteps {

    String url = "localhost:8080/";


    @Given("que tenha um payload valida da API de Login")
    public void queTenhaUmPayloadValidaDaAPIDeLogin() {
        LoginMap.initLogin();
        //RestUtils.setBaseURI();

    }
    @When("envio uma requisicao do tipo POST")
    public void envioUmaRequisicaoDoTipoPOST() {
        Controlers.postInicializador(LoginMap.getLogin(), ContentType.JSON,"auth");
    }

    @Then("armazeno o token que recebo do response do Login")
    public void armazenoOTokenQueReceboDoResponseDoLogin() {
        LoginMap.token = Controlers.getResponse().jsonPath().get("token");
    }

    @Given("que tenha um payload da API de Login  com as seguintes informações")
    public void queTenhaUmPayloadDaAPIDeLoginComAsSeguintesInformações(io.cucumber.datatable.DataTable dataTable) {

    }

}
