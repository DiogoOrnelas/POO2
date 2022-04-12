
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int limite = 0, limiteb = 0, vez = 0;
        int opcaoa;
        int opcaob;           
        int opcaoy;
       
        
        do{
            opcaoy = inicioPrograma();
            switch (opcaoy){
                case 1:
                    Edicao ed1 = criarEdicao();          //Criamos a primeira Edição!
                    do{
                        //Pela primeira vez a executar o programa temos o menu de boas vindas
                        if (vez == 0){  
                            opcaoa = bemVindo(ed1);
                            vez = 1;
                        }else{
                        //Depois de escolhida a primeira opção temos um outro menu disponível
                            opcaoa = menuPrincipal();

                        }
                        switch(opcaoa){
                            case 1:
                                //Estamos a criar um filme
                                Filmes f2=criarFilme();
                                do{
                                    //Decidir o que fazer asseguir, criar ator principal secundario e guardar o filme na edição
                                    //O filme criado pode nao ser incluido na edição caso o utilizador não escolha a terceira opção
                                    opcaob= menuAtores(f2);

                                    switch(opcaob){
                                        case 1:
                                            //Criar um ator principal para o filme em questão
                                            criarAtorPrincipal(f2);
                                            break;
                                        case 2:
                                            //Criar um ator secundário para o filme em questão
                                            criarAtoresSecundarios (f2);
                                            break;
                                        case 3:
                                            //Guardar o filme na edição de modo a que este possa estar incluido nos prémios, senão será ignorado
                                            ed1.inserirFilme(f2);
                                            break;
                                    }                       
                                }
                                while ((opcaob > 0) && (opcaob<4)); 
                                break;
                            case 2:
                                //Importamos para a edição todos os filmes e atores criados préviamente num bloco de notas
                                ed1.importaFilmes();
                                break;
                            case 3:
                                //A primeira vez a esolher a opção 3, são executados todos estes metodos
                                if(limite == 0){
                                    ed1.ordenarGeneros();        //Ordenamos os géneros dos atores secundários introduzidos na edição, Atores e Atrizes
                                    ed1.inserirCat();            //Inserimos cada um dos filmes na edição na sua devida categoria por forma a poderem estar a prémio
                                    ed1.escolhePremiados();      //De entre todos os filmes de uma categoria escolhemos 4 para serem os nomeados, atribuindo uma pontuação aleatória a cada um
                                    ed1.premioCarreira();        //De entre todos os Atores e Atrizes com 20 ou mais anos de carreira escolhemos 4, atribuindo uma pontuação aleatória a cada um
                                    ed1.vencedorCategoria();     //O filme de cada categoria com maior pontuação será o vencedor dessa mesma categoria
                                    ed1.vencedorCarreira();      //O ator ou atriz nomeado, que tiver a maior pontuação será o vencedor do prémio carreira
                                    limite = 1;
                                    break;                                    
                                //Na segunda vez nenhum dos métodos é executado e aparece uma mensagem de "erro" a dizer que já foram escolhidos os nomeados e vencedores
                                }else{
                                    System.out.println("Os Nomeados já foram escolhidos, e já temos vencedores");
                                }
                                break;
                            case 4:
                                ed1.imprimeGen();                    //Imprimimos a lista de atores e a lista de atrizes que participam na edição
                                ed1.imprimePremiados();              //Imprimimos os nomeados filmes nomeados (até 4) em cada categoria
                                ed1.imprimeNomeadosCarreira();       //Imprimimos os atores e atrizes nomeados para o prémio carreira
                                break;  
                            case 5:
                                ed1.imprimeVencedoresCat();          //Imprimimos os filmes vencedores em cada categoria
                                ed1.imprimeVencedorCarreira();       //Imprimimos o Ator ou Atriz vencedor(a) do prémio carreira
                                break;
                            case 6:
                                if(limiteb == 0){
                                    ed1.guardaEdicao();             //Guardamos a edição num bloco de notas, registando os vencedores apenas
                                    limiteb =1;
                                }else{
                                    System.out.println("A edição já foi guardada");   //Caso a Edição já tenha sido guardada aparece um aviso e não é guardada novamente
                                } 
                                break;
                        }                              
                    }
                    while ((opcaoa > 0) && (opcaoa<7));
                    vez =0;
                    limiteb =0;
                    limite =0;
                    break;
            }
        }
        while((opcaoy >0) && (opcaoy<2));
    }
    
    
    
    
    
    public static int inicioPrograma(){
        Scanner scan = new Scanner(System.in);
        int opcaoy = 0;
        System.out.println("-------------------------------------------------------------");
        System.out.println("1- Criar uma nova edição");
        System.out.println("2- Sair do programa");
        System.out.println();
        System.out.print("Insira a sua opção:  ");
        opcaoy = scan.nextInt();
        System.out.println();
        System.out.println("-------------------------------------------------------------");
        scan.nextLine();
        return opcaoy ;
    }
    
    
    
        //Método para criar uma nova edição
    public static Edicao criarEdicao(){
        Edicao ed1 = new Edicao(2020);
        return ed1;
    }
    
    //Método para criar um filme novo
    public static Filmes criarFilme(){
        Scanner scan = new Scanner(System.in);
        String nome, realizador;
        int generof;
        int secund;
        System.out.println("-------------------------------------------------------------");
        System.out.print("Insira o nome do filme:  ");
        nome = scan.nextLine();
        generof =filmeGenero();
        System.out.print("Insira o nome do realizador:  ");
        realizador = scan.nextLine();
        System.out.print("Insira o número de atores secundários ('0' se não existirem secundários):  ");
        secund = scan.nextInt();
        System.out.println("-------------------------------------------------------------");
        Filmes f2 = new Filmes (nome,generof, realizador, secund);
        System.out.println();
        return f2;
    }
    
    //Método para criar o ator principal
    public static void criarAtorPrincipal(Filmes f2){
        Scanner scan = new Scanner(System.in);
        String nome, genero;
        int carreira;
        System.out.println("-------------------------------------------------------------");
        System.out.print("Insira o nome do ator: ");
        nome = scan.nextLine();
       
        System.out.print("Insira o genero do ator  (M- Mulher, H- Homem): ");
        genero = scan.nextLine();
        System.out.print("Insira o numero de anos de carreira do ator: ");
        carreira = scan.nextInt();
     
        scan.nextLine();
        System.out.println("-------------------------------------------------------------");
        Atores ator = new Atores (nome,carreira,genero);
        ator.atorFilme(f2.getNome());
        f2.maisPrinc(ator);
        System.out.println(f2);
    }
    
    //Método para criar os atores secundários
    public static void criarAtoresSecundarios (Filmes f2){
        Scanner scan = new Scanner(System.in);
        String nome, genero;
        int carreira,U=0;
        while (U <f2.nSecund){
            System.out.println("-------------------------------------------------------------");
            System.out.print("Insira o nome do ator; ");
            nome = scan.nextLine();
            System.out.print("Insira o genero do ator  (M- Mulher, H- Homem): ");
            genero = scan.nextLine();
            System.out.print("Insira o numero de anos de carreira do ator; ");
            carreira = scan.nextInt();
            System.out.println("-------------------------------------------------------------");
            scan.nextLine();
            Atores ator3 = new Atores (nome,carreira,genero);
            ator3.atorFilme(f2.getNome());
            f2.maisSecund(ator3);    
            System.out.println();
            U++;
            }
        U=0;
    }
    
    //Método para mostrar o menu de boas vindas
    public static int bemVindo(Edicao ed1){
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        System.out.println("Bem vindo à "+ ed1.numEdicao+ "ª edição do festival de cinema");
        System.out.println("-------------------------------------------------------------");
        System.out.println("1- Inserir um filme");
        System.out.println("2- Importar filmes e atores");
        System.out.println("7- Sair do programa");
        System.out.println();
        System.out.print("Insira a sua opção:  ");
        opcao = scan.nextInt();
        System.out.println();
        System.out.println("-------------------------------------------------------------");
        scan.nextLine();
        return opcao;
    }
    //Método para mostrar o menu principal
    public static int menuPrincipal(){
        Scanner scan = new Scanner(System.in);
        int opcaoa = 0;
        System.out.println("-------------------------------------------------------------");
        System.out.println("1- Inserir outro filme");
        System.out.println("2- Importar filmes e atores");
        System.out.println("3- Escolher os Filmes e atores premiados");
        System.out.println("4- Imprimir os nomeados em cada categoria");
        System.out.println("5- Imprimir os vencedores em cada categoria");
        System.out.println("6- Guardar a edição num ficheiro de texto");
        System.out.println("7- Sair do programa");
        System.out.println();
        System.out.print("Insira a sua opção:  ");
        opcaoa = scan.nextInt();
        System.out.println();
        System.out.println("-------------------------------------------------------------");
        scan.nextLine();
        return opcaoa;
    }
    
    //Método mostrar o menu para criação de atores
    public static int menuAtores(Filmes f1){
        Scanner scan = new Scanner(System.in);
        int opcaob = 0;
        System.out.println("-------------------------------------------------------------");
        System.out.println("1- Inserir um ator principal: ");
        if (f1.nSecund>0)
            System.out.println("2- Inserir um ator secundário:");
        System.out.println("3- Guardar o filme criado na edição:");
        System.out.println("4- Voltar ao menu");
        System.out.println();
        System.out.print("Insira a sua opção: ");
        opcaob = scan.nextInt();
        System.out.println(); 
        System.out.println("-------------------------------------------------------------");
        scan.nextLine();
        return opcaob;
    }
    
    public static int filmeGenero(){
        Scanner scan = new Scanner(System.in);
        int opcaoc = 0;
        System.out.print("Escolha o genero de filme; \n");
        System.out.print("1- Terror; ");
        System.out.print("2- Comédia; ");
        System.out.print("3- Ação; ");
        System.out.print("4- Animação; \n");
        System.out.print("5- Aventura; ");
        System.out.print("6- Ficção Científica; ");
        System.out.print("7- Romance; ");
        System.out.print("8- Músical; ");
        System.out.println("9- Sair da seleçao de genero");
        opcaoc = scan.nextInt();
        System.out.println();              
        scan.nextLine();
        return opcaoc;
    }
}
