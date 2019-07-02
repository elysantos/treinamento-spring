package br.com.treinamento.treinamento.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoPedido {

    ENTRADA(1),
    SAIDA(0);

    private int tipo;

}
