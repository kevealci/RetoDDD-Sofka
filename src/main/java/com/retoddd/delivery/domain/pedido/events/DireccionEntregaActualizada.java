package com.retoddd.delivery.domain.pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.Direccion;

public class DireccionEntregaActualizada extends DomainEvent {
    private final Direccion direccion;

    public DireccionEntregaActualizada(Direccion direccion) {
        super("delivery.pedido.direccionentregaactualizada");
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
