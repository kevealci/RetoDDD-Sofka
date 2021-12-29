package com.retoddd.delivery.domain.restaurante.commands;

import co.com.sofka.domain.generic.Command;
import com.retoddd.delivery.domain.restaurante.values.Actividad;
import com.retoddd.delivery.domain.restaurante.values.EstacionId;
import com.retoddd.delivery.domain.restaurante.values.RestauranteId;

public class ActualizarActividadEstacion extends Command {

    private final RestauranteId restauranteId;
    private final EstacionId estacionId;
    private final Actividad actividad;

    public ActualizarActividadEstacion(RestauranteId restauranteId, EstacionId estacionId, Actividad actividad) {
        this.restauranteId = restauranteId;
        this.estacionId = estacionId;
        this.actividad = actividad;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public EstacionId getEstacionId() {
        return estacionId;
    }

    public Actividad getActividad() {
        return actividad;
    }
}
