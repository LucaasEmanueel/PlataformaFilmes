package Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Controlers {


    public static void setBaseURI(String uri){
        baseURI = uri;
    }

    public static String getURI(){
        return baseURI;
    }

    private static Response response;

    public static Response getResponse(){
        return response;
    }

    public static Response post(Object json, ContentType contentType, String endpoint, Map<String, String> header) {
        return response = given()
                .relaxedHTTPSValidation()
                .headers(header)
                .contentType(contentType).log().all()
                .body(json)
                .when().log().all().post(endpoint)
                .thenReturn();

    }

    public static Response post(Object json, ContentType contentType, String endpoint){
        return response =  given()
                .relaxedHTTPSValidation()
                .contentType(contentType).log().all()
                .body(json)
                .when().log().all().post(endpoint)
                .thenReturn();
    }

    public static Response put(Object json, ContentType contentType, String endpoint, Map<String, String> header){
        return response = given()
                .relaxedHTTPSValidation()
                .headers(header)
                .contentType(contentType).log().all()
                .body(json)
                .when().log().all().put(endpoint)
                .thenReturn();
    }

    public static Response get(String endpoint, Map<String, String> header){
        return response = given()
                .relaxedHTTPSValidation()
                .headers(header)
                .when().log().all()
                .get(endpoint)
                .thenReturn();

    }

    public static Response delete(String endpoint, Integer id, Map<String, String> header){
        return response = given()
                .relaxedHTTPSValidation()
                .headers(header)
                .when().log().all()
                .delete(endpoint +"/"+ id)
                .thenReturn();
    }

}
