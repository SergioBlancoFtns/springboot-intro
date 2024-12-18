package com.cursosdedesarrollo.aplicacion_rest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursosdedesarrollo.aplicacion_rest.domain.Alumno;
import com.cursosdedesarrollo.aplicacion_rest.dtos.AlumnoDTO;
import com.cursosdedesarrollo.aplicacion_rest.repositories.AlumnoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/alumno-controller")
public class AlumnoRepositoryController {

    @Autowired
    AlumnoRepository alumnoRepository;

    @GetMapping("/")
    public ResponseEntity<List<Alumno>> index(){
        return ResponseEntity.ok(alumnoRepository.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Alumno> create(@RequestBody @Valid AlumnoDTO alumnoDTO){
        Alumno alumno = new Alumno(alumnoDTO);
        return ResponseEntity.ok(alumnoRepository.save(alumno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> show(@Valid @PathVariable("id") Long id){
        Optional<Alumno> alumno = alumnoRepository.findById(id);
        if(alumno.isPresent()){
            return ResponseEntity.ok(alumno.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> update(@Valid @PathVariable("id") Long id, @Valid @RequestBody AlumnoDTO alumnoDTO){
        Optional<Alumno> alumno = alumnoRepository.findById(id);
        if(alumno.isPresent()){
            Alumno alumnoToSave = new Alumno(alumnoDTO);
            alumnoToSave.setId(id);
            return ResponseEntity.ok(alumnoRepository.save(alumnoToSave));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Alumno> delete(@Valid @PathVariable("id") Long id){
        Optional<Alumno> alumno = alumnoRepository.findById(id);

        if(alumno.isPresent()){
            alumnoRepository.deleteById(id);
            return ResponseEntity.ok(alumno.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
