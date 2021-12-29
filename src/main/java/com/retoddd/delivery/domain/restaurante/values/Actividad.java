package com.retoddd.delivery.domain.restaurante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Actividad implements ValueObject<String> {
    private final String value;

    public Actividad(String value){
        this.value = Objects.requireNonNull(value, "La actividad es requerida");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("La actividad no puede estar vacia");
        }
        if(this.value.length() > 50){
            throw new IllegalArgumentException("La actividad no debe tener mas de 100 caracteres");
        }
        if(this.value.length() < 5){
            throw new IllegalArgumentException("La actividad no debe tener menos de 5 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actividad)) return false;
        Actividad actividad = (Actividad) o;
        return value.equals(actividad.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
