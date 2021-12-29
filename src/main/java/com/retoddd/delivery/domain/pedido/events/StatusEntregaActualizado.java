package com.retoddd.delivery.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.pedido.values.Status;

public class StatusEntregaActualizado extends DomainEvent {
    private final Status status;

    public StatusEntregaActualizado(Status status) {
        super("delivery.pedido.statusentregaactualizado");
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
