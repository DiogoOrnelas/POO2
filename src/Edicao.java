
import java.util.*;
import java.io.*;
public class Edicao {

    //Variáveis de instânia
    int ano,z=0, indice = 0;
    int nJurados;
    static int numEdicao=0;
    private Atores VencedorC;
    private Filmes VencedorTerror, VencedorAcao, VencedorAnimacao, VencedorComedia;
    private Filmes VencedorAventura, VencedorFiccaoCie, VencedorRomance, VencedorMusical;
    
    private ArrayList<Filmes> filmes;
    private ArrayList<Atores> atoresT;
    private ArrayList<Atores> atores20;
    private ArrayList<Atores> atores;
    private ArrayList<Atores> atrizes;
    private ArrayList<Filmes> terror;
    private ArrayList<Filmes> comedia;
    private ArrayList<Filmes> acao;
    private ArrayList<Filmes> animacao;
    private ArrayList<Filmes> aventura;
    private ArrayList<Filmes> ficcaoCie;
    private ArrayList<Filmes> romance;
    private ArrayList<Filmes> musical;
    private ArrayList<Filmes> terrorTop;
    private ArrayList<Filmes> comediaTop;
    private ArrayList<Filmes> acaoTop;
    private ArrayList<Filmes> animacaoTop;
    private ArrayList<Filmes> aventuraTop;
    private ArrayList<Filmes> ficcaoCieTop;
    private ArrayList<Filmes> romanceTop;
    private ArrayList<Filmes> musicalTop;
    
    
    //CONSTRUTOR
    public Edicao(int ano){
        criaJurados();
        setEdicao();
        this.ano = ano;
        this.numEdicao = getEdicao();
        atores20 = new ArrayList<>();
        filmes= new ArrayList<>();
        terror= new ArrayList<>();
        comedia= new ArrayList<>();
        acao = new ArrayList<>();
        animacao= new ArrayList<>();
        aventura= new ArrayList<>();
        ficcaoCie= new ArrayList<>();
        romance= new ArrayList<>();
        musical= new ArrayList<>();
        atoresT= new ArrayList<>();
        atores= new ArrayList<>();
        atrizes= new ArrayList<>();
        terrorTop= new ArrayList<>();
        comediaTop= new ArrayList<>();
        acaoTop = new ArrayList<>();
        animacaoTop= new ArrayList<>();
        aventuraTop= new ArrayList<>();
        ficcaoCieTop= new ArrayList<>();
        romanceTop= new ArrayList<>();
        musicalTop= new ArrayList<>();
        
        
    }
    
    //Método para incrementar o número de edição
    public void setEdicao(){
        numEdicao++;
    }
    
    public int getEdicao(){return numEdicao;}
    
    //Método para ver os filmes existentes na edição
    public ArrayList<Filmes> getfilmes(){ return filmes;}
    
    //Método para inserir os filmes na edição
    public void inserirFilme(Filmes filme){
        if (existeFilme(filme.getNome())){
            System.out.println("O nome do filme criado já existe e não será usado na edição");
        }else{
            filmes.add(filme);
        }
    }
    
    //verifica se já existe um filme com o mesmo nome na edição
    public boolean existeFilme(String nome){
        HashSet<String> nomes = new HashSet<String>();
        for (Filmes f1: filmes)
            nomes.add(f1.getNome());
        return nomes.contains(nome);  
    }
    
    //Método para filtrar os atores e atrizes (secundários) com 20 ou mais anos de carreira
    public void anosCarreira(){
        int total = Filmes.getTotalSec();
        Atores ator[] = new Atores[total];
        for (int y=0; y< filmes.size(); y++){        
            for (int l=0; l<filmes.get(y).nSecund ;l++){
               ator[l] = filmes.get(y).secund.get(l);
                int anosCarreira = ator[l].getAnosCarreira();
                    if(anosCarreira>=20)
                        atores20.add(ator[l]);
            }
        }
    }
    
