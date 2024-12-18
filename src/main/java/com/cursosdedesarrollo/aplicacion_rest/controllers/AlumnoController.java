package com.cursosdedesarrollo.aplicacion_rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursosdedesarrollo.aplicacion_rest.domain.Alumno;
import com.cursosdedesarrollo.aplicacion_rest.service.AlumnoService;

@RestController
@RequestMapping("/api/v1/alumno")
public class AlumnoController {

    AlumnoService alumnoService;

    @Autowired
    public AlumnoController(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Alumno>> index(){
        return ResponseEntity.ok(alumnoService.findAll());
    }

}
