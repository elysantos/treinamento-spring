package br.com.treinamento.treinamento.service;

import br.com.treinamento.treinamento.mapper.ProdutoMapper;
import br.com.treinamento.treinamento.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.EscapedErrors;

import java.util.List;

@Component("dev")
public class ProdutoService implements IProdutoService
{
    @Autowired
    private ProdutoMapper produtoMapper;


    @Override
    public Produto recuperar(int id) throws Exception{
        Produto produto;
        try{
            produto = produtoMapper.recuperar(id);
            if(produto!=null){
                return produto;
            }
            throw new Exception("Recurso não encontrado");
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<Produto> recuperarTodos() throws Exception {
       List<Produto> produtoList;
       try{
           produtoList = produtoMapper.recuperarTodos();
           return produtoList;
       }catch(Exception e){
           throw e;
       }
    }

    @Override
    public boolean apagarProduto(int idProduto) throws Exception {
        Produto produto;
        try{
            produto = produtoMapper.recuperar(idProduto);
            if(produto != null) {
                produtoMapper.apagar(produto);
                return true;
            }
            throw new Exception("Não encontrado recurso");
        }catch (Exception e){
            throw  e;
        }
    }

    @Override
    public Produto atualizarProduto(int id, Produto produto) throws Exception {
        Produto produtoAtual;
        try{
            produtoAtual = produtoMapper.recuperar(id);
            if(produto.getId()== produtoAtual.getId()) {
                produtoMapper.atualizar(produto);
                return produto;
            }
            throw new Exception("Não encontrado recurso");
        }catch (Exception e){
            throw  e;
        }
    }

    @Override
    public Produto inserir(Produto produto) throws Exception {
        try{
            produtoMapper.inserir(produto);
            return produto;
        }catch(Exception e){
            throw e;
        }
    }


}
