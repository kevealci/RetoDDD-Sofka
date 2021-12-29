package com.retoddd.delivery.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.restaurante.values.RestauranteId;

public class RestauranteAsociado extends DomainEvent {
    private final RestauranteId restauranteId;

    public RestauranteAsociado(RestauranteId restauranteId) {
        super("delivery.pedido.restauranteasociado");
        this.restauranteId = restauranteId;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }
}
