package maps;

import controlerTests.Controlers;

import java.util.HashMap;
import java.util.Map;

public class LoginMap {

    private static Map<String, Object> login;
    public static String token;

    public Map<String, Object> getLogin(){
        return this.login;
    }

    public static void initLogin(){
        login = new HashMap<>();
        login.put("email","aluno@email.com");
        login.put("senha", "123456");
        token = Controlers.getResponse().jsonPath().get("token");
    }
}
