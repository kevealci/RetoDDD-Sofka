package com.retoddd.delivery.domain.restaurante.values;

import co.com.sofka.domain.generic.Identity;
import com.retoddd.delivery.domain.cliente.values.ClienteId;

public class EstacionId extends Identity {
    public EstacionId(){}
    private EstacionId(String id){
        super(id);
    }
    public static EstacionId of(String id){
        return new EstacionId(id);
    }
}
