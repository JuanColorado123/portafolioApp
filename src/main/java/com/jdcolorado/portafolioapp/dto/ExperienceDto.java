package com.jdcolorado.portafolioapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDto {
    private Long id;

    @NotBlank(message = "El campo titulo del trabajo, no puede estar vacio")
    private String jobTitle;

    @NotBlank(message = "El campo nombre de la empresa, no puede estar vacio")
    private String companyName;

    @NotNull(message = "El campo fecha de inicio, no puede ser nulo")
    @PastOrPresent(message = "El campo fecha de inicio, no puede tener una fehca futura")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "El campo fecha de fin, no puede ser nulo")
    @PastOrPresent(message = "El campo fecha de fin, no puede tener una fehca futura")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotBlank(message = "El campo descripcion, no puede estar vacio")
    private String description;

    @NotNull(message = "El campo personalInfoId no puede estar vacio")
    @Min(value = 1, message = "El campo personalInfoId debe ser un numero positivo")
    private Long personalInfoId;
}