    //Método para escolher os 4 atores nomeados para o prémio carreira
    public void premioCarreira(){
        anosCarreira();
        Random rand =  new Random();
        int [] randoms = new int[4]; 
        int randH = rand.nextInt(atores20.size()+1)-1;    
        if (atores20.size()>=4){
            for (int i = 0; i<4;i++){  
                while (randoms[0]==randH || randoms[1]==randH || randoms[2]==randH || randoms[3]==randH || randH<0){
                    randH = rand.nextInt(atores20.size())-1;
                }
            randoms[i] = randH;
            atoresT.add(atores20.get(randoms[i]));
            atoresT.get(i).setPontuacao(setPontuacaoR());
            }                                       
        }else{
            atoresT=atores20;
            for (int i = 0; i<atoresT.size();i++){
                atoresT.get(i).setPontuacao(setPontuacaoR());
            }
        }
    }
   
    //Método Para escolher o vencedor do prémio carreira        
    public void vencedorCarreira(){
        int melhor = 0;
        for (int i = 0; i<atoresT.size();i++){
            if (atoresT.get(i).getPontuacao()> melhor){
                melhor = atoresT.get(i).getPontuacao();
                VencedorC = atoresT.get(i);
            }
        }
    }
    
    //Método para imprimir o vencedor do premio carreira
    public void imprimeVencedorCarreira(){
        if (VencedorC != null)
            System.out.println("\n O(A) Vencedor(a) do prémio carreira foi: "+ VencedorC); 
        else
            System.out.println("\n Não houve nomeados para o prémio carreira");
    }
    
    //Método para escolher o vencedor em cada categoria
    public void vencedorCategoria(){
        int melhorTerror = 0;
        for (int i = 0; i<terrorTop.size();i++){
            if (terrorTop.get(i).getPontuacaoF()> melhorTerror){
                melhorTerror = terrorTop.get(i).getPontuacaoF();
                VencedorTerror = terrorTop.get(i);
            }
        }
        int melhorComedia = 0;
        for (int i = 0; i<comediaTop.size();i++){
            if (comediaTop.get(i).getPontuacaoF()> melhorComedia){
                melhorComedia = comediaTop.get(i).getPontuacaoF();
                VencedorComedia = comediaTop.get(i);
            }
        }
        int melhorAcao = 0;
        for (int i = 0; i<acaoTop.size();i++){
            if (acaoTop.get(i).getPontuacaoF()> melhorAcao){
                melhorAcao = acaoTop.get(i).getPontuacaoF();
                VencedorAcao = acaoTop.get(i);
            }
        }
        int melhorAnimacao = 0;
        for (int i = 0; i<animacaoTop.size();i++){
            if (animacaoTop.get(i).getPontuacaoF()> melhorAnimacao){
                melhorAnimacao = animacaoTop.get(i).getPontuacaoF();
                VencedorAnimacao = animacaoTop.get(i);
            }
        }
        int melhorAventura = 0;
        for (int i = 0; i<aventuraTop.size();i++){
            if (aventuraTop.get(i).getPontuacaoF()> melhorAventura){
                melhorAventura = aventuraTop.get(i).getPontuacaoF();
                VencedorAventura = aventuraTop.get(i);
            }
        }
        int melhorFiccaoCie = 0;
        for (int i = 0; i<ficcaoCieTop.size();i++){
            if (ficcaoCieTop.get(i).getPontuacaoF()> melhorFiccaoCie){
                melhorFiccaoCie = ficcaoCieTop.get(i).getPontuacaoF();
                VencedorFiccaoCie = ficcaoCieTop.get(i);
            }
        }
        int melhorRomance = 0;
        for (int i = 0; i<romanceTop.size();i++){
            if (romanceTop.get(i).getPontuacaoF()> melhorRomance){
                melhorRomance = romanceTop.get(i).getPontuacaoF();
                VencedorRomance = romanceTop.get(i);
            }
        }
        int melhorMusical = 0;
        for (int i = 0; i<musicalTop.size();i++){
            if (musicalTop.get(i).getPontuacaoF()> melhorMusical){
                melhorMusical = musicalTop.get(i).getPontuacaoF();
                VencedorMusical = musicalTop.get(i);
            }
        }
    }
    
