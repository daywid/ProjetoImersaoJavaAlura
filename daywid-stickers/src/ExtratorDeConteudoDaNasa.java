import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo{

     public List<Conteudo> extraiConteudos(String json){

    //extrair só os dados que interessam (título, poster, classificação).
    var Parser = new JsonParser();
    List<Map<String, String>> ListaDeAtributos = Parser.parse(json);

    List<Conteudo> conteudos = new ArrayList<>();

    //popular a lista de conteudos
    for (Map<String, String> atributos : ListaDeAtributos) {
        String titulo = atributos.get("title");
        String urlImagem = atributos.get("url");
        var conteudo = new Conteudo(titulo, urlImagem);

        conteudos.add(conteudo);
    }

    return conteudos;
     }

}
