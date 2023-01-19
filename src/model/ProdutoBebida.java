package model;
import static java.lang.System.out;

public class ProdutoBebida extends Produto {
    private float ml;

    public ProdutoBebida(int tipoProduto, String nomeProduto, String marcaProduto, String categoriaProduto, int codProduto, int quantidadeProduto, float precoProduto, float ml) {
        super(tipoProduto, nomeProduto, marcaProduto, categoriaProduto, codProduto, quantidadeProduto, precoProduto);
        this.ml = ml;
    }

    public float ml() {
        return ml;
    }

    public ProdutoBebida setMl(float ml) {
        this.ml = ml;
        return this;
    }

    @Override
    public void Visualizar() {
        super.Visualizar();
        out.printf("\n%-15s %.2f\n", "ML:", ml);
        out.println("-".repeat(40));
    }
}
