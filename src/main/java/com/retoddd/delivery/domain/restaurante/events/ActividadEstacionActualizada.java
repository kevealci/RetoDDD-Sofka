package com.retoddd.delivery.domain.restaurante.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.restaurante.values.Actividad;
import com.retoddd.delivery.domain.restaurante.values.EstacionId;

public class ActividadEstacionActualizada extends DomainEvent {
    private final EstacionId estacionId;
    private final Actividad actividad;

    public ActividadEstacionActualizada(EstacionId estacionId, Actividad actividad) {
        super("delivery.restaurante.actividadestacionactualizada");
        this.estacionId = estacionId;
        this.actividad = actividad;
    }

    public EstacionId getEstacionId() {
        return estacionId;
    }

    public Actividad getActividad() {
        return actividad;
    }
}
