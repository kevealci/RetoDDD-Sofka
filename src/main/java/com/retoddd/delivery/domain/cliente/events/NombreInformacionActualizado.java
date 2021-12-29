package com.retoddd.delivery.domain.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.InformacionId;
import com.retoddd.delivery.domain.cliente.values.Nombre;

public class NombreInformacionActualizado extends DomainEvent {
    private final InformacionId informacionId;
    private final Nombre nombre;

    public NombreInformacionActualizado(InformacionId informacionId, Nombre nombre) {
        super("delivery.cliente.nombreinformacionactualizado");
        this.informacionId = informacionId;
        this.nombre = nombre;
    }

    public InformacionId getInformacionId() { return informacionId; }

    public Nombre getNombre() { return nombre; }
}
