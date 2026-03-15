package com.jdcolorado.portafolioapp.service;

import com.jdcolorado.portafolioapp.exception.ValidationException;
import com.jdcolorado.portafolioapp.model.Education;
import com.jdcolorado.portafolioapp.repository.IEducationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class EducationServiceTest {


    @Autowired
    private IEducationService service;
    @Autowired
    private IEducationRepository repository;

    @Test
    void testSaveValidEducation(){
        Education education = new Education(null, "Superior" ,"Ucompnesar" ,LocalDate.of(2023, 5, 10) ,LocalDate.of(2024, 5, 10),"Ingeniro de software especializado en java" ,1L);

        Education saveEducation = service.save(education);

        assertNotNull(repository.findById(saveEducation.getId()).orElse(null), "El objeto guardado debe tener un ID asignado");
    }

    @Test
    void testSaveInvalidEducation(){
        Education education = new Education(null, null ,null ,LocalDate.of(2023, 5, 10) ,LocalDate.of(2024, 5, 10),"Ingeniro de software especializado en java" ,1L);

        assertThrows(ValidationException.class,() -> service.save(education),"El objeto guardado debe existir en la base de datos");
    }
}