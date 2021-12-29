package com.retoddd.delivery.domain.restaurante.values;

import co.com.sofka.domain.generic.Identity;

public class RestauranteId extends Identity {
    public RestauranteId(){}
    private RestauranteId(String id){
        super(id);
    }
    public static RestauranteId of(String id){
        return new RestauranteId(id);
    }
}
