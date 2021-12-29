package com.retoddd.delivery.domain.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Efectivo implements ValueObject<Double> {
    private final Double value;

    public Efectivo(Double value){
        this.value = Objects.requireNonNull(value, "El valor es requerido");
        if(this.value < 0D){
            throw new IllegalArgumentException("El Efectivo debe ser mayor o igual a 0");
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
        if (!(o instanceof Efectivo)) return false;
        Efectivo efectivo = (Efectivo) o;
        return value.equals(efectivo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
