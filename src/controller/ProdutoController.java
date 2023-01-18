package controller;

import model.Produto;
import static java.lang.System.out;
import repository.ProdutoRepository;

import java.util.ArrayList;

public class ProdutoController implements ProdutoRepository {
    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

    @Override
    public void procurarProduto(String nome) {

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
