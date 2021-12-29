package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.retoddd.delivery.domain.restaurante.Restaurante;
import com.retoddd.delivery.domain.restaurante.commands.ActualizarDetalleEstacion;

public class ActualizarDetalleEstacionUseCase extends UseCase<RequestCommand<ActualizarDetalleEstacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDetalleEstacion> actualizarDetalleEstacionRequestCommand) {
        var command = actualizarDetalleEstacionRequestCommand.getCommand();
        var restaurante = Restaurante.from(command.getRestauranteId(), retrieveEvents());
        restaurante.actualizarDetalleEstacion(command.getEstacionId(), command.getDetalle());
        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
