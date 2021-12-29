package com.retoddd.delivery.domain.pedido;

import co.com.sofka.domain.generic.Entity;
import com.retoddd.delivery.domain.cliente.values.Direccion;
import com.retoddd.delivery.domain.pedido.values.EntregaId;
import com.retoddd.delivery.domain.pedido.values.Repartidor;
import com.retoddd.delivery.domain.pedido.values.Status;

import java.util.Objects;

public class Entrega extends Entity<EntregaId> {

    private Repartidor repartidor;
    private Status status;
    private Direccion direccion;

    public Entrega(EntregaId entregaId, Repartidor repartidor, Status status, Direccion direccion) {
        super(entregaId);
        this.repartidor = repartidor;
        this.status = status;
        this.direccion = direccion;
    }

    public void actualizarStatus(Status status) {
        this.status = Objects.requireNonNull(status, "El estatus no puede ser nulo");
    }

    public void actualizarDireccion(Direccion direccion) {
        this.direccion = Objects.requireNonNull(direccion, "La direccion no puede ser nula");
    }

    public Repartidor repartidor() {
        return repartidor;
    }

    public Status status() {
        return status;
    }

    public Direccion direccion() {
        return direccion;
    }
}
