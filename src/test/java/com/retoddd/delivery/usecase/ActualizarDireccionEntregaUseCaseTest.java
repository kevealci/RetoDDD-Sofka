package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.ClienteId;
import com.retoddd.delivery.domain.cliente.values.Direccion;
import com.retoddd.delivery.domain.pedido.commands.ActualizarDireccionEntrega;
import com.retoddd.delivery.domain.pedido.events.DireccionEntregaActualizada;
import com.retoddd.delivery.domain.pedido.events.PedidoCreado;
import com.retoddd.delivery.domain.pedido.values.PedidoId;
import com.retoddd.delivery.domain.restaurante.values.RestauranteId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarDireccionEntregaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarDireccionEntrega() {

        PedidoId pedidoId = PedidoId.of("xxxx");
        Direccion direccion = new Direccion("yyyyy");

        var command = new ActualizarDireccionEntrega(pedidoId, direccion);
        var usecase = new ActualizarDireccionEntregaUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(pedidoId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DireccionEntregaActualizada) events.get(0);

        Assertions.assertEquals("yyyyy", event.getDireccion().value());
        Mockito.verify(repository).getEventsBy("xxxx");

    }

    private List<DomainEvent> events() {
        return List.of(
                new PedidoCreado(ClienteId.of("yyyy"), RestauranteId.of("bbbb"))
        );
    }
}