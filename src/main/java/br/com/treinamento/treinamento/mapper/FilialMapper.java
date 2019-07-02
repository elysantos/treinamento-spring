package br.com.treinamento.treinamento.mapper;

import br.com.treinamento.treinamento.model.Filial;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FilialMapper {
    Filial recuperar(int id);
    List<Filial> recuperarTodos();
    void apagar(Filial filial);
    void atualizar(Filial filial);
    void inserir(Filial filial);
}
