package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.retoddd.delivery.domain.cliente.Cliente;
import com.retoddd.delivery.domain.cliente.commands.CrearCliente;

public class CrearClienteUseCase extends UseCase<RequestCommand<CrearCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCliente> crearClienteRequestCommand) {
        var command = crearClienteRequestCommand.getCommand();
        var cliente = new Cliente(command.getClienteId(),command.getInformacion());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
