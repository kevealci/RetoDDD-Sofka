package com.retoddd.delivery.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.ClienteId;

public class ClienteAsociado extends DomainEvent {
    private final ClienteId clienteId;

    public ClienteAsociado(ClienteId clienteId) {
        super("delivery.pedido.clienteasociado");
        this.clienteId = clienteId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
