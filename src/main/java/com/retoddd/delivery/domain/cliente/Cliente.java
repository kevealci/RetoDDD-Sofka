package com.retoddd.delivery.domain.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.events.*;
import com.retoddd.delivery.domain.cliente.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Cliente extends AggregateEvent<ClienteId> {

    protected Informacion informacion;
    protected Set<Compra> compras;
    protected Pago pago;

    public Cliente(ClienteId entityId, Informacion informacion) {
        super(entityId);
        appendChange(new ClienteCreado(informacion)).apply();
    }

    private Cliente(ClienteId clienteId){
        super(clienteId);
        subscribe(new ClienteChange(this));
    }

    public static Cliente from(ClienteId clienteId, List<DomainEvent> events){
        var cliente = new Cliente(clienteId);
        events.forEach(cliente::applyEvent);
        return cliente;
    }

    public void agregarCompra(CompraId compraId, SubTotal subTotal, Impuesto impuesto, Total total, Detalle detalle) {
        Objects.requireNonNull(compraId, "El compraId es requerida");
        Objects.requireNonNull(subTotal, "El subtotal es requerido");
        Objects.requireNonNull(impuesto, "El impuesto es requerido");
        Objects.requireNonNull(total, "El total es requerido");
        Objects.requireNonNull(detalle, "El detalle es requerido");
        appendChange(new CompraAgregada(compraId, subTotal, impuesto, total, detalle)).apply();
    }

    public void actualizarNombreInformacion(InformacionId informacionId, Nombre nombre) {
        Objects.requireNonNull(informacionId, "La informacionId es requerida");
        Objects.requireNonNull(nombre, "El nombre es requerido");
        appendChange(new NombreInformacionActualizado(informacionId, nombre)).apply();
    }

    public void actualizarDireccionInformacion(InformacionId informacionId, Direccion direccion) {
        Objects.requireNonNull(informacionId, "La informacionId es requerida");
        Objects.requireNonNull(direccion, "La direccion es requerida");
        appendChange(new DireccionInformacionActualizada(informacionId, direccion)).apply();
    }

    public void actualizarEfectivoPago(PagoId pagoId, Efectivo efectivo) {
        Objects.requireNonNull(pagoId, "El pagoId es requerido");
        Objects.requireNonNull(efectivo, "\"El efectivo es requerido\"");
        appendChange(new EfectivoPagoActualizado(pagoId, efectivo)).apply();
    }


    public Informacion informacion() { return informacion; }

    public Set<Compra> compras() { return compras; }

    public Pago pago() { return pago; }
}
