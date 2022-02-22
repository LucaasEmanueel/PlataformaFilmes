package steps;

import Utils.Controlers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import maps.LoginMap;
import java.util.Map;


public class LoginSteps {

    String url = "http://localhost:8080/";

    @Given("que tenha um payload valida da API de Login")
    public void queTenhaUmPayloadValidaDaAPIDeLogin() {
        LoginMap.initLogin();
        Controlers.setBaseURI(url);
    }

    @Then("armazeno o token que recebo do response do Login")
    public void armazenoOTokenQueReceboDoResponseDoLogin() {
        LoginMap.token = Controlers.getResponse().jsonPath().get("token");
    }

    @Given("que tenha um payload da API de Login  com as seguintes informações")
    public void queTenhaUmPayloadDaAPIDeLoginComAsSeguintesInformações(Map<String, String> map) {
            LoginMap.initLogin();
            Controlers.setBaseURI(url);
            LoginMap.getLogin().putAll(map);
    }

    @When("envio uma requisicao do tipo {string}")
    public void envioUmaRequisicaoDoTipoPOST() {
        Controlers.post(LoginMap.getLogin(), ContentType.JSON,"auth");
    }

    @Given("que tenha usado o login com dados validos")
    public void queTenhaUsadoOLoginComDadosValidos() {
        queTenhaUmPayloadValidaDaAPIDeLogin();
        envioUmaRequisicaoDoTipoPOST();
        armazenoOTokenQueReceboDoResponseDoLogin();
    }


}
