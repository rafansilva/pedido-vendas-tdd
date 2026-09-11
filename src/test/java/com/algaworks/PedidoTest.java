package com.algaworks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    private  Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
    }

    private void assertResumoPedido(double valorTotal, double desconto) {
        assertEquals(valorTotal, pedido.valorTotal(),0.0001);
        assertEquals(desconto, pedido.desconto(),0.0001);
    }

    @Test
    public void devePermitirAdicionarUmNovoItemNoPedido() {
        ItemPedido itemPedido = new ItemPedido("Sabonete", 3.0, 10);
        pedido.adicionarItem(itemPedido);
    }

    @Test
    public void deveCalcularValorTotalEDescontoParaPedidoVazio() {
        assertResumoPedido(0.0, 0.0);
    }

    @Test
    public void deveCalcularResumoParaUmItemSemDesconto() {
        ItemPedido itemPedido = new ItemPedido("Sabonete", 5.0, 5);
        pedido.adicionarItem(itemPedido);
        assertResumoPedido(25, 0.0);
    }
}
