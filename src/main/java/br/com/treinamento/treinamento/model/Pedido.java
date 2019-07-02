package br.com.treinamento.treinamento.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Pedido {

    private int id;
    private int tipo;
    private Date data;
    private Filial filial;
    private List<ItemPedidoEstoque> items;

}
