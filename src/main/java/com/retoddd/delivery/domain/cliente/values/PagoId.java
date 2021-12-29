package com.retoddd.delivery.domain.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class PagoId extends Identity {
    public PagoId(){}
    private PagoId(String id){
        super(id);
    }
    public static PagoId of(String id){
        return new PagoId(id);
    }
}
