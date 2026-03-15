package com.jdcolorado.portafolioapp.service;

import com.jdcolorado.portafolioapp.exception.ValidationException;
import com.jdcolorado.portafolioapp.model.Skill;
import com.jdcolorado.portafolioapp.repository.ISkillRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class SkillServiceTest {
    @Autowired
    private ISkillService skillService;
    @Autowired
    private ISkillRepository skillRepository;

    @Test
    void testSaveValidSkill(){
        Skill validSkill = new Skill(null, "Java", 90, "fab fa-java", 1L);
        Skill saveSkill = skillService.save(validSkill);

        assertNotNull(saveSkill.getId(), "El objeto guardado debe tener un ID asignado");

        assertNotNull(skillRepository.findById(saveSkill
                .getId())
                .orElse(null),"El objeto guardado debe existir en la base de datos");
    }

    @Test
    void testSaveInvalidSkill(){
        Skill validSkill = new Skill(null, null, 90, "fab fa-java", 1L);

        assertThrows(ValidationException.class,  () -> skillService.save(validSkill),
                "Debe lanzarse una ValidationException cuando el nombre este vacio");
    }
}
