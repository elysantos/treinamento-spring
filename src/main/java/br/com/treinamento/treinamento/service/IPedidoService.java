package br.com.treinamento.treinamento.service;

import br.com.treinamento.treinamento.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPedidoService {

    Pedido recuperar(int id) throws Exception;

    List<Pedido> recuperarTodos() throws Exception;

    boolean apagar(int idPedido) throws Exception;

    Pedido atualizar(int id, Pedido pedido) throws Exception;

    Pedido inserir(Pedido pedido) throws Exception;
}
