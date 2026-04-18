package com.example.clean_pedidos.usecase;

import com.example.clean_pedidos.domain.valueobject.PedidoId;

import java.util.List;

public interface CrearPedidoUseCase {

    PedidoId ejecutar(String clienteNombre, List<LineaPedidoDto> lineas);
}