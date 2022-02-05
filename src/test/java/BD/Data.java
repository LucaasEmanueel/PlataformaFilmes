package BD;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Data {

    //ler um json
    public static String lerjson(String caminhoJson) throws IOException{
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }
}
