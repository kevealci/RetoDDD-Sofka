package com.retoddd.delivery.domain.restaurante.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.Detalle;
import com.retoddd.delivery.domain.restaurante.values.EstacionId;

public class DetalleEstacionActualizado extends DomainEvent {
    private final EstacionId estacionId;
    private final Detalle detalle;

    public DetalleEstacionActualizado(EstacionId estacionId, Detalle detalle) {
        super("delivery.restaurante.detalleestacionactualizado");
        this.estacionId = estacionId;
        this.detalle = detalle;
    }

    public EstacionId getEstacionId() {
        return estacionId;
    }

    public Detalle getDetalle() {
        return detalle;
    }
}
