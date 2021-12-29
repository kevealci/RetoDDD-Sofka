package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.retoddd.delivery.domain.pedido.Pedido;
import com.retoddd.delivery.domain.pedido.commands.ActualizarDireccionEntrega;

public class ActualizarDireccionEntregaUseCase extends UseCase<RequestCommand<ActualizarDireccionEntrega>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDireccionEntrega> actualizarDireccionEntregaRequestCommand) {
        var command = actualizarDireccionEntregaRequestCommand.getCommand();
        var pedido = Pedido.from(command.getPedidoId(), retrieveEvents());
        pedido.actualizarDireccionEntrega(command.getDireccion());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
