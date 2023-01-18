package controller;

import model.Produto;
import static java.lang.System.out;
import repository.ProdutoRepository;

import java.util.ArrayList;

public class ProdutoController implements ProdutoRepository {
    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

    public Produto buscarNaLista(int codigoProduto) {
        for (var produto : listaProdutos) {
            if (produto.CodProduto() == codigoProduto) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public void procurarProduto(int codigoProduto) {
        var produto = buscarNaLista(codigoProduto);

        if (produto != null) {
            produto.Visualizar();
        } else {
            out.println("Código de produto " + codigoProduto + " não foi encontrado.");
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
        out.printf("\nO produto: %s foi criado com sucesso!\n",produto.nomeProduto());
    }

    @Override
    public void atualizarProduto(Produto produto) {

    }

    @Override
    public void deletarProduto() {

    }

    public int GerarIDProduto(){
        return listaProdutos.size() + 1;
    }
}
