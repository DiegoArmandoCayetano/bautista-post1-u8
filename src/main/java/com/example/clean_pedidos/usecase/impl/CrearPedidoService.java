package com.example.clean_pedidos.usecase.impl;

import com.example.clean_pedidos.domain.entity.Pedido;
import com.example.clean_pedidos.domain.valueobject.Dinero;
import com.example.clean_pedidos.domain.valueobject.PedidoId;
import com.example.clean_pedidos.usecase.CrearPedidoUseCase;
import com.example.clean_pedidos.usecase.LineaPedidoDto;
import com.example.clean_pedidos.usecase.port.PedidoRepositoryPort;

import java.util.List;

public class CrearPedidoService implements CrearPedidoUseCase {

    private final PedidoRepositoryPort repo;

    public CrearPedidoService(PedidoRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public PedidoId ejecutar(String clienteNombre, List<LineaPedidoDto> lineas) {

        Pedido pedido = new Pedido(PedidoId.nuevo(), clienteNombre);

        for (LineaPedidoDto l : lineas) {
            pedido.agregarLinea(
                    l.productoNombre(),
                    l.cantidad(),
                    new Dinero(l.precioUnitario())
            );
        }

        pedido.confirmar();

        repo.guardar(pedido);

        return pedido.getId();
    }
}