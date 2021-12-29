package com.retoddd.delivery.domain.cliente.commands;

import co.com.sofka.domain.generic.Command;
import com.retoddd.delivery.domain.cliente.Informacion;
import com.retoddd.delivery.domain.cliente.values.ClienteId;

public class CrearCliente extends Command {

    private final ClienteId clienteId;
    private final Informacion informacion;

    public CrearCliente(ClienteId clienteId, Informacion informacion) {
        this.clienteId = clienteId;
        this.informacion = informacion;
    }

    public ClienteId getClienteId() { return clienteId; }

    public Informacion getInformacion() { return informacion; }
}