    //Método para imprimir os filmes vencedores
    public void imprimeVencedoresCat(){
        if (VencedorTerror !=null)
            System.out.println("\n O filme vencedor na categoria de Terror foi: "+ VencedorTerror);
        else
            System.out.println("\n Não houve nomeados para melhor filme de Terror");
        
        if (VencedorComedia !=null)
            System.out.println("\n O filme vencedor na categoria de Comedia foi: "+ VencedorComedia);
         else
            System.out.println("\n Não houve nomeados para melhor filme de Comédia");
        
        if (VencedorAcao !=null)
            System.out.println("\n O filme vencedor na categoria de Ação foi: "+ VencedorAcao);
         else
            System.out.println("\n Não houve nomeados para melhor filme de Ação");
        
        if (VencedorAnimacao !=null) 
            System.out.println("\n O filme vencedor na categoria de Animação foi: "+ VencedorAnimacao);
         else
            System.out.println("\n Não houve nomeados para melhor filme de Animação");
        
        if (VencedorAventura !=null)
            System.out.println("\n O filme vencedor na categoria de Aventura foi: "+ VencedorAventura);
         else
            System.out.println("\n Não houve nomeados para melhor filme de Aventura");
        
        if (VencedorFiccaoCie !=null)
            System.out.println("\n O filme vencedor na categoria de Ficção Científica foi: "+ VencedorFiccaoCie);
         else
            System.out.println("\n Não houve nomeados para melhor filme de Ficção Científica");
        
        if (VencedorRomance !=null)
            System.out.println("\n O filme vencedor na categoria de Romance foi: "+ VencedorRomance);
         else
            System.out.println("\n Não houve nomeados para melhor filme de Romance");
        
        if (VencedorMusical !=null)
            System.out.println("\n O filme vencedor na categoria de Musical foi: "+ VencedorMusical);
         else
            System.out.println("\n Não houve nomeados para melhor Musical");
        
        
        
    }
    
    //Método para imprimir os nomeados ao premio carreira
    public void imprimeNomeadosCarreira(){
        if (atoresT.size()>0)
             System.out.println("\n Atores nomeados ao prémio carreira"+atoresT);
        else
            System.out.println("\n Não houve nomeados para o prémio carreira");
    }
    
    //colocar cada ator numa lista dependendo do seu genero
    public void ordenarGeneros(){
            int total = Filmes.getTotalSec();
            Atores ator[] = new Atores[total]; 
            for (int y=0; y< filmes.size(); y++){        
        
                for (int l=0; l<filmes.get(y).nSecund ;l++){
                    ator[l] = filmes.get(y).secund.get(l); 
            
                    String atorGenero = ator[l].getGenero();
                    if(atorGenero.equals("H") || atorGenero.equals("h")){
                        atores.add(filmes.get(y).secund.get(l));
                    }else if(atorGenero.equals("M") || atorGenero.equals("m")){
                        atrizes.add(filmes.get(y).secund.get(l));
                    }     
                }
            }
    }
    
    //imprimir as listas de atores e de atrizes
    public void imprimeGen(){
        if (atores.size() >0){
            System.out.println("\n Atores secundários: ");
            System.out.println(atores +"\n");
        }
        if (atrizes.size() >0){
            System.out.println("\n Atrizes secundárias: ");
            System.out.println(atrizes + "\n");
        }    
    }
    
    //Colocar cada filme participante na edição na sua devida categoria
    public void inserirCat(){
        int b=0, c=0, d=0, e=0, f=0, g=0, j=0, k=0;
        Filmes categoria[] = new Filmes[filmes.size()];
        
        for (z=0; z<filmes.size();z++){
            categoria[z] = filmes.get(z); 
            
            int filmeGenero =categoria[z].getGenero();
         
            if(filmeGenero == 1){
                terror.add(filmes.get(z));

            }else if(filmeGenero == 2){
                comedia.add(filmes.get(z)); 
                
            }else if(filmeGenero == 3){
                acao.add(filmes.get(z));
                
            }else if(filmeGenero == 4){
                animacao.add(filmes.get(z));
                
            }else if(filmeGenero == 5){
                aventura.add(filmes.get(z));
                
            }else if(filmeGenero == 6){
                ficcaoCie.add(filmes.get(z));
                
            }else if(filmeGenero == 7){
                romance.add(filmes.get(z));
                
            }else if(filmeGenero == 8){
                musical.add(filmes.get(z)); 
            }
        }
    }
    
