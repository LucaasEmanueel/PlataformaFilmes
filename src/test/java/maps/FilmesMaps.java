package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmesMaps {

    public static int id;
    private static Map<String, String> header;
    private static Map<String, Object> filmes;
    private static Map<String, Object> categorias1;
    private static Map<String, Object> categorias2;
    private static Map<String, Object> plataforma;
    private static List<Map<String, Object>> listCategorias;
    private static List<Map<String, Object>> listPlataforma;

    public static Map<String, String> getHeader() {
        return header;
    }

    public static Map<String, Object> getFilmes() {
        return filmes;
    }

    public static Map<String, Object> getCategorias1() {
        return categorias1;
    }

    public static Map<String, Object> getCategorias2() {
        return categorias2;
    }

    public static Map<String, Object> getPlataforma() {
        return plataforma;
    }

    public static List<Map<String, Object>> getListCategorias() {
        return listCategorias;
    }

    public static List<Map<String, Object>> getListPlataforma() {
        return listPlataforma;
    }

    public static void initCategorias(){
        listCategorias = new ArrayList<>();
        categorias1 = new HashMap<>();
        categorias2 = new HashMap<>();

        categorias1.put("tipo", "Ação");
        categorias2.put("tipo", "Comédia");

        listCategorias.add(categorias1);
        listCategorias.add(categorias2);
    }

    public static void initHeader(){
        header = new HashMap<>();
        header.put("Authorization", "Bearer "+LoginMap.token);
    }

    public static void initPlataforma(){
        listPlataforma = new ArrayList<>();

        plataforma = new HashMap<>();
        plataforma.put("nome","Netflix");

        listPlataforma.add(plataforma);
    }

    public static void initFilmes(){
        filmes = new HashMap<>();
        filmes.put("nome","Alerta Vermelho");
        filmes.put("descricao", "Um alerta vermelho da Interpol é emitido e o agente do FBI Jhon Hartley assume o caso." +
                "Durante sua busca, ele se vê diante de um assalto ousado e é forçado a se aliar ao maior de arte da história");
        filmes.put("duracao", 1.35);
        filmes.put("categorias", listCategorias);
        filmes.put("plataformas", listPlataforma);
    }

    public static void initAll(){
        initHeader();
        initCategorias();
        initPlataforma();
        initFilmes();
    }
}
