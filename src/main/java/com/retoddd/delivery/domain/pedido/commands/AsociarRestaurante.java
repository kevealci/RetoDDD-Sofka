package com.retoddd.delivery.domain.pedido.commands;

import co.com.sofka.domain.generic.Command;
import com.retoddd.delivery.domain.pedido.values.PedidoId;
import com.retoddd.delivery.domain.restaurante.values.RestauranteId;

public class AsociarRestaurante extends Command {

    private final PedidoId pedidoId;
    private final RestauranteId restauranteId;

    public AsociarRestaurante(PedidoId pedidoId, RestauranteId restauranteId) {
        this.pedidoId = pedidoId;
        this.restauranteId = restauranteId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }
}
