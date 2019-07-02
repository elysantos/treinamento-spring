package br.com.treinamento.treinamento.mapper;

import br.com.treinamento.treinamento.model.Pedido;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PedidoMapper {

    Pedido recuperar(int id);

    List<Pedido> recuperarTodos();


    void apagar(Pedido pedido);
    void atualizar(Pedido pedido);
    void inserir(Pedido pedido);
    void inserirItems(Pedido pedido);
}
