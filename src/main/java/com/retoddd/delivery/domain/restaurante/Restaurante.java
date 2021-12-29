package com.retoddd.delivery.domain.restaurante;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.*;
import com.retoddd.delivery.domain.restaurante.events.*;
import com.retoddd.delivery.domain.restaurante.values.Actividad;
import com.retoddd.delivery.domain.restaurante.values.EstacionId;
import com.retoddd.delivery.domain.restaurante.values.RestauranteId;
import com.retoddd.delivery.domain.restaurante.values.VentaId;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Restaurante extends AggregateEvent<RestauranteId> {
    protected Set<Venta> ventas;
    protected Informacion informacion;
    protected Estacion estacion;

    public Restaurante(RestauranteId restauranteId, Informacion informacion) {
        super(restauranteId);
        appendChange(new RestauranteCreado(informacion)).apply();
    }

    private Restaurante(RestauranteId restauranteId){
        super(restauranteId);
        subscribe(new RestauranteChange(this));
    }

    public static Restaurante from(RestauranteId restauranteId, List<DomainEvent> events){
        var restaurante = new Restaurante(restauranteId);
        events.forEach(restaurante::applyEvent);
        return restaurante;
    }

    public void agregarVenta(VentaId ventaId, SubTotal subTotal, Impuesto impuesto, Total total, Detalle detalle) {
        Objects.requireNonNull(ventaId, "El compraId es requerida");
        Objects.requireNonNull(subTotal, "El subtotal es requerido");
        Objects.requireNonNull(impuesto, "El impuesto es requerido");
        Objects.requireNonNull(total, "El total es requerido");
        Objects.requireNonNull(detalle, "El detalle es requerido");
        appendChange(new VentaAgregada(ventaId, subTotal, impuesto, total, detalle)).apply();
    }

    public void actualizarActividadEstacion(EstacionId estacionId, Actividad actividad) {
        Objects.requireNonNull(estacionId, "La estacionId es requerida");
        Objects.requireNonNull(actividad, "La actividad es requerida");
        appendChange(new ActividadEstacionActualizada(estacionId, actividad)).apply();
    }

    public void actualizarDetalleEstacion(EstacionId estacionId, Detalle detalle) {
        Objects.requireNonNull(estacionId, "La estacionId es requerida");
        Objects.requireNonNull(detalle, "El detalle es requerido");
        appendChange(new DetalleEstacionActualizado(estacionId, detalle)).apply();
    }

    public void actualizarDetalleVenta(VentaId ventaId, Detalle detalle) {
        Objects.requireNonNull(ventaId, "La estacionId es requerida");
        Objects.requireNonNull(detalle, "El detalle es requerido");
        appendChange(new DetalleVentaActualizado(ventaId, detalle)).apply();
    }

    public Optional<Venta> getVentaPorId(VentaId ventaId){
        return ventas
                .stream()
                .filter( venta -> venta.identity().equals(ventaId))
                .findFirst();
    }

    public Set<Venta> ventas() {
        return ventas;
    }

    public Informacion informacion() {
        return informacion;
    }

    public Estacion estacion() {
        return estacion;
    }
}
