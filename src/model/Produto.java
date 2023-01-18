package model;
import static java.lang.System.out;

public abstract class Produto {
    private String nomeProduto, marcaProduto, categoriaProduto;
    private int codProduto, quantidadeProduto, tipoProduto;
    private float precoProduto;

    public Produto(int tipoProduto, String nomeProduto, String marcaProduto, String categoriaProduto, int codProduto, int quantidadeProduto, float precoProduto) {
        this.tipoProduto = tipoProduto;
        this.nomeProduto = nomeProduto;
        this.marcaProduto = marcaProduto;
        this.categoriaProduto = categoriaProduto;
        this.codProduto = codProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.precoProduto = precoProduto;
    }

    public int getTipoProduto() {
        return tipoProduto;
    }

    public Produto setTipoProduto(int tipoProduto) {
        this.tipoProduto = tipoProduto;
        return this;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public Produto setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
        return this;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Produto setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
        return this;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public Produto setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
        return this;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public Produto setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
        return this;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public Produto setCodProduto(int codProduto) {
        this.codProduto = codProduto;
        return this;
    }

    public float getPrecoProduto() {
        return precoProduto;
    }

    public Produto setPrecoProduto(float precoProduto) {
        this.precoProduto = precoProduto;
        return this;
    }

    public void Visualizar() {

        out.printf("\n\n");
        out.printf("-".repeat(40));
        out.printf("\n%-15s %s", "Produto:", nomeProduto);
        out.printf("\n%-15s %.2f", "Preço:", precoProduto);
        out.printf("\n%-15s %s", "Marca:", marcaProduto);
        out.printf("\n%-15s %s", "Categoria:", categoriaProduto);
        out.printf("\n%-15s %d", "Cód Produto:", codProduto);
    }
}
