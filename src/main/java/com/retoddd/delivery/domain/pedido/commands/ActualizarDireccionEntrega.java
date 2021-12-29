package com.retoddd.delivery.domain.pedido.commands;

import co.com.sofka.domain.generic.Command;
import com.retoddd.delivery.domain.cliente.values.Direccion;
import com.retoddd.delivery.domain.pedido.values.PedidoId;

public class ActualizarDireccionEntrega extends Command {

    private final PedidoId pedidoId;
    private final Direccion direccion;

    public ActualizarDireccionEntrega(PedidoId pedidoId, Direccion direccion) {
        this.pedidoId = pedidoId;
        this.direccion = direccion;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
