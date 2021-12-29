package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.retoddd.delivery.domain.restaurante.Restaurante;
import com.retoddd.delivery.domain.restaurante.commands.ActualizarActividadEstacion;

public class ActualizarActividadEstacionUseCase extends UseCase<RequestCommand<ActualizarActividadEstacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarActividadEstacion> actualizarActividadEstacionRequestCommand) {
        var command = actualizarActividadEstacionRequestCommand.getCommand();
        var restaurante = Restaurante.from(command.getRestauranteId(), retrieveEvents());
        restaurante.actualizarActividadEstacion(command.getEstacionId(),command.getActividad());
        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
