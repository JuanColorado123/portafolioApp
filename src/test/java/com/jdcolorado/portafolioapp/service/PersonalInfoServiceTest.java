package com.jdcolorado.portafolioapp.service;

import com.jdcolorado.portafolioapp.exception.ValidationException;
import com.jdcolorado.portafolioapp.model.PersonalInfo;
import com.jdcolorado.portafolioapp.repository.IPersonalInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class PersonalInfoServiceTest {
    @Autowired
    private IPersonalInfoService personalInfoService;
    @Autowired
    private IPersonalInfoRepository personalInfoRepository;

    @Test
    void testSaveValidPersonalInfo() {
        PersonalInfo validInfo = new PersonalInfo(null, "John", "Doe", "Developer", "Descripción", "url", 5, "email@example.com", "123456789", "https://linkedin.com", "https://github.com");
        PersonalInfo savedInfo = personalInfoService.save(validInfo);

        assertNotNull(savedInfo.getId(), "El objeto guardado debe tener un ID asignado");
        assertNotNull(personalInfoRepository.findById(savedInfo.getId()).orElse(null), "El objeto guardado debe existir en la base de datos");
    }

    @Test
    void testSaveInvalidFirstName() {
        PersonalInfo invalidInfo = new PersonalInfo(null, "", "Doe", "Developer", "Descripción", "url", 5, "email@example.com", "123456789", "linkedin.com", "github.com");

        assertThrows(ValidationException.class, () -> personalInfoService.save(invalidInfo),
                "Debe lanzarse una ValidationException cuando el nombre está vacío");
    }
}
