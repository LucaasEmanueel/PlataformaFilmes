package Utils;

import controlerTests.Controlers;
import io.restassured.http.ContentType;
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

        Controlers.postInicializador(map, ContentType.JSON, "auth");
        assertEquals(200,Controlers.getResponse().statusCode());
        return Controlers.getResponse().jsonPath().get("token");

    }
}