package com.cursosdedesarrollo.aplicacion_rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursosdedesarrollo.aplicacion_rest.domain.Alumno;
import com.cursosdedesarrollo.aplicacion_rest.repositories.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService{

    AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoServiceImpl(AlumnoRepository alumnoRepository){
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public List<Alumno> findAll(){
        return alumnoRepository.findAll();
    }
}
