package repository;
import model.Produto;
public interface ProdutoRepository {
    public void procurarProduto(int codigoProduto);
    public void listarProdutos();
    public void cadastrarProduto(Produto produto);
    public void atualizarProduto(Produto produto);
    public void deletarProduto();
}
