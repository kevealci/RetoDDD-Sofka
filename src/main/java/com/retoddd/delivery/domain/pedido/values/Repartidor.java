package com.retoddd.delivery.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Repartidor implements ValueObject<String> {
    private final String value;

    public Repartidor(String value){
        this.value = Objects.requireNonNull(value, "El repartidor es requerido");
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El repartidor no puede estar vacio");
        }
        if(this.value.length() > 20){
            throw new IllegalArgumentException("El repartidor no debe tener mas de 20 caracteres");
        }
        if(this.value.length() < 5){
            throw new IllegalArgumentException("El repartidor no debe tener menos de 5 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Repartidor)) return false;
        Repartidor that = (Repartidor) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
