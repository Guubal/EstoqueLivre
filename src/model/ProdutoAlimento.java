package model;
import static java.lang.System.out;

public class ProdutoAlimento extends Produto {
    private float pesoAlimento;

    public ProdutoAlimento(int tipoProduto, String nomeProduto, String marcaProduto, String categoriaProduto, int codProduto, int quantidadeProduto, float precoProduto, float pesoAlimento) {
        super(tipoProduto, nomeProduto, marcaProduto, categoriaProduto, codProduto, quantidadeProduto, precoProduto);
        this.pesoAlimento = pesoAlimento;
    }


    public float pesoAlimento() {
        return pesoAlimento;
    }

    public ProdutoAlimento setPesoAlimento(float pesoAlimento) {
        this.pesoAlimento = pesoAlimento;
        return this;
    }

    @Override
    public void Visualizar(){
        super.Visualizar();
        out.printf("\n%-15s %.2f\n","Peso:", pesoAlimento);
        out.println("-".repeat(40));
    }
}
