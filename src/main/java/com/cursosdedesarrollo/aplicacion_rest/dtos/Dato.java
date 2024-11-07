package com.cursosdedesarrollo.aplicacion_rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dato {

    private Long id;

    private String cadena;

    public Dato(){
        this.id = 0L;
        this.cadena = "";
    }

}
