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
    static int quantidade, ID, tipo;
    static String nome, marca, categoria;
    static float preco, peso, ml;

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
                    out.println("\n\nCriar Produtos:\n");
                    cadastrarProdutos();
                    keyPress();
                }
                case 2 -> {
                    out.println("\n\nListar todos os Produtos\n");
                    produtos.listarProdutos();
                    keyPress();
                }
                case 3 -> {
                    out.println("\n\nBuscar por produto\n");
                    procurarPorID();
                    keyPress();
                }
                case 4 -> {
                    out.println("\n\nAtualizar dados do produto\n");
                    atualizarProduto();
                    keyPress();
                }
                case 5 -> {
                    out.println("\n\nApagar produto\n");
                    deletarProduto();
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
        do {
            out.print("Digite a opção do tipo de produto [1]Alimento [2]Bebida: ");
            tipo = entrada.nextInt();
        } while (tipo < 1 && tipo > 2);

        out.print("Nome do produto: ");
        entrada.skip("\\R?");
        nome = entrada.nextLine();
        out.print("Quantidade do produto(UN): ");
        quantidade = entrada.nextInt();
        out.print("Valor do produto(UN): ");
        preco = entrada.nextFloat();
        out.print("Marca do produto: ");
        entrada.skip("\\R?");
        marca = entrada.nextLine();
        out.print("Categoria do produto: ");
        entrada.skip("\\R?");
        categoria = entrada.nextLine();

        switch (tipo) {
            case 1 -> {
                out.print("Peso do produto(UN): ");
                peso = entrada.nextFloat();
                produtos.cadastrarProduto(new ProdutoAlimento(1, nome, marca, categoria, produtos.GerarIDProduto(), quantidade, preco, peso));
            }
            case 2 -> {
                out.print("Capacidade do produto(ML): ");
                ml = entrada.nextFloat();
                produtos.cadastrarProduto(new ProdutoBebida(2, nome, marca, categoria, produtos.GerarIDProduto(), quantidade, preco, ml));
            }
        }
    }

    public static void procurarPorID() {
        out.print("Digite o ID do produto: ");
        ID = entrada.nextInt();
        produtos.procurarProduto(ID);
    }

    public static void atualizarProduto() {
        out.print("Digite o ID do produto: ");
        ID = entrada.nextInt();

        if (produtos.buscarNaCollection(ID) != null) {
            out.print("Nome do produto: ");
            entrada.skip("\\R?");
            nome = entrada.nextLine();
            out.print("Quantidade do produto(UN): ");
            quantidade = entrada.nextInt();
            out.print("Valor do produto(UN): ");
            preco = entrada.nextFloat();
            out.print("Marca do produto: ");
            entrada.skip("\\R?");
            marca = entrada.nextLine();
            out.print("Categoria do produto: ");
            entrada.skip("\\R?");
            categoria = entrada.nextLine();
            tipo = produtos.retornaTipo(ID);

            switch (tipo) {
                case 1 -> {
                    out.print("Peso do produto(UN): ");
                    peso = entrada.nextFloat();
                    produtos.atualizarProduto(new ProdutoAlimento(1, nome, marca, categoria, ID, quantidade, preco, peso));
                }
                case 2 -> {
                    out.print("Capacidade do produto(ML): ");
                    ml = entrada.nextFloat();
                    produtos.cadastrarProduto(new ProdutoBebida(2, nome, marca, categoria, ID, quantidade, preco, ml));
                }
            }
        }
    }

    public static void deletarProduto() {
        out.print("Digite o ID do produto: ");
        ID = entrada.nextInt();
        produtos.deletarProduto(ID);
    }

    public static void keyPress() {
        try {
            out.println("\n\nPressione Enter para continuar...");
            System.in.read();
        } catch (IOException e) {
            out.println("Você pressionou uma tecla errada.");
        }
    }
}