package com.cursosdedesarrollo.aplicacion_rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cursosdedesarrollo.aplicacion_rest.domain.Alumno;

@Service
public interface AlumnoService {
    List<Alumno> findAll();

}
