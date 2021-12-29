package com.retoddd.delivery.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<Double> {
    private final Double value;

    public Precio(Double value){
        this.value = Objects.requireNonNull(value);
        if(this.value <= 0D){
            throw new IllegalArgumentException("El Precio debe ser mayor a 0");
        }
        if(this.value.toString().length() > 1000D){
            throw new IllegalArgumentException("El Precio no puede ser mayor a 1000");
        }
    }

    @Override
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Precio)) return false;
        Precio precio = (Precio) o;
        return value.equals(precio.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
