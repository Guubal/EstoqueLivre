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

        //PARA TESTES:
        produtos.cadastrarProduto(new ProdutoAlimento(1, "Arroz", "Camil", "Não Perecivel", produtos.GerarIDProduto(), 10, 17, 15));

        produtos.cadastrarProduto(new ProdutoBebida(1, "Coca-Cola", "Coca-Cola", "Refrigerante", produtos.GerarIDProduto(), 8, 9, 2000));
        clearConsole();
        while (true) {
            out.println("\n" + "*".repeat(40));
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
            clearConsole();
            switch (opcao) {
                case 1 -> {
                    centerText("CADASTRAR PRODUTO");
                    cadastrarProdutos();
                    clearConsole();
                }
                case 2 -> {
                    out.println("\n\nListar todos os Produtos");
                    produtos.listarProdutos();
                    keyPress();
                    clearConsole();
                }
                case 3 -> {
                    out.println("\n\nBuscar por produto");
                    procurarPorID();
                    keyPress();
                    clearConsole();
                }
                case 4 -> {
                    out.println("\n\nAtualizar dados do produto");
                    atualizarProduto();
                    keyPress();
                    clearConsole();
                }
                case 5 -> {
                    out.println("\n\nApagar produto");
                    deletarProduto();
                    keyPress();
                    clearConsole();
                }
                case 6 -> {
                    out.println("\nObrigado!");
                    entrada.close();
                    System.exit(0);
                }
                default -> {
                    out.println("\nOpção Inválida!\n");
                    keyPress();
                    clearConsole();
                }

            }

        }
    }

    public static void cadastrarProdutos() {
        do {
            out.println("=".repeat(40));
            out.printf("%6d %-3s %s \n", 1, " ", "ALIMENTO");
            out.printf("%6d %-3s %s \n", 2, " ", "BEBIDA");
            out.printf("%6d %-3s %s \n", 3, " ", "VOLTAR");
            out.println("=".repeat(40));

            out.print("Digite uma opção: ");
            tipo = entrada.nextInt();

        } while (tipo < 1 && tipo > 2);
        if (tipo != 3) {
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
            keyPress();
        }
    }

    public static void procurarPorID() {
        out.print("Digite o ID do produto: ");
        ID = entrada.nextInt();
        produtos.procurarProduto(ID);
    }

    public static void atualizarProduto() {
        int opc;
        out.print("Digete o ID do produto: ");
        ID = entrada.nextInt();
        produtos.listarProdutosAtualizar(ID);

        out.print("Digete a opcão que deseja alterar: ");
        opc = entrada.nextInt();

        if (produtos.buscarNaCollection(ID) != null) {
            out.print("Nome do produto: ");
            entrada.skip("\\R?");
            nome = entrada.nextLine();
            out.print("Valor do produto(UN): ");
            preco = entrada.nextFloat();
            out.print("Quantidade do produto(UN): ");
            quantidade = entrada.nextInt();
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

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

    public static void centerText(String txt) {
        int qnt = 20 - txt.length() / 2;
        String e = "";
        for (int i = 0; i < qnt; i++) {
            e += " ";
        }
        out.println("\n");
        out.println(e + txt);
    }
}