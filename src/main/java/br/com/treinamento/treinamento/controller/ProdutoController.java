package br.com.treinamento.treinamento.controller;

import br.com.treinamento.treinamento.model.Produto;
import br.com.treinamento.treinamento.service.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    @Qualifier("dev")
    private IProdutoService produtoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity recuperarTodos(){
        List<Produto> produtoList;
        try{
            produtoList = produtoService.recuperarTodos();
            return new ResponseEntity(produtoList, HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity recuperar(@PathVariable("id") String id){
        Produto produto;
        try{
            produto = produtoService.recuperar(Integer.parseInt(id));
            return  new ResponseEntity(produto, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }



    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity inserir(@RequestBody Produto produto){
        try{
            Produto inserido = produtoService.inserir(produto);
            return new ResponseEntity(inserido, HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity atualizar(@PathVariable("id") String id, @RequestBody Produto produto){
        try{
            Produto atualizado = produtoService.atualizarProduto(Integer.parseInt(id), produto);
            return new ResponseEntity(atualizado, HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity apagar(@PathVariable("id") String id){
        try{
            produtoService.apagarProduto(Integer.parseInt(id));
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
