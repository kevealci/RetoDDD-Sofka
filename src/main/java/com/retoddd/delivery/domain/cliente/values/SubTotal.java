package com.retoddd.delivery.domain.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class SubTotal implements ValueObject<Integer> {
    private final Integer value;

    public SubTotal(Integer value){
        this.value = Objects.requireNonNull(value, "El subtotal es requerido");
        if(this.value < 0){
            throw new IllegalArgumentException("El Subtotal debe ser mayor a 0");
        }
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubTotal)) return false;
        SubTotal subTotal = (SubTotal) o;
        return value.equals(subTotal.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
