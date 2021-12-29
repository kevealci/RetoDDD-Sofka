package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.retoddd.delivery.domain.pedido.Pedido;
import com.retoddd.delivery.domain.pedido.commands.AsociarCliente;

public class AsociarClienteUseCase extends UseCase<RequestCommand<AsociarCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsociarCliente> asociarClienteRequestCommand) {
        var command = asociarClienteRequestCommand.getCommand();
        var pedido = Pedido.from(command.getPedidoId(), retrieveEvents());
        pedido.asociarCliente(command.getClienteId());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
