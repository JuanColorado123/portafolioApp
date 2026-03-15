package com.jdcolorado.portafolioapp.service;

import com.jdcolorado.portafolioapp.exception.ValidationException;
import com.jdcolorado.portafolioapp.model.Experience;
import com.jdcolorado.portafolioapp.repository.IExperienceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ExperienceServiceTest {

    @Autowired
    private IExperienceService service;
    @Autowired
    private IExperienceRepository repository;


    @Test
    void testSaveValidExperience(){
        Experience experience = new Experience(null,"Java Developer","Topaz",LocalDate.of(2025, 4,14),LocalDate.of(2026,3,8),"Desarrollar y mejorar el producto base de un core bancario",1L);
        Experience saveExperience = service.save(experience);

        assertNotNull(saveExperience.getId(),"Algo salio mal, el objeto guardado es null");

        assertNotNull(repository.findById(saveExperience.getId()).orElse(null), "Algo salio mal, no se encontro el objeto en base de datos");
    }

    @Test
    void testSaveInvalidExperience(){
        Experience experience = new Experience(null,null,"Topaz",LocalDate.of(2025, 4,14),LocalDate.of(2026,3,8),"Desarrollar y mejorar el producto base de un core bancario",1L);

        assertThrows(ValidationException.class,() -> service.save(experience),"Algo salio mal, el objeto no lanzo una excepcion de tipo ValidationExeption");
    }
}
