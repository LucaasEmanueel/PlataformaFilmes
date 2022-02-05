package plataformaFilmes;

import BD.Data;
import Utils.Inicializador;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static controlerTests.Controlers.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlataformaFilmesTest {

    String token = Inicializador.validarLoginMap();

    @Test
    public void cadastrarPlataforma() throws IOException {
        String jsonBody = Data.lerjson("C:/Projetos/AutomacaoSemComplicacao/src/test/java/Dados/MassaDeDadosEditada.json");
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer "+ token);

        Response response = post(jsonBody,ContentType.JSON,"plataformas", header);
        assertEquals(201,response.statusCode());
        System.out.println("cadastro: "+ response.jsonPath().get().toString());
    }

    @Test
    public void listaPlataforma(){

        Response response = given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer "+ token)
                .queryParam("tipo", "Ação")
                .when()
                    .get("plataformas")
                .thenReturn();

        assertEquals(200, response.statusCode());
        System.out.println("Lista da plataforma --> " + response.jsonPath().get().toString());

    }

    @Test
    public void updatePlataforma() throws IOException {
        String json = Data.lerjson("C:/Projetos/AutomacaoSemComplicacao/src/test/java/Dados/MassaDeDadosEditada.json");
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer "+token);

        Response response = put(json,ContentType.JSON,"plataformas/2",header);
        assertEquals(200,response.statusCode());
        System.out.println("Lista atualizada -> "+ response.jsonPath().get().toString());
    }

    @Test
    public void detelePlataforma() {
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer "+token);

        Response response = delete("plataformas",1,header);
        assertEquals(200, response.statusCode());
        System.out.println("Id excluido --> "+ response.jsonPath().get().toString());
    }

    //categorias
    @Test
    public void mostraCategorias(){
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer "+token);

        Response response = get("categorias", header);
        assertEquals(200, response.statusCode());
        System.out.println(response.jsonPath().get().toString());
    }

    @Test
    public void validarConsultaCategoria(){
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer "+token);
        Response reponse = get("categorias",header);
        assertEquals("Drama",reponse.jsonPath().get("Tipo[3]"));
        System.out.println(reponse.jsonPath().get("Tipo[0]").toString());
    }


    //filmes
    @Test
    public void listaDeFilmes(){

        Response response = given()
                .contentType(ContentType.JSON)
                .headers("Authorization","Bearer "+token)
                .queryParam("tipo", "Ação")
                .when()
                .get("filmes")
                .thenReturn();
        assertEquals(200, response.statusCode());
        System.out.println("Lista de filmes --> "+response.jsonPath().get().toString());
    }

    @Test
    public void cadastrarPlataformaNoFilme() throws IOException {
        String json = Data.lerjson("C:/Projetos/AutomacaoSemComplicacao/src/test/java/Dados/CadastrarPLataformaNoFilme.json");

        Response response = given()
                            .contentType(ContentType.JSON)
                            .headers("Authorization","Bearer "+token)
                            .body(json)
                            .when()
                            .post("filmes")
                            .thenReturn();
        assertEquals(201,response.statusCode());
    }


}
