package com.retoddd.delivery.domain.restaurante.commands;

import co.com.sofka.domain.generic.Command;
import com.retoddd.delivery.domain.restaurante.Informacion;
import com.retoddd.delivery.domain.restaurante.values.RestauranteId;

public class CrearRestaurante extends Command {

    private final RestauranteId restauranteId;
    private final Informacion informacion;

    public CrearRestaurante(RestauranteId restauranteId, Informacion informacion) {
        this.restauranteId = restauranteId;
        this.informacion = informacion;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public Informacion getInformacion() {
        return informacion;
    }
}
