package controller;
import model.Produto;
import static java.lang.System.out;
import repository.ProdutoRepository;
import java.util.ArrayList;

public class ProdutoController implements ProdutoRepository {
    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

    @Override
    public void procurarProduto(int ID) {
        var produto = buscarNaCollection(ID);

        if (produto != null) {
            produto.Visualizar();
        } else {
            out.printf("O produto de ID %d não foi encontrado!", ID);
            ;
        }
    }

    @Override
    public void listarProdutos() {
        for (var produto : listaProdutos) {
            produto.Visualizar();
        }
    }

    @Override
    public void cadastrarProduto(Produto produto) {
        listaProdutos.add(produto);
        out.printf("\nO produto: %s foi criado com sucesso!\n", produto.getNomeProduto());
    }

    @Override
    public void atualizarProduto(Produto produto) {
        var buscarProduto = buscarNaCollection(produto.getCodProduto());
        if (buscarProduto != null) {
            listaProdutos.set(listaProdutos.indexOf(buscarProduto), produto);
            out.printf("\nO produto de ID: %d foi atualizado com sucesso!", produto.getCodProduto());
        } else {
            out.printf("\n O produto de ID: %d não foi encontrado", produto.getCodProduto());
        }
    }

    @Override
    public void deletarProduto(int ID) {
        var buscaProduto = buscarNaCollection(ID);
        if (buscaProduto != null) {
            listaProdutos.remove(buscaProduto);
            out.printf("\nO produto: ID %d, foi excluido com sucesso!", ID);
        } else {
            out.printf("\nO produto informado näo foi encontrado!");
        }
    }

    public int GerarIDProduto() {
        return listaProdutos.size() + 1;
    }

    public Produto buscarNaCollection(int ID) {
        for (var produto : listaProdutos) {
            if (produto.getCodProduto() == ID) {
                return produto;
            }
        }
        return null;
    }

    public int retornaTipo(int ID) {
        for (var produto : listaProdutos) {
            if (produto.getCodProduto() == ID) {
                return produto.getTipoProduto();
            }
        }
        return 0;
    }
}
