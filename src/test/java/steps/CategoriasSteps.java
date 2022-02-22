package steps;

import Utils.Controlers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import maps.LoginMap;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CategoriasSteps {
    Map<String, String> header = new HashMap<>();

    @Given("tenha um payload da API de categorias")
    public void tenhaUmPayloadDaAPIDeCategorias() {
        header.put("Authorization", "Bearer "+LoginMap.token);
    }

    @When("envio uma requisicao do tipo GET de categoria")
    public void envioUmaRequisicaoDoTipoGET() {
        Controlers.get("categorias",header);
    }

    @Given("altere o campo {string} para {string} do header de categoria")
    public void altereOCampoParaDoHeaderDeCategoria(String key, String value) {
        header.put(key,value);
    }

}
