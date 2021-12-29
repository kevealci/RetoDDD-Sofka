package com.retoddd.delivery.domain.restaurante.commands;

import co.com.sofka.domain.generic.Command;
import com.retoddd.delivery.domain.cliente.values.Detalle;
import com.retoddd.delivery.domain.cliente.values.Impuesto;
import com.retoddd.delivery.domain.cliente.values.SubTotal;
import com.retoddd.delivery.domain.cliente.values.Total;
import com.retoddd.delivery.domain.restaurante.values.RestauranteId;
import com.retoddd.delivery.domain.restaurante.values.VentaId;

public class AgregarVenta extends Command {

    private final RestauranteId restauranteId;
    private final VentaId ventaId;
    private final SubTotal subTotal;
    private final Impuesto impuesto;
    private final Total total;
    private final Detalle detalle;

    public AgregarVenta(RestauranteId restauranteId, VentaId ventaId, SubTotal subTotal, Impuesto impuesto, Total total, Detalle detalle) {
        this.restauranteId = restauranteId;
        this.ventaId = ventaId;
        this.subTotal = subTotal;
        this.impuesto = impuesto;
        this.total = total;
        this.detalle = detalle;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
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
