
import java.util.Scanner;
import static java.lang.System.out;

public class Menu {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String selectors[] = {"Cadastrar", "Listar produtos", "Buscar Produto", "Atualizar produto", "Apagar produto","Sair"};
        int opcao;

        while (true) {
            out.println("*".repeat(40));
            out.printf("%-10s  %s \n", "", "ESTOQUE LIVRE");
            out.println("*".repeat(40));

            for (int c = 0; c < selectors.length; c++) {
                out.printf("%9d %-3s %s \n", c + 1, " ", selectors[c]);
            }

            out.println("*".repeat(40));

            out.print("Digite uma opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    out.println("Cadastrar novo produto\n\n");

                    break;
                case 2:
                    out.println("Listar todos os Produtos\n\n");

                    break;
                case 3:
                    out.println("Buscar por produto\n\n");

                    break;
                case 4:
                    out.println("Atualizar dados do produto\n\n");

                    break;
                case 5:
                    out.println("Apagar produto\n\n");

                    break;
                case 6:
                    out.println("\nObrigado!");
                    entrada.close();
                    System.exit(0);
                    break;
                default:
                    out.println("\nOpção Inválida!\n");

                    break;
            }

        }

    }

}