package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.retoddd.delivery.domain.cliente.values.Direccion;
import com.retoddd.delivery.domain.cliente.values.Nombre;
import com.retoddd.delivery.domain.restaurante.Informacion;
import com.retoddd.delivery.domain.restaurante.commands.CrearRestaurante;
import com.retoddd.delivery.domain.restaurante.events.RestauranteCreado;
import com.retoddd.delivery.domain.restaurante.values.InformacionId;
import com.retoddd.delivery.domain.restaurante.values.RestauranteId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearRestauranteUseCaseTest {

    @Test
    void crearRestaurante() {

        RestauranteId restauranteId = RestauranteId.of("xxxx");
        InformacionId informacionId = InformacionId.of("yyyy");
        Nombre nombre = new Nombre("aaaaa");
        Direccion direccion = new Direccion("bbbbb");
        Informacion informacion = new Informacion(informacionId, nombre, direccion);

        var command = new CrearRestaurante(restauranteId, informacion);
        var usecase = new CrearRestauranteUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        var event = (RestauranteCreado) events.getDomainEvents().get(0);

        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("yyyy", event.getInformacion().identity().value());
        Assertions.assertEquals("aaaaa", event.getInformacion().nombre().value());
        Assertions.assertEquals("bbbbb", event.getInformacion().direccion().value());
    }

}