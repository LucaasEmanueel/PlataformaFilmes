package steps;

import Utils.Controlers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import maps.FilmesMaps;
import java.util.HashMap;
import java.util.Map;

public class FilmesSteps {

    @And("que tenha uma payload valida da API de Filmes")
    public void queTenhaUmaPayloadValidaDaAPIDeFilmes() {
        FilmesMaps.initAll();
    }

    @When("envio uma requisicao do tipo POST de Filmes")
    public void envioUmaRequisicaoDoTipoDeFilmes() {
        Controlers.post(FilmesMaps.getFilmes(),ContentType.JSON,"filmes", FilmesMaps.getHeader());
    }

    @When("envio uma requisicao do tipo GET de filme")
    public void envioUmaRequisicaoDoTipoGETDeFilme() {
        Map<String, Object> param = new HashMap<>();
        String nome = FilmesMaps.getFilmes().get("nome").toString();
        param.put("nome",nome);
        Controlers.get(param,"filmes", FilmesMaps.getHeader());
    }

    @And("armazeno o id que recebo do response de Filme")
    public void armazenoOIdQueReceboDoResponseDeFilme(){
        FilmesMaps.id = Controlers.getResponse().jsonPath().get("id");
    }

    @Given("altero o indice {int} de categorias de filmes com os valores")
    public void alteroOIndiceDeCategoriasDeFilmesComOsValores(Integer indice, Map<String, Object> map) {
        FilmesMaps.getListCategorias().get(indice).putAll(map);
    }

    @When("envio uma requisicao do tipo PUT de filme")
    public void envioUmaRequisicaoDoTipoPUTDeFilme() {
        Controlers.put(FilmesMaps.getFilmes(),ContentType.JSON,"filmes/"+FilmesMaps.id, FilmesMaps.getHeader());
    }

    @When("envio uma requisicao do tipo DELETE de filme")
    public void envioUmaRequisicaoDoTipoDELETEDeFilme() {
        Controlers.delete("filmes",FilmesMaps.id,FilmesMaps.getHeader());
    }

}
