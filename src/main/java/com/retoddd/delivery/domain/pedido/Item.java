package com.retoddd.delivery.domain.pedido;

import co.com.sofka.domain.generic.Entity;
import com.retoddd.delivery.domain.cliente.values.Detalle;
import com.retoddd.delivery.domain.cliente.values.Nombre;
import com.retoddd.delivery.domain.pedido.values.ItemId;
import com.retoddd.delivery.domain.pedido.values.Precio;

import java.util.Objects;

public class Item extends Entity<ItemId> {
    private Nombre nombre;
    private Detalle detalle;
    private Precio precio;

    public Item(ItemId itemId, Nombre nombre, Detalle detalle, Precio precio) {
        super(itemId);
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
    }

    public void actualizarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser null");
    }

    public void actualizarPrecio(Precio precio) {
        this.precio = Objects.requireNonNull(precio, "El precio no puede ser null");
    }

    public Nombre nombre() {
        return nombre;
    }

    public Detalle detalle() {
        return detalle;
    }

    public Precio precio() {
        return precio;
    }
}