    //imprimir as listas de categorias dos filmes
    public void imprimeCat(){
        if (terror.size() >0){
            System.out.println("\n Terror: ");
            System.out.println(terror);

        }
        if (comedia.size() >0){
            System.out.println("\n Comédia: ");
            System.out.println(comedia);

        }    
        if (acao.size() >0){
            System.out.println("\n Ação: ");
            System.out.println(acao);     

        }    
        if (animacao.size() >0){
            System.out.println("\n Animação: ");
            System.out.println(animacao);

        }    
        if (aventura.size() >0){
            System.out.println("\n Aventura: ");
            System.out.println(aventura);

        }    
        if (ficcaoCie.size() >0){
            System.out.println("\n Ficção Científica: ");
            System.out.println(ficcaoCie);     

        }   
        if (romance.size() >0){
            System.out.println("\n Romance: ");
            System.out.println(romance);

        }    
        if (musical.size() >0){
            System.out.println("\n Musical: ");
            System.out.println(musical);

        }
    }
    
    //Método toString
    public String toString(){      
        String texto;
        texto = "VENCEDORES DA "+ numEdicao+ "º EDIÇÃO";
        if (VencedorTerror!= null)
            texto += "\n -------------- TERROR -------------- \n"+ VencedorTerror+ "\n";
        
        if (VencedorComedia!= null)
         texto += "\n -------------- COMÉDIA -------------- \n"+ VencedorComedia +"\n";
        
        if (VencedorAcao!= null)
            texto += "\n -------------- AÇÃO -------------- \n"+ VencedorAcao+ "\n";
        
        if (VencedorAnimacao!= null)
            texto += "\n -------------- ANIMAÇÃO -------------- \n"+ VencedorAnimacao +"\n";
        
        if (VencedorAventura!= null)
            texto += "\n -------------- AVENTURA -------------- \n"+ VencedorAventura+ "\n";
        
        if (VencedorFiccaoCie!= null)
            texto += "\n -------------- FICÇÃO CIENTÍFICA -------------- \n"+ VencedorFiccaoCie +"\n";
        
        if (VencedorRomance!= null)
            texto += "\n -------------- ROMANCE -------------- \n"+ VencedorRomance+ "\n";
        
        if (VencedorMusical!= null)
            texto += "\n -------------- MUSICAL -------------- \n"+ VencedorMusical +"\n";
        
        texto += "\n";
        
        if (VencedorC!= null)
            texto += "\n -------------------------------------------- \n Vencedor(a) do prémio carreira: \n "+ VencedorC+"\n";
        
        texto += "\n";
        return texto;
    }
    
    //Método para criar o número de jurados da edição
    public void criaJurados(){
        Random rand =  new Random();   
        this.nJurados =rand.nextInt(7)+3; 
    }
    
    //Método para ver o número de jurados da edição
    public int getJurados(){return nJurados;}
    
    //Método para calcular a pontuação de um filme de forma aleatória
    public int setPontuacaoR(){
        Random rand =  new Random();   
        int pontuacao =rand.nextInt(getJurados()*10)+getJurados();
        int media = pontuacao/getJurados();
        return media;                                              
    }                                                              
      
