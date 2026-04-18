package com.example.clean_pedidos.domain;

import com.example.clean_pedidos.domain.entity.Pedido;
import com.example.clean_pedidos.domain.valueobject.*;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    void debeCrearPedidoYConfirmarlo() {

        Pedido pedido = new Pedido(
                PedidoId.nuevo(),
                "Diego"
        );

        pedido.agregarLinea(
                "Laptop",
                1,
                new Dinero(new BigDecimal("1000"))
        );

        assertDoesNotThrow(() -> pedido.confirmar());
    }

    @Test
    void noDebeConfirmarPedidoVacio() {

        Pedido pedido = new Pedido(
                PedidoId.nuevo(),
                "Diego"
        );

        Exception ex = assertThrows(RuntimeException.class, () -> {
            pedido.confirmar();
        });

        System.out.println(ex.getMessage());
    }
}