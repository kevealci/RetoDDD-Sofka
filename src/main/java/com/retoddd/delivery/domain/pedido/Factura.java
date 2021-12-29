package com.retoddd.delivery.domain.pedido;

import co.com.sofka.domain.generic.Entity;
import com.retoddd.delivery.domain.cliente.values.Impuesto;
import com.retoddd.delivery.domain.cliente.values.SubTotal;
import com.retoddd.delivery.domain.cliente.values.Total;
import com.retoddd.delivery.domain.pedido.values.FacturaId;

import java.util.Objects;

public class Factura extends Entity<FacturaId> {

    private SubTotal subTotal;
    private Impuesto impuesto;
    private Total total;

    public Factura(FacturaId facturaId, SubTotal subTotal, Impuesto impuesto, Total total) {
        super(facturaId);
        this.subTotal = subTotal;
        this.impuesto = impuesto;
        this.total = total;
    }

    public void actualizarImpuesto(Impuesto impuesto) {
        this.impuesto = Objects.requireNonNull(impuesto, "El impuesto no puede ser nulo");
    }

    public void actualizarTotal(Total total) {
        this.total = Objects.requireNonNull(total, "El total no puede ser nulo");
    }

    public SubTotal subTotal() {
        return subTotal;
    }

    public Impuesto impuesto() {
        return impuesto;
    }

    public Total total() {
        return total;
    }
}
