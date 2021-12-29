package com.retoddd.delivery.domain.cliente.commands;

import co.com.sofka.domain.generic.Command;
import com.retoddd.delivery.domain.cliente.values.ClienteId;
import com.retoddd.delivery.domain.cliente.values.InformacionId;
import com.retoddd.delivery.domain.cliente.values.Nombre;

public class ActualizarNombreInformacion extends Command {

    private final ClienteId clienteId;
    private final InformacionId informacionId;
    private final Nombre nombre;

    public ActualizarNombreInformacion(ClienteId clienteId, InformacionId informacionId, Nombre nombre) {
        this.clienteId = clienteId;
        this.informacionId = informacionId;
        this.nombre = nombre;
    }

    public ClienteId getClienteId() { return clienteId; }

    public InformacionId getInformacionId() { return informacionId; }

    public Nombre getNombre() { return nombre; }
}
