package com.retoddd.delivery.domain.restaurante;

import co.com.sofka.domain.generic.Entity;
import com.retoddd.delivery.domain.cliente.values.Detalle;
import com.retoddd.delivery.domain.restaurante.values.Actividad;
import com.retoddd.delivery.domain.restaurante.values.EstacionId;

import java.util.Objects;

public class Estacion extends Entity<EstacionId> {

    private Actividad actividad;
    private Detalle detalle;

    public Estacion(EstacionId estacionId) {
        super(estacionId);
    }

    public Estacion(EstacionId estacionId, Actividad actividad, Detalle detalle) {
        super(estacionId);
        this.actividad = actividad;
        this.detalle = detalle;
    }

    public void actualizarActividad(Actividad actividad) { this.actividad = Objects.requireNonNull(actividad, "La Actividad no puede ser nulo");}

    public void actualizarDetalle(Detalle detalle) { this.detalle = Objects.requireNonNull(detalle, "El Detalle no puede ser nulo");}

    public Actividad actividad() { return actividad; }

    public Detalle detalle() { return detalle; }
}
