package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.retoddd.delivery.domain.cliente.Cliente;
import com.retoddd.delivery.domain.cliente.commands.ActualizarEfectivoPago;

public class ActualizarEfectivoPagoUseCase extends UseCase<RequestCommand<ActualizarEfectivoPago>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEfectivoPago> actualizarEfectivoPagoRequestCommand) {
        var command = actualizarEfectivoPagoRequestCommand.getCommand();
        var cliente = Cliente.from(command.getClienteId(), retrieveEvents());
        cliente.actualizarEfectivoPago(command.getPagoId(), command.getEfectivo());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
