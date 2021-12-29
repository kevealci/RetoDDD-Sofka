package com.retoddd.delivery.domain.cliente;

import co.com.sofka.domain.generic.Entity;
import com.retoddd.delivery.domain.cliente.values.*;

import java.util.Objects;

public class Pago extends Entity<PagoId> {

    private Efectivo efectivo;
    private Tarjeta tarjeta;

    public Pago(PagoId pagoId, Efectivo efectivo, Tarjeta tarjeta) {
        super(pagoId);
        this.efectivo = efectivo;
        this.tarjeta = tarjeta;
    }

    public void actualizarEfectivo(Efectivo efectivo) { this.efectivo = Objects.requireNonNull(efectivo, "El efectivo no puede ser nulo");}

    public void actualizarTarjeta(Tarjeta tarjeta) { this.tarjeta = Objects.requireNonNull(tarjeta, "La tarjeta no puede ser nula");}

    public Efectivo efectivo() { return efectivo; }

    public Tarjeta tarjeta() { return tarjeta; }
}
