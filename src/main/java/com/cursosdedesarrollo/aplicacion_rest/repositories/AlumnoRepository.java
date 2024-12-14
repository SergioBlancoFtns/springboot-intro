package com.cursosdedesarrollo.aplicacion_rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursosdedesarrollo.aplicacion_rest.domain.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
