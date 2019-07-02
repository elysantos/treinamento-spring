package br.com.treinamento.treinamento.service;

import br.com.treinamento.treinamento.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProdutoService {
    Produto recuperar(int id) throws Exception;
    List<Produto> recuperarTodos() throws Exception;
    boolean apagarProduto(int idProduto) throws Exception;
    Produto atualizarProduto(int id, Produto produto) throws Exception;
    Produto inserir( Produto produto) throws Exception;
}
