package controlerTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class Controlers {

    private static Response response;

    public static Response getResponse(){
        return response;
    }

    public void setResponse(Response response){
        this.response = response;
    }

    public static Response post(Object json, ContentType contentType, String endpoint, Map<String, String> header) {
        return response = given()
                .relaxedHTTPSValidation()
                .headers(header)
                .contentType(contentType)
                .body(json)
                .when().post(endpoint)
                .thenReturn();

    }

    public static Response postInicializador(Object json, ContentType contentType, String endpoint){
        return response =  given()
                .relaxedHTTPSValidation()
                .contentType(contentType)
                .body(json)
                .when().post(endpoint)
                .thenReturn();
    }

    public static Response put(Object json, ContentType contentType, String endpoint, Map<String, String> header){
        return response = given()
                .relaxedHTTPSValidation()
                .headers(header)
                .contentType(contentType)
                .body(json)
                .when().put(endpoint)
                .thenReturn();
    }

    public static Response get(String endpoint, Map<String, String> header){
        return response = given()
                .relaxedHTTPSValidation()
                .headers(header)
                .when()
                .get(endpoint)
                .thenReturn();

    }

    public static Response delete(String endpoint, Integer id, Map<String, String> header){
        return response = given()
                .relaxedHTTPSValidation()
                .headers(header)
                .when()
                .delete(endpoint +"/"+ id)
                .thenReturn();
    }

}
