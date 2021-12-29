package com.retoddd.delivery.domain.pedido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.ClienteId;
import com.retoddd.delivery.domain.cliente.values.Direccion;
import com.retoddd.delivery.domain.pedido.events.*;
import com.retoddd.delivery.domain.pedido.values.PedidoId;
import com.retoddd.delivery.domain.pedido.values.Status;
import com.retoddd.delivery.domain.restaurante.values.RestauranteId;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Pedido extends AggregateEvent<PedidoId> {

    protected ClienteId clienteId;
    protected RestauranteId restauranteId;
    protected Set<Item> items;
    protected Factura factura;
    protected Entrega entrega;

    public Pedido(PedidoId pedidoId, ClienteId clienteId, RestauranteId restauranteId) {
        super(pedidoId);
        appendChange(new PedidoCreado(clienteId, restauranteId)).apply();
    }

    private Pedido(PedidoId pedidoId){
        super(pedidoId);
        subscribe(new PedidoChange(this));
    }

    public static Pedido from(PedidoId pedidoId, List<DomainEvent> events){
        var pedido = new Pedido(pedidoId);
        events.forEach(pedido::applyEvent);
        return pedido;
    }

    public void asociarCliente(ClienteId clienteId) {
        Objects.requireNonNull(clienteId, "El clienteId es requerido");
        appendChange(new ClienteAsociado(clienteId)).apply();
    }

    public void asociarRestaurante(RestauranteId restauranteId) {
        Objects.requireNonNull(restauranteId, "El restauranteId es requerido");
        appendChange(new RestauranteAsociado(restauranteId)).apply();
    }

    public void actualizarStatusEntrega(Status status) {
        Objects.requireNonNull(status, "El status es requerido");
        appendChange(new StatusEntregaActualizado(status)).apply();
    }

    public void actualizarDireccionEntrega(Direccion direccion) {
        Objects.requireNonNull(direccion, "La direccion es requerida");
        appendChange(new DireccionEntregaActualizada(direccion)).apply();
    }

    public ClienteId clienteId() {
        return clienteId;
    }

    public RestauranteId restauranteId() {
        return restauranteId;
    }

    public Set<Item> items() {
        return items;
    }

    public Factura factura() {
        return factura;
    }

    public Entrega entrega() {
        return entrega;
    }
}
