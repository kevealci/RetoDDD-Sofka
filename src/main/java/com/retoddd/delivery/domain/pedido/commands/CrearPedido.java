package com.retoddd.delivery.domain.pedido.commands;

import co.com.sofka.domain.generic.Command;
import com.retoddd.delivery.domain.cliente.values.ClienteId;
import com.retoddd.delivery.domain.pedido.values.PedidoId;
import com.retoddd.delivery.domain.restaurante.values.RestauranteId;

public class CrearPedido extends Command {

    private final PedidoId pedidoId;
    private final ClienteId clienteId;
    private final RestauranteId restauranteId;

    public CrearPedido(PedidoId pedidoId, ClienteId clienteId, RestauranteId restauranteId) {
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.restauranteId = restauranteId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }
}
