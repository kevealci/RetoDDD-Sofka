package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.ClienteId;
import com.retoddd.delivery.domain.pedido.commands.AsociarCliente;
import com.retoddd.delivery.domain.pedido.events.ClienteAsociado;
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
class AsociarClienteUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void asociarCliente() {
        PedidoId pedidoId = PedidoId.of("xxxx");
        ClienteId clienteId = ClienteId.of("yyyy");

        var command = new AsociarCliente(pedidoId, clienteId);
        var usecase = new AsociarClienteUseCase();

        when(repository.getEventsBy("xxxx")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(pedidoId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ClienteAsociado) events.get(0);

        Assertions.assertEquals("yyyy", event.getClienteId().value());
        Mockito.verify(repository).getEventsBy("xxxx");
    }

    private List<DomainEvent>  events() {
        return List.of(
                new PedidoCreado(ClienteId.of("yyyy"), RestauranteId.of("bbbb"))
        );
    }
}