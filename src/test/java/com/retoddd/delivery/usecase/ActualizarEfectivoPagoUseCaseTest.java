package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.commands.ActualizarEfectivoPago;
import com.retoddd.delivery.domain.cliente.events.ClienteCreado;
import com.retoddd.delivery.domain.cliente.events.EfectivoPagoActualizado;
import com.retoddd.delivery.domain.cliente.values.*;
import com.retoddd.delivery.domain.cliente.Informacion;
import com.retoddd.delivery.domain.cliente.values.InformacionId;
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
class ActualizarEfectivoPagoUseCaseTest {


    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarEfectivoPago() {

        ClienteId clienteId = ClienteId.of("aaaa");
        PagoId pagoId = PagoId.of("bbbb");
        Efectivo efectivo = new Efectivo(200D);

        var command = new ActualizarEfectivoPago(clienteId, pagoId, efectivo);
        var usecase = new ActualizarEfectivoPagoUseCase();

        when(repository.getEventsBy("aaaa")).thenReturn(events());

        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(clienteId.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (EfectivoPagoActualizado) events.get(0);

        Assertions.assertEquals(200D, event.getEfectivo().value());
        Mockito.verify(repository).getEventsBy("aaaa");

    }

    private List<DomainEvent> events() {
        InformacionId informacionId = InformacionId.of("yyyy");
        Nombre nombre = new Nombre("aaaaa");
        Direccion direccion = new Direccion("bbbbb");
        Informacion informacion = new Informacion(informacionId, nombre, direccion);
        return List.of(
                new ClienteCreado(informacion)
        );
    }
}