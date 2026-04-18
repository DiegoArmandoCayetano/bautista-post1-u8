package com.example.clean_pedidos.usecase;

import com.example.clean_pedidos.domain.valueobject.PedidoId;
import com.example.clean_pedidos.usecase.impl.CrearPedidoService;
import com.example.clean_pedidos.usecase.port.PedidoRepositoryPort;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.*;

public class CrearPedidoServiceTest {

    @Test
    void debeCrearPedidoYGuardarEnRepositorio() {

        // 🔥 SIMULAMOS la base de datos
        PedidoRepositoryPort repo = mock(PedidoRepositoryPort.class);

        // 🔥 creamos el servicio manualmente (SIN SPRING)
        CrearPedidoService service = new CrearPedidoService(repo);

        List<LineaPedidoDto> lineas = List.of(
                new LineaPedidoDto(
                        "Laptop",
                        1,
                        new BigDecimal("1000")
                )
        );

        // 🔥 ejecutamos el caso de uso
        PedidoId id = service.ejecutar("Diego", lineas);

        // 🔥 verificamos que se guardó en el repo
        verify(repo, times(1)).guardar(any());

        System.out.println("Pedido creado con ID: " + id);
    }
}