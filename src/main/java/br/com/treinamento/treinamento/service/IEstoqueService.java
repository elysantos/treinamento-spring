package br.com.treinamento.treinamento.service;

import br.com.treinamento.treinamento.model.Estoque;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEstoqueService {

    /**
     * Recuperar lista de estoque das filiais com base em um produto
     * @param idProduto cdigo do produto a ser encontrado
     * @return lista de estoque das filiais para o produto requisitado
     * @throws Exception
     */
    List<Estoque> recuperarPorProduto(int idProduto) throws Exception;

    List<Estoque> recuperarPorFilial(int idFilial) throws Exception;

    List<Estoque> recuperarTodos() throws Exception;

    Estoque recuperar(int id) throws Exception;

    boolean apagar(int id) throws Exception;

    Estoque atualizar(int id, Estoque estoque, int tipo) throws Exception;

    Estoque atualizarProdutoPorFilial(int idFilial, int idProduto, int quantidade, int tipo);

    Estoque inserir(Estoque estoque, int tipo) throws Exception;

}
