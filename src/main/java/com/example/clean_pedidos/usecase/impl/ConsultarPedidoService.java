package com.example.clean_pedidos.usecase.impl;

import com.example.clean_pedidos.adapter.in.web.dto.PedidoResponse;
import com.example.clean_pedidos.domain.entity.Pedido;
import com.example.clean_pedidos.domain.valueobject.PedidoId;
import com.example.clean_pedidos.usecase.ConsultarPedidoUseCase;
import com.example.clean_pedidos.usecase.port.PedidoRepositoryPort;

import java.util.List;

public class ConsultarPedidoService implements ConsultarPedidoUseCase {

    private final PedidoRepositoryPort repo;

    public ConsultarPedidoService(PedidoRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public PedidoResponse buscarPorId(PedidoId id) {

        Pedido p = repo.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        return PedidoResponse.from(p);
    }

    @Override
    public List<PedidoResponse> listarTodos() {
        return repo.buscarTodos()
                .stream()
                .map(PedidoResponse::from)
                .toList();
    }
}