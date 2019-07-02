package br.com.treinamento.treinamento.model;

import lombok.Data;

@Data
public class ItemPedidoEstoque {
    private Produto produto;
    private int quantidade;
}
