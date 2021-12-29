package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.retoddd.delivery.domain.pedido.Pedido;
import com.retoddd.delivery.domain.pedido.commands.CrearPedido;

public class CrearPedidoUseCase extends UseCase<RequestCommand<CrearPedido>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPedido> crearPedidoRequestCommand) {
        var command = crearPedidoRequestCommand.getCommand();
        var pedido = new Pedido(command.getPedidoId(),command.getClienteId(), command.getRestauranteId());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
