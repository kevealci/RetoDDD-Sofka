package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.Direccion;
import com.retoddd.delivery.domain.cliente.values.Nombre;
import com.retoddd.delivery.domain.restaurante.Informacion;
import com.retoddd.delivery.domain.restaurante.commands.ActualizarActividadEstacion;
import com.retoddd.delivery.domain.restaurante.events.ActividadEstacionActualizada;
import com.retoddd.delivery.domain.restaurante.events.RestauranteCreado;
import com.retoddd.delivery.domain.restaurante.values.Actividad;
import com.retoddd.delivery.domain.restaurante.values.EstacionId;
import com.retoddd.delivery.domain.restaurante.values.InformacionId;
import com.retoddd.delivery.domain.restaurante.values.RestauranteId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarActividadEstacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarActividadEstacion() {

        RestauranteId restauranteId = RestauranteId.of("aaaa");
        EstacionId estacionId = EstacionId.of("bbbb");
        Actividad actividad = new Actividad("cocinar");

        var command = new ActualizarActividadEstacion(restauranteId, estacionId, actividad);
        var usecase = new ActualizarActividadEstacionUseCase();

        when(repository.getEventsBy("aaaa")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(restauranteId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ActividadEstacionActualizada) events.get(0);

        Assertions.assertEquals("cocinar", event.getActividad().value());
        Mockito.verify(repository).getEventsBy("aaaa");
    }

    private List<DomainEvent> events() {
        InformacionId informacionId = InformacionId.of("yyyy");
        Nombre nombre = new Nombre("aaaaa");
        Direccion direccion = new Direccion("bbbbb");
        Informacion informacion = new Informacion(informacionId, nombre, direccion);
        return List.of(
                new RestauranteCreado(informacion)
        );
    }
}