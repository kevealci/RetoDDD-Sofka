package com.retoddd.delivery.domain.cliente;

import co.com.sofka.domain.generic.EventChange;
import com.retoddd.delivery.domain.cliente.events.*;
import com.retoddd.delivery.domain.cliente.values.InformacionId;
import com.retoddd.delivery.domain.cliente.values.PagoId;

import java.util.HashSet;

public class ClienteChange extends EventChange {

    public ClienteChange(Cliente cliente) {

        apply( (ClienteCreado event) -> {
            cliente.informacion = event.getInformacion();
            cliente.compras = new HashSet<>();
            cliente.pago = new Pago(PagoId.of("aaaa"));
        });

        apply( (CompraAgregada event) -> {
            cliente.compras.add(new Compra(event.getCompraId(),
                    event.getSubTotal(),
                    event.getImpuesto(),
                    event.getTotal(),
                    event.getDetalle()));
        });

        apply( (DireccionInformacionActualizada event) -> {
            cliente.informacion.actualizarDireccion(event.getDireccion());
        });

        apply( (EfectivoPagoActualizado event) -> {
            cliente.pago.actualizarEfectivo(event.getEfectivo());
        });

        apply( (NombreInformacionActualizado event) -> {
            cliente.informacion.actualizarNombre(event.getNombre());
        });
    }
}
