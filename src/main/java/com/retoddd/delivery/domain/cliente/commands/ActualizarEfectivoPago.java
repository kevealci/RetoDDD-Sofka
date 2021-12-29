package com.retoddd.delivery.domain.cliente.commands;

import co.com.sofka.domain.generic.Command;
import com.retoddd.delivery.domain.cliente.values.ClienteId;
import com.retoddd.delivery.domain.cliente.values.Efectivo;
import com.retoddd.delivery.domain.cliente.values.PagoId;

public class ActualizarEfectivoPago extends Command {

    private final ClienteId clienteId;
    private final PagoId pagoId;
    private final Efectivo efectivo;

    public ActualizarEfectivoPago(ClienteId clienteId, PagoId pagoId, Efectivo efectivo) {
        this.clienteId = clienteId;
        this.pagoId = pagoId;
        this.efectivo = efectivo;
    }

    public ClienteId getClienteId() { return clienteId; }

    public PagoId getPagoId() { return pagoId; }

    public Efectivo getEfectivo() { return efectivo; }
}
