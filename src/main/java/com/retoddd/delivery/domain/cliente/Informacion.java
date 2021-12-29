package com.retoddd.delivery.domain.cliente;

import co.com.sofka.domain.generic.Entity;
import com.retoddd.delivery.domain.cliente.values.*;

import java.util.Objects;

public class Informacion extends Entity<InformacionId> {

    private Nombre nombre;
    private Direccion direccion;

    public Informacion(InformacionId informacionId, Nombre nombre, Direccion direccion) {
        super(informacionId);
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void actualizarNombre(Nombre nombre) { this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");}

    public void actualizarDireccion(Direccion direccion) { this.direccion = Objects.requireNonNull(direccion, "La direccion no puede ser nula");}

    public Nombre nombre() { return nombre; }

    public Direccion direccion() { return direccion; }
}
