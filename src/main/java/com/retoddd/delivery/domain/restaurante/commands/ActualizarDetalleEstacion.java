package com.retoddd.delivery.domain.restaurante.commands;

import co.com.sofka.domain.generic.Command;
import com.retoddd.delivery.domain.cliente.values.Detalle;
import com.retoddd.delivery.domain.restaurante.values.EstacionId;
import com.retoddd.delivery.domain.restaurante.values.RestauranteId;

public class ActualizarDetalleEstacion extends Command {

    private final RestauranteId restauranteId;
    private final EstacionId estacionId;
    private final Detalle detalle;

    public ActualizarDetalleEstacion(RestauranteId restauranteId, EstacionId estacionId, Detalle detalle) {
        this.restauranteId = restauranteId;
        this.estacionId = estacionId;
        this.detalle = detalle;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public EstacionId getEstacionId() {
        return estacionId;
    }

    public Detalle getDetalle() {
        return detalle;
    }
}
