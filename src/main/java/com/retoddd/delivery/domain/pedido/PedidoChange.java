package com.retoddd.delivery.domain.pedido;

import co.com.sofka.domain.generic.EventChange;
import com.retoddd.delivery.domain.pedido.events.*;
import com.retoddd.delivery.domain.pedido.values.EntregaId;

import java.util.HashSet;

public class PedidoChange extends EventChange {

    public PedidoChange(Pedido pedido) {

        apply( (PedidoCreado event) -> {
            pedido.clienteId = event.getClienteId();
            pedido.restauranteId = event.getRestauranteId();
            pedido.items = new HashSet<>();
            pedido.entrega = new Entrega(EntregaId.of("aaaa"));
        });

        apply( (ClienteAsociado event) -> {
            pedido.clienteId = event.getClienteId();
        });

        apply( (RestauranteAsociado event) -> {
            pedido.restauranteId = event.getRestauranteId();
        });

        apply( (DireccionEntregaActualizada event) -> {
            pedido.entrega.actualizarDireccion(event.getDireccion());
        });

        apply( (StatusEntregaActualizado event) -> {
            pedido.entrega.actualizarStatus(event.getStatus());
        });
    }
}
