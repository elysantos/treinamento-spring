package br.com.treinamento.treinamento.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class Estoque {
    private int id;
    private Produto produto;
    private Filial filial;
    private int quantidade;

    public Estoque(Produto produto, Filial filial, int quantidade){
        this.produto = produto;
        this.filial = filial;
        this.quantidade = quantidade;

    }
}
