package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.retoddd.delivery.domain.restaurante.Restaurante;
import com.retoddd.delivery.domain.restaurante.commands.CrearRestaurante;

public class CrearRestauranteUseCase extends UseCase<RequestCommand<CrearRestaurante>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearRestaurante> crearRestauranteRequestCommand) {
        var command =  crearRestauranteRequestCommand.getCommand();
        var restaurante = new Restaurante(command.getRestauranteId(), command.getInformacion());
        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
