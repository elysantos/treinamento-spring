package br.com.treinamento.treinamento.mapper;

import br.com.treinamento.treinamento.model.Produto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProdutoMapper {

    Produto recuperar(int id);
    List<Produto> recuperarTodos();
    void apagar(Produto produto);
    void atualizar(Produto produto);
    void inserir(Produto produto);
}
