package com.retoddd.delivery.domain.restaurante;

import co.com.sofka.domain.generic.Entity;
import com.retoddd.delivery.domain.cliente.values.Detalle;
import com.retoddd.delivery.domain.cliente.values.Impuesto;
import com.retoddd.delivery.domain.cliente.values.SubTotal;
import com.retoddd.delivery.domain.cliente.values.Total;
import com.retoddd.delivery.domain.restaurante.values.VentaId;

import java.util.Objects;

public class Venta extends Entity<VentaId> {

    private SubTotal subTotal;
    private Impuesto impuesto;
    private Total total;
    private Detalle detalle;

    public Venta(VentaId ventaId, SubTotal subTotal, Impuesto impuesto, Total total, Detalle detalle) {
        super(ventaId);
        this.subTotal = subTotal;
        this.impuesto = impuesto;
        this.total = total;
        this.detalle = detalle;
    }

    public void actualizarDetalle(Detalle detalle) { this.detalle = Objects.requireNonNull(detalle, "El detalle no puede ser nulo");}

    public void actualizarImpuesto(Impuesto impuesto) { this.impuesto = Objects.requireNonNull(impuesto, "El impuesto no puede ser nulo");}

    public SubTotal subTotal() {
        return subTotal;
    }

    public Impuesto impuesto() {
        return impuesto;
    }

    public Total total() {
        return total;
    }

    public Detalle detalle() {
        return detalle;
    }
}
