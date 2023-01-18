
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.out;

import controller.ProdutoController;
import model.ProdutoAlimento;
import model.ProdutoBebida;

public class Menu {
    static ProdutoController produtos = new ProdutoController();
    static Scanner entrada = new Scanner(System.in);
    static int quantidade;
    static String nome;
    static String marca;
    static String categoria;
    static float preco;
    static float peso;
    static float ml;
    public static void main(String[] args) {

        String selectors[] = {"Cadastrar", "Listar produtos", "Buscar Produto", "Atualizar produto", "Apagar produto", "Sair"};
        int opcao;


        while (true) {
            out.println("*".repeat(40));
            out.printf("%-10s  %s \n", "", "ESTOQUE LIVRE");
            out.println("*".repeat(40));

            for (int c = 0; c < selectors.length; c++) {
                out.printf("%9d %-3s %s \n", c + 1, " ", selectors[c]);
            }

            out.println("*".repeat(40));
            out.print("Digite uma opcão: ");
            try {
                opcao = entrada.nextInt();
            } catch (InputMismatchException e) {
                out.print("Digite um valor inteiro: ");
                entrada.nextInt();
                opcao = 0;
            }

            switch (opcao) {
                case 1 -> {
                    cadastrarProdutos();
                    keyPress();
                }
                case 2 -> {
                    out.println("Listar todos os Produtos\n\n");
                    produtos.listarProdutos();
                    keyPress();
                }
                case 3 -> {
                    out.println("Buscar por produto\n\n");
                    keyPress();
                }
                case 4 -> {
                    out.println("Atualizar dados do produto\n\n");
                    keyPress();
                }
                case 5 ->{
                    out.println("Apagar produto\n\n");
                    keyPress();
                }
                case 6 -> {
                    out.println("\nObrigado!");
                    entrada.close();
                    System.exit(0);
                }
                default -> {
                    out.println("\nOpção Inválida!\n");
                    keyPress();
                }

            }

        }
    }

    public static void cadastrarProdutos() {
        int tipo;
        out.println("Criar Produtos:\n\n");
        do{
            out.print("Digite a opção do tipo de produto [1]Alimento [2]Bebida: ");
            tipo = entrada.nextInt();
        }while (tipo < 1 && tipo > 2);

        out.print("Digite o nome do produto: ");
        nome = entrada.next();
        entrada.nextLine();
        out.print("Digite a quantidade do produto: ");
        quantidade = entrada.nextInt();
        out.print("Digite o valor do produto: R$");
        preco = entrada.nextFloat();
        out.print("Digite a Marca do produto: (NAO USAR ESPACOS POR ENQUANTO)");
        marca = entrada.next();
        entrada.nextLine();
        out.print("Digite a categoria do produto: (NAO USAR ESPACOS POR ENQUANTO)");
        categoria = entrada.next();
        entrada.nextLine();

        switch (tipo){
            case 1 -> {
                out.print("Digite o peso do produto: ");
                peso = entrada.nextFloat();
                produtos.cadastrarProduto(new ProdutoAlimento(nome,marca,categoria,produtos.GerarIDProduto(),quantidade,preco,peso));
            }
            case 2 -> {
                out.print("Digite a litragem do produto: ");
                ml = entrada.nextFloat();
                produtos.cadastrarProduto(new ProdutoBebida(nome,marca,categoria,produtos.GerarIDProduto(),quantidade,preco,ml));
            }
        }
    }

    public static void keyPress(){
        try {
            out.println("\n\nPressione Enter para continuar...");
            System.in.read();
        } catch (IOException e) {
            out.println("Você pressionou uma tecla errada.");
        }
    }
}