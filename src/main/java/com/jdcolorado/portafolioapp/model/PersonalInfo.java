package com.jdcolorado.portafolioapp.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfo {
    private Long id;
    private String firstName;
    private String lastName;
    private String title;
    private String profileDescription;
    private String profileImageUrl;
    private Integer yearOfExperience;
    private String email;
    private String phone;
    private String linkedinUrl;
    private String githubUrl;
}
