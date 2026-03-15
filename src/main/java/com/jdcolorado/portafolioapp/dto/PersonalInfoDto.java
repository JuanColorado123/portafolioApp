package com.jdcolorado.portafolioapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfoDto {
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacio")
    private String firstName;

    @NotBlank(message = "El apellido no puede estar vacio")
    private String lastName;

    @NotBlank(message = "El titulo no puede estar vacio")
    private String title;

    @NotBlank(message = "La descripcion no puede estar vacio")
    private String profileDescription;

    @NotBlank(message = "La url no puede estar vacia")
    private String profileImageUrl;

    @Min(value = 0, message = "Los años de experiencia no pueden ser negativos")
    private Integer yearOfExperience;

    @Email(message = "El email no es valido")
    private String email;

    @NotBlank(message = "El phone no puede estar vacio")
    private String phone;

    @URL(message = "El linkedinUrl no puede estar vacio")
    private String linkedinUrl;

    @URL(message = "El githubUrl no puede estar vacio")
    private String githubUrl;
}
