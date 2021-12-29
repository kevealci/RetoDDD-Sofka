package com.retoddd.delivery.domain.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.retoddd.delivery.domain.cliente.values.Efectivo;
import com.retoddd.delivery.domain.cliente.values.PagoId;

public class EfectivoPagoActualizado extends DomainEvent {
    private final PagoId pagoId;
    private final Efectivo efectivo;

    public EfectivoPagoActualizado(PagoId pagoId, Efectivo efectivo) {
        super("delivery.cliente.efectivopagoactualizado");
        this.pagoId = pagoId;
        this.efectivo = efectivo;
    }

    public PagoId getPagoId() { return pagoId;  }

    public Efectivo getEfectivo() { return efectivo; }
}
