package com.retoddd.delivery.domain.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Impuesto implements ValueObject<Double> {
    private final Double value;

    public Impuesto(Double value){
        this.value = Objects.requireNonNull(value, "El impuesto es requerido");
        if(this.value <= 0D){
            throw new IllegalArgumentException("El Impuesto debe ser mayor a 0");
        }
        if(this.value.toString().length() > 20D){
            throw new IllegalArgumentException("El Impuesto no puede ser mayor a 20");
        }
    }

    @Override
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Impuesto)) return false;
        Impuesto impuesto = (Impuesto) o;
        return value.equals(impuesto.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
