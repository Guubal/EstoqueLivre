package repository;
import model.Produto;

public interface ProdutoRepository {
    public void procurarProduto(int ID);

    public void listarProdutos();

    public void listarProdutosAtualizar(int ID);

    public void cadastrarProduto(Produto produto);

    public void atualizarProduto(Produto produto);

    public void deletarProduto(int ID);
}
