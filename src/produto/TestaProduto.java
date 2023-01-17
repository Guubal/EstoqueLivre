package produto;
import static java.lang.System.out;

public class TestaProduto {
    public static void main(String[] args) {
        Alimento alimento = new Alimento("Arroz", "Camil", "Nao Perecivel",1,10,27, 10);

        Bebida bebida = new Bebida("Fanta", "CocaCola", "Perecivel",2,15,7, 2000);

        alimento.Visualizar();

        bebida.Visualizar();
    }
}
