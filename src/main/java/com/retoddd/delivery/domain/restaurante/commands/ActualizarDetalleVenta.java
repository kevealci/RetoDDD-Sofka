package com.retoddd.delivery.domain.restaurante.commands;

import co.com.sofka.domain.generic.Command;
import com.retoddd.delivery.domain.cliente.values.Detalle;
import com.retoddd.delivery.domain.restaurante.values.RestauranteId;
import com.retoddd.delivery.domain.restaurante.values.VentaId;

public class ActualizarDetalleVenta extends Command {

    private final RestauranteId restauranteId;
    private final VentaId ventaId;
    private final Detalle detalle;

    public ActualizarDetalleVenta(RestauranteId restauranteId, VentaId ventaId, Detalle detalle) {
        this.restauranteId = restauranteId;
        this.ventaId = ventaId;
        this.detalle = detalle;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public Detalle getDetalle() {
        return detalle;
    }
}
