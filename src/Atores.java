
import java.util.*;

public class Atores {
    
    private String nome;
    private int anosCar;
    private String genero;
    private TreeSet<String> filmes;
    int pontuacao;

        

    //Construtor
    public Atores(String nome,int anosCar,String genero){
        this.nome = nome;
        this.anosCar = anosCar;
        this.genero = genero;
        filmes = new TreeSet<>();
        this.pontuacao =0;
    }
    //Métodos get
    public String getNome(){return nome;}
    public int getAnosCarreira(){return anosCar;}
    public String getGenero(){return genero;}
    public TreeSet<String> getFilmes(){return filmes;}
    public int getPontuacao(){return pontuacao;}
    
    //Método para alterar a pontuação do filme
    public void setPontuacao(int pontuacao){
        this.pontuacao= pontuacao;
    }
    
    public void atorFilme(String novoFilme){
        if (filmes.size()<2)
            filmes.add(novoFilme);
    }
    
    //Adicionar um filme à lista de filmes do ator
    public boolean atorEm(String filme){
        return filmes.contains(filme);
    }
    
    //Método toString de Ator
    public String toString(){
        String texto;
        texto ="Nome: " +nome+ ", Anos de carreira: " +anosCar+ ", Genero: " +genero+ " ";
        //texto += "Participa em: \n"+filmes;
        return texto;
    }
}
