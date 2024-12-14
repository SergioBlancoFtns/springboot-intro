package com.cursosdedesarrollo.aplicacion_rest.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity(name = "Alumnos")
@Table(name = "ALUMNOS")
public class Alumno {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 3, max = 20, message = "el nombre debe tener más de 3 letras y menos de 20")
    private String nombre;

    private String apellidos;

    @Min(value = 18, message = "El usuario debe tener al menos 18 años de edad")
    private Integer edad;

}
