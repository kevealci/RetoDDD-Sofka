package com.retoddd.delivery.domain.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.*;

public class CompraAgregada extends DomainEvent {
    private final CompraId compraId;
    private final SubTotal subTotal;
    private final Impuesto impuesto;
    private final Total total;
    private final Detalle detalle;

    public CompraAgregada(CompraId compraId, SubTotal subTotal, Impuesto impuesto, Total total, Detalle detalle) {
        super("delivery.cliente.compraagregada");
        this.compraId = compraId;
        this.subTotal = subTotal;
        this.impuesto = impuesto;
        this.total = total;
        this.detalle = detalle;
    }

    public CompraId getCompraId() { return compraId; }

    public SubTotal getSubTotal() { return subTotal; }

    public Impuesto getImpuesto() { return impuesto; }

    public Total getTotal() { return total; }

    public Detalle getDetalle() { return detalle; }
}
