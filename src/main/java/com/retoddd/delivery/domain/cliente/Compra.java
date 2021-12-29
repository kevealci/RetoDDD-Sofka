package com.retoddd.delivery.domain.cliente;

import co.com.sofka.domain.generic.Entity;
import com.retoddd.delivery.domain.cliente.values.*;

import java.util.Objects;

public class Compra extends Entity<CompraId> {

    private SubTotal subTotal;
    private Impuesto impuesto;
    private Total total;
    private Detalle detalle;

    public Compra(CompraId compraId, SubTotal subTotal, Impuesto impuesto, Total total, Detalle detalle) {
        super(compraId);
        this.subTotal = subTotal;
        this.impuesto = impuesto;
        this.total = total;
        this.detalle = detalle;
    }

    public void actualizarDetalle(Detalle detalle) { this.detalle = Objects.requireNonNull(detalle, "El detalle no puede ser nulo");}

    public void actualizarImpuesto(Impuesto impuesto) { this.impuesto = Objects.requireNonNull(impuesto, "El impuesto no puede ser nulo");}

    public SubTotal subTotal() { return subTotal; }

    public Impuesto impuesto() { return impuesto; }

    public Total total() { return total; }

    public Detalle detalle() { return detalle; }
}
