package produto;
import static java.lang.System.out;

public class Bebida extends Produto{
    float ml;

    public Bebida(String nomeProduto, String marcaProduto, String categoriaProduto, int codProduto, int quantidadeProduto, float precoProduto, float ml) {
        super(nomeProduto, marcaProduto, categoriaProduto, codProduto, quantidadeProduto, precoProduto);
        this.ml = ml;
    }

    public float ml() {
        return ml;
    }

    public Bebida setMl(float ml) {
        this.ml = ml;
        return this;
    }

    @Override
    public void Visualizar(){
        super.Visualizar();
        out.printf("\nML: %.2f", ml);
    }
}
