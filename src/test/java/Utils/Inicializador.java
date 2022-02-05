package Utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;

import static controlerTests.Controlers.post;
import static controlerTests.Controlers.postInicializador;
import static io.restassured.RestAssured.baseURI;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Inicializador {

    @BeforeAll
    public static String validarLoginMap(){

        baseURI = "http://localhost:8080/";
        Map<String, String> map = new HashMap<>();
        map.put("email","aluno@email.com");
        map.put("senha","123456");

        Response response =  postInicializador(map, ContentType.JSON, "auth");
        assertEquals(200,response.statusCode());
        return response.body().jsonPath().get("token");

    }
}
