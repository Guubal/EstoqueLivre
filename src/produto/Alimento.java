package produto;
import static java.lang.System.out;
public class Alimento extends Produto {
    float pesoAlimento;

    public Alimento(String nomeProduto, String marcaProduto, String categoriaProduto, int codProduto, int quantidadeProduto, float precoProduto, float pesoAlimento) {
        super(nomeProduto, marcaProduto, categoriaProduto, codProduto, quantidadeProduto, precoProduto);
        this.pesoAlimento = pesoAlimento;
    }

    public float pesoAlimento() {
        return pesoAlimento;
    }

    public Alimento setPesoAlimento(float pesoAlimento) {
        this.pesoAlimento = pesoAlimento;
        return this;
    }

    @Override
    public void Visualizar(){
        super.Visualizar();
        out.printf("\nPeso: %.2f", pesoAlimento);
    }
}
