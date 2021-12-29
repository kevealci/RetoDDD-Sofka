package com.retoddd.delivery.domain.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Total implements ValueObject<Double> {
    private final Double value;

    public Total(Double value){
        this.value = Objects.requireNonNull(value, "El total es requerido");
        if(this.value <= 0D){
            throw new IllegalArgumentException("El Total debe ser mayor a 0");
        }
        if(this.value.toString().length() > 3000D){
            throw new IllegalArgumentException("El Total no puede ser mayor a 5000");
        }
    }

    @Override
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Total)) return false;
        Total total = (Total) o;
        return value.equals(total.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
