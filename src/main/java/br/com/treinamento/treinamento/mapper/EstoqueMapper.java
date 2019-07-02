package br.com.treinamento.treinamento.mapper;

import br.com.treinamento.treinamento.model.Estoque;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EstoqueMapper {

    List<Estoque> recuperarTodos();
    List<Estoque> recuperarPorProduto(int produto);
    List<Estoque> recuperarPorFilial(int filial);

    Estoque recuperar(int id);

    void apagar(Estoque estoque);
    void atualizar(Estoque estoque);
    void inserir(Estoque estoque);
}