    //Método para escolher quais os quatro filmes que serão postos a votos
    public void escolhePremiados(){
        Random rand =  new Random();
        
        int [] randoms = new int[4];   
        int randT = rand.nextInt(terror.size()+1)-1;    
        int randCom = rand.nextInt(comedia.size()+1)-1;
        int randAc = rand.nextInt(acao.size()+1)-1;
        int randAn = rand.nextInt(animacao.size()+1)-1;                             
        int randAv = rand.nextInt(aventura.size()+1)-1;                                            
        int randFic = rand.nextInt(ficcaoCie.size()+1)-1;                                             
        int randRom = rand.nextInt(romance.size()+1)-1;                           
        int randMu = rand.nextInt(musical.size()+1)-1;                            
        
        if (terror.size()>=4){
            for (int i = 0; i<4;i++){  
                while (randoms[0]==randT || randoms[1]==randT || randoms[2]==randT || randoms[3]==randT || randT<0){
                    randT = rand.nextInt(terror.size())-1;
                }
            randoms[i] = randT;
            terrorTop.add(terror.get(randoms[i]));
            terrorTop.get(i).setPontuacaoF(setPontuacaoR());
            }                                       
        }else{
            terrorTop=terror;
            for (int i = 0; i<terrorTop.size();i++){
                terrorTop.get(i).setPontuacaoF(setPontuacaoR());
            }
        }
        
        if (comedia.size()>=4){
            for (int i = 0; i<4;i++){  
                while (randoms[0]==randCom || randoms[1]==randCom || randoms[2]==randCom || randoms[3]==randCom || randCom<0){
                    randCom = rand.nextInt(comedia.size())-1;
                }
            randoms[i] = randCom;
            comediaTop.add(comedia.get(randoms[i]));
            comediaTop.get(i).setPontuacaoF(setPontuacaoR());
            }
        }else{
            comediaTop = comedia;
            for (int i = 0; i<comediaTop.size();i++){
                comediaTop.get(i).setPontuacaoF(setPontuacaoR());
            }
        }
        
        if (acao.size()>=4){
            for (int i = 0; i<4;i++){  
                while (randoms[0]==randAc || randoms[1]==randAc || randoms[2]==randAc || randoms[3]==randAc || randAc<0){
                    randAc = rand.nextInt(acao.size())-1;
                }
            randoms[i] = randAc; 
            acaoTop.add(acao.get(randAc));
            acaoTop.get(i).setPontuacaoF(setPontuacaoR());           
            }
        }else{
            acaoTop = acao;
            for (int i = 0; i<acaoTop.size();i++){
                acaoTop.get(i).setPontuacaoF(setPontuacaoR());
            }
        }        
        
        if (animacao.size()>=4){
            for (int i = 0; i<4;i++){  
                while (randoms[0]==randAn || randoms[1]==randAn || randoms[2]==randAn || randoms[3]==randAn|| randAn<0){
                    randAn = rand.nextInt(animacao.size())-1;
                }
            randoms[i] = randAn; 
            animacaoTop.add(animacao.get(randoms[i]));   
            animacaoTop.get(i).setPontuacaoF(setPontuacaoR());
            }
        }else{
            animacaoTop = animacao;
            for (int i = 0; i<animacaoTop.size();i++){
                animacaoTop.get(i).setPontuacaoF(setPontuacaoR());
            }
        }
        
        if (aventura.size()>=4){
            for (int i = 0; i<4;i++){  
                while (randoms[0]==randAv || randoms[1]==randAv || randoms[2]==randAv || randoms[3]==randAv || randAv<0){
                    randAv = rand.nextInt(aventura.size())-1;
                }
            randoms[i] = randAv; 
            aventuraTop.add(aventura.get(randoms[i]));   
            aventuraTop.get(i).setPontuacaoF(setPontuacaoR());
            }
        }else{
            aventuraTop = aventura;
            for (int i = 0; i<aventuraTop.size();i++){
                aventuraTop.get(i).setPontuacaoF(setPontuacaoR());
            }
        }        
           
        if (ficcaoCie.size()>=4){
            for (int i = 0; i<4;i++){  
                while (randoms[0]==randFic || randoms[1]==randFic || randoms[2]==randFic || randoms[3]==randFic || randFic<0){
                    randFic = rand.nextInt(ficcaoCie.size())-1;
                }
            randoms[i] = randFic;
            ficcaoCieTop.add(ficcaoCie.get(randoms[i]));  
            ficcaoCieTop.get(i).setPontuacaoF(setPontuacaoR());
            }
        }else{
            ficcaoCieTop = ficcaoCie;
            for (int i = 0; i<ficcaoCieTop.size();i++){
                ficcaoCieTop.get(i).setPontuacaoF(setPontuacaoR());
            }
        }
        
        if (romance.size()>=4){
            for (int i = 0; i<4;i++){  
                while (randoms[0]==randRom || randoms[1]==randRom || randoms[2]==randRom || randoms[3]==randRom || randRom<0){
                    randRom = rand.nextInt(romance.size())-1;
                }
                randoms[i] = randRom; 
                romanceTop.add(romance.get(randoms[i]));  
                romanceTop.get(i).setPontuacaoF(setPontuacaoR());
            }
        }else{
            romanceTop = romance;
            for (int i = 0; i<romanceTop.size();i++){
                romanceTop.get(i).setPontuacaoF(setPontuacaoR());
            }
        }
        
        if (musical.size()>=4){
            for (int i = 0; i<4;i++){  
                while (randoms[0]==randMu || randoms[1]==randMu || randoms[2]==randMu || randoms[3]==randMu || randMu<0){
                    randMu = rand.nextInt(musical.size())-1;
                }
                randoms[i] = randMu; 
                musicalTop.add(musical.get(randoms[i])); 
                musicalTop.get(i).setPontuacaoF(setPontuacaoR());
            }
        }else{
            musicalTop = musical;
            for (int i = 0; i<musicalTop.size();i++){
                musicalTop.get(i).setPontuacaoF(setPontuacaoR());
            }
        }
        
    }
    
