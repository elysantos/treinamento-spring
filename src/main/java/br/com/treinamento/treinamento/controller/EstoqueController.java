package br.com.treinamento.treinamento.controller;

import br.com.treinamento.treinamento.model.Estoque;
import br.com.treinamento.treinamento.service.IEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/estoques")
public class EstoqueController {

    @Autowired
    @Qualifier("estoqueDev")
    private IEstoqueService estoqueService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity recuperarTodos(){
        List<Estoque> estoqueList;
        try{
            estoqueList = estoqueService.recuperarTodos();
            return new ResponseEntity(estoqueList, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity recuperarUm(@PathVariable("id") int id){
        Estoque estoque;
        try{
            estoque = estoqueService.recuperar(id);
            if(estoque != null){
                return new ResponseEntity(estoque, HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
    public ResponseEntity recuperarporProduto(@PathVariable("id") String idProduto){
        List<Estoque> estoqueList;
        try{
            estoqueList = estoqueService.recuperarPorProduto(Integer.parseInt(idProduto));
            return new ResponseEntity(estoqueList, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/filiais/{id}", method = RequestMethod.GET)
    public ResponseEntity recuperarPorFilial(@PathVariable("id") String id){
        List<Estoque> estoqueList;
        try{
            estoqueList = estoqueService.recuperarPorFilial(Integer.parseInt(id));
            return new ResponseEntity(estoqueList, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }







}
