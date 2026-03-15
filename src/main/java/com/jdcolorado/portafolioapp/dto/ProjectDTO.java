package com.jdcolorado.portafolioapp.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class ProjectDTO {
    private Long id;

    @NotBlank(message = "El campo title no puede estar vacio")
    @Size(min = 2, max = 255, message = "El campo debe tener entre 2 y 255 caractares")
    private String title;

    @NotBlank(message = "El campo description no puede estar vacio")
    @Size(min = 10, max = 255, message = "El campo debe tener entre 2 y 255 caractares")
    private String description;

    @URL(message = "El campo imageUrl no cumple con el formato de url")
    private String imageUrl;

    @URL(message = "El campo projectUrl no cumple con el formato de url")
    private String projectUrl;

    @NotNull(message = "El campo personalInfoId no puede estar vacio")
    @Min(value = 1, message = "El campo personalInfoId debe ser un numero positivo")
    private Long personalInfoId;
}
