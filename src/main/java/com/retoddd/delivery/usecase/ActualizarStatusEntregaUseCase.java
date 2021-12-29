package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.retoddd.delivery.domain.pedido.Pedido;
import com.retoddd.delivery.domain.pedido.commands.ActualizarStatusEntrega;

public class ActualizarStatusEntregaUseCase extends UseCase<RequestCommand<ActualizarStatusEntrega>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarStatusEntrega> actualizarStatusEntregaRequestCommand) {
        var command =  actualizarStatusEntregaRequestCommand.getCommand();
        var pedido = Pedido.from(command.getPedidoId(), retrieveEvents());
        pedido.actualizarStatusEntrega(command.getStatus());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
