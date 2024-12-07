package com.cursosdedesarrollo.aplicacion_rest.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cursosdedesarrollo.aplicacion_rest.dtos.Dato;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class ApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    public String basePath = "/api/v1/dato";

    @BeforeEach
    public void clearRestData() throws Exception {
        System.out.println("limpiando");
        mockMvc.perform(
                        MockMvcRequestBuilders
                        .get(basePath + "/clear")
                        .contentType(MediaType.APPLICATION_JSON)
                        
        ).andExpect(status().isOk());
    }

    @Test
    void testListShouldReturnOkResult() throws Exception {
        List<Dato> listadoEsperado = new ArrayList<>();

        mockMvc.perform(
                        MockMvcRequestBuilders.get(basePath + "/")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(mapper.writeValueAsString(listadoEsperado)));

    }

    @Test
    void testAddShouldReturnDato() throws Exception{
        Dato objetoEnviado = new Dato(0L, "valor");
        Dato objetoRecibido = new Dato(1L, "valor");
        
        
        mockMvc.perform(MockMvcRequestBuilders
        .post(basePath + "/")
        .content(mapper.writeValueAsString(objetoEnviado))
        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(mapper.writeValueAsString(objetoRecibido)));
    }

    @Test
    void testGetByIDShouldReturnDato() throws Exception {
        Dato datoEsperado = new Dato(1L, "valor");
        
        testAddShouldReturnDato();

        mockMvc.perform(
                        MockMvcRequestBuilders.get(basePath + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(mapper.writeValueAsString(datoEsperado)));
    }

    @Test
    void testUpdateShouldReturnDato() throws Exception {
        Dato datoEnviado = new Dato(0L, "valor1");
        Dato datoEsperado = new Dato(1L, "valor1");

        testAddShouldReturnDato();

        mockMvc.perform(
                        MockMvcRequestBuilders.patch(basePath + "/1")
                        .content(asJsonString(datoEnviado))
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(mapper.writeValueAsString(datoEsperado)));
    }

    @Test
    void testRemoveByIDShouldReturnDato() throws Exception{
        Dato datoEsperado = new Dato(1L, "valor");

        testAddShouldReturnDato();

        mockMvc.perform(
                        MockMvcRequestBuilders
                        .delete(basePath + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(content().json(mapper.writeValueAsString(datoEsperado)));
    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
