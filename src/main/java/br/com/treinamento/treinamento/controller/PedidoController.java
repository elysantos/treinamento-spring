package br.com.treinamento.treinamento.controller;

import br.com.treinamento.treinamento.model.Pedido;
import br.com.treinamento.treinamento.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    @Qualifier("pedidoDev")
    private IPedidoService pedidoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity recuperarTodos(){
        List<Pedido> pedidoList;
        try {
           pedidoList = pedidoService.recuperarTodos();
           return new ResponseEntity(pedidoList, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity recuperarUm(@PathVariable("id") String id){
        Pedido pedido;
        try{
            pedido = pedidoService.recuperar(Integer.parseInt(id));
            if(pedido != null){
                return new ResponseEntity(pedido, HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity inserir(@RequestBody Pedido pedido){
        try{
            Pedido inserido = pedidoService.inserir(pedido);
            if(inserido.getId() > 0){
                return new ResponseEntity(inserido, HttpStatus.CREATED);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public ResponseEntity atualizar(@PathVariable("id") String id, @RequestBody Pedido pedido){
        try{
            Pedido atualizado = pedidoService.atualizar(Integer.parseInt(id), pedido);
            return new ResponseEntity(atualizado, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity apagar(@PathVariable("id") String id){
        try {
            if(pedidoService.apagar(Integer.parseInt(id))){
                return new ResponseEntity(HttpStatus.OK);
            }
        }catch(Exception e){
                System.out.println(e.getMessage());
            }
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
