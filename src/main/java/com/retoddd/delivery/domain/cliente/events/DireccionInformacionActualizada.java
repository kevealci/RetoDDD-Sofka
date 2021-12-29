package com.retoddd.delivery.domain.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.Direccion;
import com.retoddd.delivery.domain.cliente.values.InformacionId;

public class DireccionInformacionActualizada extends DomainEvent {
    private final InformacionId informacionId;
    private final Direccion direccion;

    public DireccionInformacionActualizada(InformacionId informacionId, Direccion direccion) {
        super("delivery.cliente.direccioninformacionactualizada");
        this.informacionId = informacionId;
        this.direccion = direccion;
    }

    public InformacionId getInformacionId() { return informacionId; }

    public Direccion getDireccion() { return direccion; }
}
