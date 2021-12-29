package com.retoddd.delivery.domain.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Detalle implements ValueObject<String> {
    private final String value;

    public Detalle(String value){
        this.value = Objects.requireNonNull(value, "El detalle es requerido");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El detalle no puede estar vacío");
        }
        if(this.value.length() > 100){
            throw new IllegalArgumentException("El detalle no debe tener mas de 100 caracteres");
        }
        if(this.value.length() < 5){
            throw new IllegalArgumentException("El detalle no debe tener menos de 5 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Detalle)) return false;
        Detalle detalle = (Detalle) o;
        return value.equals(detalle.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
