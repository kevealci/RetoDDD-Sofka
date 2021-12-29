package com.retoddd.delivery.domain.restaurante.values;

import co.com.sofka.domain.generic.Identity;

public class VentaId extends Identity {
    public VentaId(){}
    private VentaId(String id){
        super(id);
    }
    public static VentaId of(String id){
        return new VentaId(id);
    }
}
