package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.retoddd.delivery.domain.cliente.values.ClienteId;
import com.retoddd.delivery.domain.pedido.commands.CrearPedido;
import com.retoddd.delivery.domain.pedido.events.PedidoCreado;
import com.retoddd.delivery.domain.pedido.values.PedidoId;
import com.retoddd.delivery.domain.restaurante.values.RestauranteId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearPedidoUseCaseTest {
    @Test
    public void crearPedido() {

        //arrange
        PedidoId pedidoId = PedidoId.of("xxxx");
        ClienteId clienteId = ClienteId.of("yyyy");
        RestauranteId restauranteId = RestauranteId.of("zzzz");

        var command = new CrearPedido(pedidoId, clienteId, restauranteId);
        var usecase = new CrearPedidoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        //asserts
        PedidoCreado event = (PedidoCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("yyyy", event.getClienteId().value());
        Assertions.assertEquals("zzzz", event.getRestauranteId().value());
    }

}