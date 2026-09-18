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
        ResumoPedido resumo = pedido.resumoPedido();
        assertEquals(valorTotal, resumo.getValorTotal(),0.0001);
        assertEquals(desconto, resumo.getDesconto(),0.0001);
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

    @Test
    public void deveCalcularResumoParaDoisItensSemDesconto() {
        pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 3));
        pedido.adicionarItem(new ItemPedido("Pasta Dental", 7.0, 3));

        assertResumoPedido(30, 0.0);
    }

    @Test
    public void deveAplicarDescontoNa1aFaixa() {
        pedido.adicionarItem(new ItemPedido("Creme", 20.0, 20));

        assertResumoPedido(400.0, 16.0);
    }

    @Test
    public void deveAplicarDescontoNa2aFaixa() {
        pedido.adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
        pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));

        assertResumoPedido(900.0, 54.0);
    }

    @Test
    public void deveAplicarDescontoNa3aFaixa() {
        pedido.adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
        pedido.adicionarItem(new ItemPedido("Óleo", 15.0, 30));
        pedido.adicionarItem(new ItemPedido("Creme", 10.0, 20));


        assertResumoPedido(1200.0, 96.0);
    }
}
