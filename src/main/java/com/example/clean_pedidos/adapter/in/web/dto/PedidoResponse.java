package com.example.clean_pedidos.adapter.in.web.dto;

import com.example.clean_pedidos.domain.entity.Pedido;

import java.math.BigDecimal;

public record PedidoResponse(
        String id,
        String cliente,
        BigDecimal total
) {
    public static PedidoResponse fromDomain(Pedido p) {
        return new PedidoResponse(
                p.getId().toString(),
                p.getClienteNombre(),
                p.calcularTotal().cantidad()
        );
    }
}