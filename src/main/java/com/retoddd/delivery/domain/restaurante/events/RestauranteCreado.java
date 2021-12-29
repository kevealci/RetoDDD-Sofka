package com.retoddd.delivery.domain.restaurante.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.restaurante.Informacion;

public class RestauranteCreado extends DomainEvent {
    private final Informacion informacion;

    public RestauranteCreado(Informacion informacion) {
        super("delivery.restaurante.restaurantecreado");
        this.informacion = informacion;
    }

    public Informacion getInformacion() { return informacion; }
}
