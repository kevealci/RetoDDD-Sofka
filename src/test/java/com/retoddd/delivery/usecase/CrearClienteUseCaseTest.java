package com.retoddd.delivery.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.retoddd.delivery.domain.cliente.commands.CrearCliente;
import com.retoddd.delivery.domain.cliente.events.ClienteCreado;
import com.retoddd.delivery.domain.cliente.values.ClienteId;
import com.retoddd.delivery.domain.cliente.values.Direccion;
import com.retoddd.delivery.domain.cliente.values.Nombre;
import com.retoddd.delivery.domain.cliente.Informacion;
import com.retoddd.delivery.domain.cliente.values.InformacionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearClienteUseCaseTest {

    @Test
    void crearCliente() {
        ClienteId clienteId = ClienteId.of("xxxx");
        InformacionId informacionId = InformacionId.of("yyyy");
        Nombre nombre = new Nombre("aaaaa");
        Direccion direccion = new Direccion("bbbbb");
        Informacion informacion = new Informacion(informacionId, nombre, direccion);

        var command = new CrearCliente(clienteId, informacion);
        var usecase = new CrearClienteUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow();

        var event = (ClienteCreado) events.getDomainEvents().get(0);

        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("yyyy", event.getInformacion().identity().value());
        Assertions.assertEquals("aaaaa", event.getInformacion().nombre().value());
        Assertions.assertEquals("bbbbb", event.getInformacion().direccion().value());

    }

}