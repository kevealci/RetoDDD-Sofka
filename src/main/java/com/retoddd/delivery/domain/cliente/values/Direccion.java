package com.retoddd.delivery.domain.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<String> {
    private final String value;

    public Direccion(String value){
        this.value = Objects.requireNonNull(value, "La direccion es requerida");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("La direccion no puede estar vacia");
        }
        if(this.value.length() > 100){
            throw new IllegalArgumentException("La direccion no debe tener mas de 100 caracteres");
        }
        if(this.value.length() < 5){
            throw new IllegalArgumentException("La direccion no debe tener menos de 5 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direccion)) return false;
        Direccion direccion = (Direccion) o;
        return value.equals(direccion.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
