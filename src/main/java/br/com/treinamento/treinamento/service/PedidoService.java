package br.com.treinamento.treinamento.service;

import br.com.treinamento.treinamento.mapper.PedidoMapper;
import br.com.treinamento.treinamento.model.Estoque;
import br.com.treinamento.treinamento.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("pedidoDev")
public class PedidoService implements IPedidoService{

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    @Qualifier("estoqueDev")
    private IEstoqueService estoqueService;

    @Override
    public Pedido recuperar(int id) throws Exception {
        Pedido pedido;
        try{
            pedido = pedidoMapper.recuperar(id);
            if(pedido!= null){
                return pedido;
            }
            throw new Exception("Pedido não encontrado");
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Pedido> recuperarTodos() throws Exception {
        List<Pedido> pedidoList;
        try{
            pedidoList = pedidoMapper.recuperarTodos();
            return pedidoList;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public boolean apagar(int idPedido) throws Exception {
        return false;
    }

    @Override
    public Pedido atualizar(int id, Pedido pedido) throws Exception {
        return null;
    }

    @Override
    public Pedido inserir(Pedido pedido) throws Exception {
        try{
            pedidoMapper.inserir(pedido);
            if(pedido.getId() > 0){
                //inserir itens do pedido
                pedidoMapper.inserirItems(pedido);

                // atualizar estoque
               pedido.getItems().forEach(i->{
                   try{
                    estoqueService.inserir(new Estoque(i.getProduto(), pedido.getFilial(), i.getQuantidade()), pedido.getTipo());
                   }catch (Exception e){
                       System.out.println(e.getMessage());
                   }
               });
            }
            return pedido;
        }catch (Exception e){
            throw e;
        }
    }
}
