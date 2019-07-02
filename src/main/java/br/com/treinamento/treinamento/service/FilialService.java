package br.com.treinamento.treinamento.service;

import br.com.treinamento.treinamento.mapper.FilialMapper;
import br.com.treinamento.treinamento.model.Filial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("filialDev")
public class FilialService implements IFilialService{

    @Autowired
    private FilialMapper filialMapper;

    @Override
    public Filial recuperar(int id) throws Exception {
       Filial filial;
       try {
           filial = filialMapper.recuperar(id);
           if(filial != null){
               return filial;
           }
           throw new Exception("Não encontrado");
       }catch (Exception e){
           throw e;
       }
    }

    @Override
    public List<Filial> recuperarTodos() throws Exception {
        List<Filial> filialList;
        try {
            filialList = filialMapper.recuperarTodos();
            return filialList;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public boolean apagar(int id) throws Exception {
        Filial filial;
        try{
            filial = filialMapper.recuperar(id);
            if(filial != null){
                filialMapper.apagar(filial);
                return true;
            }
            return false;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public Filial atualizar(int id, Filial filial) throws Exception {
        Filial filialAtual;
        try{
            filialAtual = filialMapper.recuperar(id);
            if(filialAtual.getId() == filial.getId()){
                filialMapper.atualizar(filial);
                return filial;
            }
            throw new Exception("Não encontrada filial");
        }catch (Exception e){
            throw  e;
        }

    }

    @Override
    public Filial inserir(Filial filial) throws Exception {
        try{
            filialMapper.inserir(filial);
            if(filial.getId()>0){
                return filial;
            }
            throw new Exception("Erro ao inserir");
        }catch (Exception e){
            throw  e;
        }
    }
}
