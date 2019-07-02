package br.com.treinamento.treinamento.controller;

import br.com.treinamento.treinamento.model.Filial;
import br.com.treinamento.treinamento.model.Produto;
import br.com.treinamento.treinamento.service.IFilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/filiais")
public class FilialController {

    @Autowired
    @Qualifier("filialDev")
    private IFilialService filialService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity recuperarTodos(){
        List<Filial> filialList;
        try{
            filialList = filialService.recuperarTodos();
            return new ResponseEntity(filialList, HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity recuperar(@PathVariable("id") String id){
        Filial filial;
        try{
            filial = filialService.recuperar(Integer.parseInt(id));
            return  new ResponseEntity(filial, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }



    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity inserir(@RequestBody Filial filial){
        try{
            Filial inserido = filialService.inserir(filial);
            return new ResponseEntity(inserido, HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity atualizar(@PathVariable("id") String id, @RequestBody Filial filial){
        try{
            Filial atualizado = filialService.atualizar(Integer.parseInt(id), filial);
            return new ResponseEntity(atualizado, HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity apagar(@PathVariable("id") String id){
        try{
            if(filialService.apagar(Integer.parseInt(id))){
                return new ResponseEntity(HttpStatus.OK);
            }

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
