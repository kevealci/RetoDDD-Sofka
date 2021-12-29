package com.retoddd.delivery.domain.cliente.commands;

import co.com.sofka.domain.generic.Command;
import com.retoddd.delivery.domain.cliente.values.ClienteId;
import com.retoddd.delivery.domain.cliente.values.Direccion;
import com.retoddd.delivery.domain.cliente.values.InformacionId;

public class ActualizarDireccionInformacion extends Command {

    private final ClienteId clienteId;
    private final InformacionId informacionId;
    private final Direccion direccion;

    public ActualizarDireccionInformacion(ClienteId clienteId, InformacionId informacionId, Direccion direccion) {
        this.clienteId = clienteId;
        this.informacionId = informacionId;
        this.direccion = direccion;
    }

    public ClienteId getClienteId() { return clienteId; }

    public InformacionId getInformacionId() { return informacionId; }

    public Direccion getDireccion() { return direccion; }
}
