import java.util.*;
import java.io.*;

public class Filmes {
    
   //Variáveis de instânia
    private String nome, realizador;
    int nSecund;
    private int generof, pontuacaof;
    ArrayList<Atores> secund;
    private ArrayList<Atores> principal;
    static int totalSec=0;
    
    //Construtor de filmes
    public Filmes(String nome, int genero, String realizador, int nSecund){
        this.nome = nome;
        this.generof = genero;
        this.realizador = realizador;
        this.nSecund = nSecund;
        secund = new ArrayList<>();
        principal = new ArrayList<>();
    }
    
    //Métodos get
    public String getNome(){ return nome;}
    public int getGenero(){ return generof;}
    public int getnSecund(){ return nSecund;}
    public String getRealizador(){ return realizador;}
    public int getPontuacaoF(){ return pontuacaof;}
    public ArrayList<Atores> getAtoresSec(){ return secund;}
    public ArrayList<Atores> getAtorPrincipal(){ return principal;}
    
    //Método para alterar a pontuação do filme
    public void setPontuacaoF(int pontuacao){
        this.pontuacaof= pontuacao;
    }
    
    //Método para inserir atores principais num filme (APENAS SE O NOME NÂO EXISTIR)
    public void maisSecund(Atores ator){
        if (existeAtorS(ator.getNome())== false && existeAtorP(ator.getNome())== false) {
            if (secund.size()<nSecund){
                secund.add(ator);
                addSec();
            }
        }
    }

    
    public void addSec(){
        totalSec++;
    }
    
    
    public static int getTotalSec(){
        return totalSec;
    }
    
    
    //Método para inserir atores principais num filme (APENAS SE O NOME NÂO EXISTIR E NÃO HOUVER MAIS NENUM ATOR PRINCIPAL)
    public void maisPrinc(Atores ator){
        if (existeAtorS(ator.getNome())== false && existeAtorP(ator.getNome())== false)
            if (principal.size()<1)
                principal.add(ator);
            else if (!ator.getGenero().equals(principal.get(0).getGenero())&& principal.size()<2){
                principal.add(ator);
            }else if(ator.getGenero().equals(principal.get(0).getGenero())){
                System.out.println("O limite de atores/atrizes principais do mesmo genero já foi atingido");
            }else if (principal.size()>1){
                 System.out.println("Já existem um ator e uma atriz pricipal");
            }
    }
    
    public TreeSet<String> nomes(){
        TreeSet<String> atores = new TreeSet<String>();
        for (Atores a1: secund)
            atores.add(a1.getNome());
        return atores;
    }
    
    //Método para verificar se já existe um nome de um ator num dado filme
    public boolean existeAtorS(String nome){
        HashSet<String> ator = new HashSet<String>();
        for (Atores a1: secund)
            ator.add(a1.getNome());
        return ator.contains(nome);  
    }
    
    //Método para verificar se já existe um ator principal num dado filme
    public boolean existeAtorP(String nome){
        HashSet<String> ator = new HashSet<String>();
        for (Atores a1: principal)
            ator.add(a1.getNome());
        return ator.contains(nome); 
    }
   
    //Método para guardar os filmes criados num ficheiro de texto
    public void guardaFilmes(Filmes filme){
        FileWriter fw = null;
        BufferedWriter bW = null;
            
        try{
            File file = new File("Filmes.txt");
                
            if (!file.exists()){
                file.createNewFile();
            }
            fw = new FileWriter (file.getAbsoluteFile(), true);
            bW = new BufferedWriter(fw);
            
            bW.write(filme.toString());
            bW.newLine();
        }
        catch(IOException ioe){
            System.out.println("Ocorreu um erro|");
        }finally{
            try{
                if (bW != null)
                    bW.close();
                if (fw != null)
                    fw.close();    
                
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        
    }
    
    //Método toString de filme
    public String toString(){
        String texto;
        texto = "\nFilme: "+nome+ "\n";
        texto += "Pontuação: "+ pontuacaof +"\n";
        texto += "Género: " + generof +"\n";
        texto += "Realizado por: "+realizador +"\n";
        texto += "Tem como ator principal: ";
        for (Atores a1: principal)
            texto += a1.toString() +"     ";
        texto += "\nParticipam: ";
        for (Atores a1: secund)
            texto += a1.toString() +"     ";
        return texto;
    }           
}
