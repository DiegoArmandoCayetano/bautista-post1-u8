package com.example.clean_pedidos.usecase;

import com.example.clean_pedidos.domain.entity.Pedido;
import com.example.clean_pedidos.domain.valueobject.PedidoId;
import org.junit.jupiter.api.Test;
import com.example.clean_pedidos.usecase.port.PedidoRepositoryPort;
import com.example.clean_pedidos.usecase.impl.CrearPedidoService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CrearPedidoServiceTest {

    private final PedidoRepositoryPort repository = mock(PedidoRepositoryPort.class);
    private final CrearPedidoService service = new CrearPedidoService(repository);

    @Test
    void deberiaCrearYGuardarPedido() {

        PedidoId id = service.ejecutar("Juan");

        verify(repository).guardar(any(Pedido.class));
        assertNotNull(id);
    }
}