package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.retoddd.delivery.domain.pedido.Pedido;
import com.retoddd.delivery.domain.pedido.commands.AsociarRestaurante;

public class AsociarRestauranteUseCase extends UseCase<RequestCommand<AsociarRestaurante>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsociarRestaurante> asociarRestauranteRequestCommand) {
        var command = asociarRestauranteRequestCommand.getCommand();
        var pedido = Pedido.from(command.getPedidoId(), retrieveEvents());
        pedido.asociarRestaurante(command.getRestauranteId());
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
