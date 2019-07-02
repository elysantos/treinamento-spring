package br.com.treinamento.treinamento.service;

import br.com.treinamento.treinamento.model.Filial;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFilialService {
    Filial recuperar(int id) throws Exception;
    List<Filial> recuperarTodos() throws Exception;
    boolean apagar(int id) throws Exception;
    Filial atualizar(int id, Filial filial) throws Exception;
    Filial inserir(Filial filial) throws Exception;
}
