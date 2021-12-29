package com.retoddd.delivery.domain.restaurante.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.Detalle;
import com.retoddd.delivery.domain.restaurante.values.VentaId;

public class DetalleVentaActualizado extends DomainEvent {
    private final VentaId ventaId;
    private final Detalle detalle;

    public DetalleVentaActualizado(VentaId ventaId, Detalle detalle) {
        super("delivery.cliente.compraagregada");
        this.ventaId = ventaId;
        this.detalle = detalle;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public Detalle getDetalle() {
        return detalle;
    }
}
