package com.cursosdedesarrollo.aplicacion_rest.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlumnoDTO {

    @NotNull
    @Size(min = 3, max = 20, message = "el nombre debe tener más de 3 letras y menos de 20")
    private String nombre;

    @NotNull(message = "los apellidos no pueden estar vacios")
    private String apellidos;

    @Min(value = 18, message = "El usuario debe tener al menos 18 años de edad")
    private Integer edad;


}
