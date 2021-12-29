package com.retoddd.delivery.domain.pedido.commands;

import co.com.sofka.domain.generic.Command;
import com.retoddd.delivery.domain.pedido.values.PedidoId;
import com.retoddd.delivery.domain.pedido.values.Status;

public class ActualizarStatusEntrega extends Command {

    private final PedidoId pedidoId;
    private final Status status;

    public ActualizarStatusEntrega(PedidoId pedidoId, Status status) {
        this.pedidoId = pedidoId;
        this.status = status;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public Status getStatus() {
        return status;
    }
}
