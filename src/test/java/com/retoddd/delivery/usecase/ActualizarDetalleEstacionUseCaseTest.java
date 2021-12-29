package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.Detalle;
import com.retoddd.delivery.domain.cliente.values.Direccion;
import com.retoddd.delivery.domain.cliente.values.Nombre;
import com.retoddd.delivery.domain.restaurante.Informacion;
import com.retoddd.delivery.domain.restaurante.commands.ActualizarDetalleEstacion;
import com.retoddd.delivery.domain.restaurante.events.ActividadEstacionActualizada;
import com.retoddd.delivery.domain.restaurante.events.DetalleEstacionActualizado;
import com.retoddd.delivery.domain.restaurante.events.RestauranteCreado;
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
class ActualizarDetalleEstacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarDetalleEstacion() {

        RestauranteId restauranteId = RestauranteId.of("aaaa");
        EstacionId estacionId = EstacionId.of("bbbb");
        Detalle detalle = new Detalle("xxxxx");

        var command = new ActualizarDetalleEstacion(restauranteId, estacionId, detalle);
        var usecase = new ActualizarDetalleEstacionUseCase();

        when(repository.getEventsBy("aaaa")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(restauranteId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DetalleEstacionActualizado) events.get(0);

        Assertions.assertEquals("xxxxx", event.getDetalle().value());
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
    };
}