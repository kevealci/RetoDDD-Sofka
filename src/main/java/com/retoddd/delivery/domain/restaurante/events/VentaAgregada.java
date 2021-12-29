package com.retoddd.delivery.domain.restaurante.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.*;
import com.retoddd.delivery.domain.restaurante.values.VentaId;

public class VentaAgregada extends DomainEvent {
    private final VentaId ventaId;
    private final SubTotal subTotal;
    private final Impuesto impuesto;
    private final Total total;
    private final Detalle detalle;

    public VentaAgregada(VentaId ventaId, SubTotal subTotal, Impuesto impuesto, Total total, Detalle detalle) {
        super("delivery.restaurante.ventaagregada");
        this.ventaId = ventaId;
        this.subTotal = subTotal;
        this.impuesto = impuesto;
        this.total = total;
        this.detalle = detalle;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public SubTotal getSubTotal() {
        return subTotal;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public Total getTotal() {
        return total;
    }

    public Detalle getDetalle() {
        return detalle;
    }
}
