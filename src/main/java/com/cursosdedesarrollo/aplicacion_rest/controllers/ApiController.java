package com.cursosdedesarrollo.aplicacion_rest.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursosdedesarrollo.aplicacion_rest.dtos.Dato;

@RestController
@RequestMapping("/api/v1/dato")
public class ApiController {

    public List<Dato> listado = new LinkedList<>();

    public Long lastId = 0L;

    public ApiController(){
        this.listado.add(new Dato(1L, "twitch"));
        this.lastId = 1L;
    }

    @GetMapping("/")
    List<Dato> index(){
        return this.listado;
    }

    @PostMapping("/")
    Dato create(@RequestBody Dato dato){
        dato.setId(++this.lastId);
        this.listado.add(dato);
        return dato;
    }

    @GetMapping("/{id}")
    Dato show(@PathVariable("id") Long id){
        return this.listado.stream()
        .filter(dato -> dato.getId().equals(id))
        .findFirst().orElse(new Dato());
    }

    @PatchMapping("/{id}")
    Dato update(@PathVariable("id") Long id, @RequestBody Dato dato){
        return this.listado
                    .stream()
                    .filter(datoGuardado -> datoGuardado.getId().equals(id))
                    .findFirst()
                    .map(datoGuardado -> {
                        System.out.println("dato entrada" + dato);
                        datoGuardado.setCadena(dato.getCadena());
                        System.out.println("dato salida" + datoGuardado);
                        return datoGuardado;
                    }).orElse(new Dato());
    }

    @DeleteMapping("/{id}")
    Dato delete(@PathVariable("id") Long id){
        return this.listado
                    .stream()
                    .filter(datoEliminar -> datoEliminar.getId().equals(id))
                    .findFirst()
                    .map(datoEliminar -> {
                        this.listado.remove(datoEliminar);
                        return datoEliminar;
                    }).orElse(new Dato());
    }

}
