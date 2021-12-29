package com.retoddd.delivery.domain.restaurante;

import co.com.sofka.domain.generic.EventChange;
import com.retoddd.delivery.domain.restaurante.events.*;
import com.retoddd.delivery.domain.restaurante.values.EstacionId;

import java.util.HashSet;

public class RestauranteChange extends EventChange {

    public RestauranteChange(Restaurante restaurante) {

        apply( (RestauranteCreado event) -> {
            restaurante.informacion = event.getInformacion();
            restaurante.ventas = new HashSet<>();
            restaurante.estacion = new Estacion(EstacionId.of("aaaa"));
        });

        apply( (VentaAgregada event) -> {
            restaurante.ventas.add(new Venta(event.getVentaId(),
                    event.getSubTotal(),
                    event.getImpuesto(),
                    event.getTotal(),
                    event.getDetalle()));
        });

        apply( (ActividadEstacionActualizada event) -> {
            restaurante.estacion.actualizarActividad(event.getActividad());
        });

        apply( (DetalleEstacionActualizado event) -> {
            restaurante.estacion.actualizarDetalle(event.getDetalle());
        });

        apply( (DetalleVentaActualizado event) -> {
            var venta = restaurante.getVentaPorId(event.getVentaId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra la venta"));
            venta.actualizarDetalle(event.getDetalle());
        });
    }
}