    //Método para imprimir os filmes premiados em cada categoria
    public void imprimePremiados(){  
        if (terrorTop.size()>0){
            System.out.println("\n Top 4 em Terror: ");
            System.out.println(terrorTop);
        }
        if (comediaTop.size()>0){
            System.out.println("\nTop 4 em Comédia: ");
            System.out.println(comediaTop); 
        }
        if (acaoTop.size()>0){
            System.out.println("\n Top 4 em Ação: ");
            System.out.println(acaoTop); 
        }
        if (animacaoTop.size()>0){
            System.out.println("\n Top 4 em Animação: ");
            System.out.println(animacaoTop); 
        }
        if (aventuraTop.size()>0){
            System.out.println("\n Top 4 em Aventura: ");
            System.out.println(aventuraTop); 
        }
        if (ficcaoCieTop.size()>0){
            System.out.println("\n Top 4 em Ficção científica: ");
            System.out.println(ficcaoCieTop); 
        }
        if (romanceTop.size()>0){
            System.out.println("\n Top 4 em Romance: ");
            System.out.println(romanceTop); 
        }
        if (musicalTop.size()>0){
            System.out.println("\n Top 4 em Musical: ");
            System.out.println(musicalTop); 
        }

    }
    
    public void guardaEdicao(){
        FileWriter fw = null;
        BufferedWriter bW = null;
            
        try{
            File file = new File("Edição "+numEdicao+".txt"); 
            
            if (!file.exists()){
                file.createNewFile();  
            }
            fw = new FileWriter (file.getAbsoluteFile(), true);
            bW = new BufferedWriter(fw);
            
            bW.write(toString());
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
    
    //Método para adicionar à edição todos os filmes criados previamente num bloco de notas
    public void importaFilmes(){
        String nome, realizador, genero;
        int carreira,generof, nSecund;
         try{
            FileReader inStream = new FileReader("FilmesTeste.txt");
            BufferedReader bR = new BufferedReader(inStream);
            String linha = bR.readLine();
            
            
            while(linha != null){
                nome = linha;
                linha = bR.readLine();
                
                generof = Integer.valueOf(linha);
                linha = bR.readLine();
                
                realizador =linha;
                linha = bR.readLine();
                
                nSecund = Integer.valueOf(linha);
                linha = bR.readLine();
                
                linha = bR.readLine();
                
                Filmes f1 = new Filmes(nome, generof, realizador, nSecund);
                importaAtores(f1);
                inserirFilme(f1);
            }
            bR.close();                    
        }
        catch(IOException ioe){
            System.out.println("Ocorreu um erro!");
        }
    }
    
    //Método para adicionar à edição os atores criados num bloco de notas
    private void importaAtores(Filmes f1){
        int X=0;
        String nome, genero;
        int carreira;
        try{
            
            FileReader inStream2 = new FileReader("AtoresTeste.txt");
            BufferedReader bR2 = new BufferedReader(inStream2);
            String linha2 = bR2.readLine();
            
            while(X< Filmes.getTotalSec()){
                linha2 = bR2.readLine();
                linha2 = bR2.readLine();
                linha2 = bR2.readLine();
                linha2 = bR2.readLine();
                X++;
            } 
            int i=0;
            while(i != f1.nSecund && linha2 != null){
                nome = linha2;
                linha2 = bR2.readLine();

                carreira = Integer.valueOf(linha2);
                linha2 = bR2.readLine();

                genero = linha2;
                linha2 = bR2.readLine();

                linha2 = bR2.readLine();

                Atores a1 = new Atores (nome,carreira,genero);
                a1.atorFilme(f1.getNome());
                f1.maisSecund(a1); 
                i++;
            }
            bR2.close();
        }catch(IOException ioe){
            System.out.println("Ocorreu um erro!");
        }
    }
}