package com.retoddd.delivery.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.ClienteId;
import com.retoddd.delivery.domain.restaurante.values.RestauranteId;

public class PedidoCreado extends DomainEvent {
    private final ClienteId clienteId;
    private final RestauranteId restauranteId;

    public PedidoCreado(ClienteId clienteId, RestauranteId restauranteId) {
        super("petproject.pedido.pedidocreado");
        this.clienteId = clienteId;
        this.restauranteId = restauranteId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }
}
