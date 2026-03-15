package com.jdcolorado.portafolioapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SkillDto {

    private Long id;

    @NotBlank(message = "El campo nombre no puede estar vacio")
    private String name;

    @NotNull(message = "el campo porcentaje no puede ser nulo")
    @Max(value = 100, message = "El porcentaje debe ser maximo 100")
    @Min(value = 0, message = "El porcentaje debe ser minimo de 0")
    private Integer levelPercentage;

    @NotBlank(message = "El campo icono no puede estar vacio")
    private String iconClass;

    @NotNull(message = "El campo personalInfoId no puede estar vacio")
    @Min(value = 1, message = "El campo personalInfoId debe ser un numero positivo")
    private Long personalInfoId;
}
