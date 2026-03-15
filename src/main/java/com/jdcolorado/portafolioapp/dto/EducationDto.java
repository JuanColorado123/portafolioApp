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
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {

    private Long id;

    @NotBlank(message = "El campo grado, no puede estar vacio")
    private String degree;

    @NotBlank(message = "El campo institucionn, no puede estar vacio")
    private String institution;

    @NotNull(message = "El campo fecha de inicio, no puede ser nulo")
    @PastOrPresent(message = "La fecha de inicio no puede ser futura")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "El campo fecha de fin, no puede ser nulo")
    @PastOrPresent(message = "La fecha de fin no puede ser futura")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotBlank(message = "El campo descipcion, no puede estar vacio")
    private String description;

    @NotNull(message = "El campo personalInfoId no puede estar vacio")
    @Min(value = 1, message = "El campo personalInfoId debe ser un numero positivo")
    private Long personalInfoId;
}
