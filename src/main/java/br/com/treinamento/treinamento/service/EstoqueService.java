package br.com.treinamento.treinamento.service;

import br.com.treinamento.treinamento.model.Estoque;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("estoqueDev")
public class EstoqueService implements IEstoqueService {
    @Override
    public List<Estoque> recuperarPorProduto(int idProduto) throws Exception {
        return null;
    }

    @Override
    public List<Estoque> recuperarPorFilial(int idFilial) throws Exception {
        return null;
    }

    @Override
    public List<Estoque> recuperarTodos() throws Exception {
        return null;
    }

    @Override
    public Estoque recuperar(int id) throws Exception {
        return null;
    }

    @Override
    public boolean apagar(int id) throws Exception {
        return false;
    }

    @Override
    public Estoque atualizar(int id, Estoque estoque, int tipo) throws Exception {
        return null;
    }

    @Override
    public Estoque atualizarProdutoPorFilial(int idFilial, int idProduto, int quantidade, int tipo) {
        return null;
    }

    @Override
    public Estoque inserir(Estoque estoque, int tipo) throws Exception {
        return null;
    }
}
