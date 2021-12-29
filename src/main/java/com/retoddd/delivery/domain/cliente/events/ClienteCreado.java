package com.retoddd.delivery.domain.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.Informacion;

public class ClienteCreado extends DomainEvent {
    private final Informacion informacion;

    public ClienteCreado(Informacion informacion) {
        super("delivery.cliente.clientecreado");
        this.informacion = informacion;
    }

    public Informacion getInformacion() { return informacion; }
}
