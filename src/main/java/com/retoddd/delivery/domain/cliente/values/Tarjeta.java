package com.retoddd.delivery.domain.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tarjeta implements ValueObject<String> {
    private final String value;

    public Tarjeta(String value){
        this.value = Objects.requireNonNull(value, "La tarjeta es requerida");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("La tarjeta no puede estar vacia");
        }
        if(this.value.length() > 20){
            throw new IllegalArgumentException("La tarjeta no debe tener mas de 20 caracteres");
        }
        if(this.value.length() < 5){
            throw new IllegalArgumentException("La tarjeta no debe tener menos de 5 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarjeta)) return false;
        Tarjeta tarjeta = (Tarjeta) o;
        return value.equals(tarjeta.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
