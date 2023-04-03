import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
public class GeradoraDeFigurinhas {
  
    public void cria(InputStream inputStream, String nomeArquivo) throws IOException{

        //leitura da imagem.
        //InputStream inputStream = new FileInputStream("entrada/Filme.jpg")
        //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_7.jpg").openStream();
        BufferedImage ImagemOriginal = ImageIO.read(inputStream);

        //cria nova imagem em memória com transparência e com tamanho novo.
        int largura = ImagemOriginal.getWidth() ;
        int altura = ImagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original pra nova imagem (em memória).
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(ImagemOriginal, 0, 0, null);
        
        //configurar a fonte;
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 128);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem.
        graphics.drawString("TOPZERA", 100 , novaAltura - 50);
        
        //escrever a imagem nova em um arquivo.
        ImageIO.write(novaImagem, "png", new File("saida",nomeArquivo));

    }
   
}
