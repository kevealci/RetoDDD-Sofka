package com.retoddd.delivery.domain.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class InformacionId extends Identity {
    public InformacionId(){}
    private InformacionId(String id){
        super(id);
    }
    public static InformacionId of(String id){
        return new InformacionId(id);
    }
}
