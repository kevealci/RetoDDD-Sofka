package com.retoddd.delivery.domain.pedido.values;

import co.com.sofka.domain.generic.Identity;

public class EntregaId extends Identity {
    public EntregaId(){}
    private EntregaId(String id){
        super(id);
    }
    public static EntregaId of(String id){
        return new EntregaId(id);
    }
}
