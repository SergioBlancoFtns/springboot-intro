package com.cursosdedesarrollo.aplicacion_rest.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class DatoTests {

    @Test
    public void checkConstructorWithoutParams(){

        Dato dato = new Dato();
        assertNotNull(dato);
        assertEquals(dato.getId(), 0, "El Id debería ser 0");
        assertEquals(dato.getCadena(), "", "La cadena debería ser ''");
        System.out.printf("Dato %s", dato);
    }

    @Test
    public void checkConstructorWithParams(){

        Dato dato = new Dato(1L, "twitch");
        assertNotNull(dato);
        assertEquals(dato.getId(), 1, "El Id debería ser 1");
        assertEquals(dato.getCadena(), "twitch", "La cadena debería ser twitch");
        System.out.printf("Dato %s", dato);
    }
}
