package com.algaworks;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> itens = new ArrayList<>();

    public void adicionarItem(ItemPedido itemPedido) {
        itens.add(itemPedido);
    }

    public ResumoPedido resumoPedido() {
        double valorTotal = itens.stream().mapToDouble(i -> i.getValor() * i.getQuantidade()).sum();
        double desconto = 0;

        if (valorTotal > 300.0 && valorTotal <= 800.0) {
            desconto = valorTotal * 0.04;
        } else  if (valorTotal > 800.0 && valorTotal <= 900.0) {
            desconto = valorTotal * 0.06;
        }

        return new ResumoPedido(valorTotal, desconto);
    }
}
