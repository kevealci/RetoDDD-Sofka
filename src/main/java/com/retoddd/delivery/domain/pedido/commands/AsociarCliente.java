package com.retoddd.delivery.domain.pedido.commands;

import co.com.sofka.domain.generic.Command;
import com.retoddd.delivery.domain.cliente.values.ClienteId;
import com.retoddd.delivery.domain.pedido.values.PedidoId;

public class AsociarCliente extends Command {

    private final PedidoId pedidoId;
    private final ClienteId clienteId;

    public AsociarCliente(PedidoId pedidoId, ClienteId clienteId) {
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
