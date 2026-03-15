package com.jdcolorado.portafolioapp.service;

import com.jdcolorado.portafolioapp.exception.ValidationException;
import com.jdcolorado.portafolioapp.model.Skill;
import com.jdcolorado.portafolioapp.repository.ISkillRepository;
import com.jdcolorado.portafolioapp.service.impl.SkillServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SkillServiceImplTest {

    @Mock
    private ISkillRepository repository;

    @Mock
    private Validator validator;

    @InjectMocks
    private SkillServiceImpl service;

    @Test
    void  testFindAllReturnsListOfSkills(){

        List<Skill> skillsMocks = Arrays.asList(
                new Skill(1L, "Java", 90, "fab fa-java", 1L),
                new Skill(2L, "Python", 60, "fab fa-python", 1L),
                new Skill(3L, "PHP", 30, "fab fa-php", 1L)
        );
        when(repository.findAll()).thenReturn(skillsMocks);

        List<Skill> skillListService = service.findAll();


        assertNotNull(skillListService);
        assertEquals(3,skillListService.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testFindByIdReturnsSkillsWhenFound(){

        Long id = 1L;
        Skill mockSkill = new Skill(id, "Java", 90, "fab fa-java", 1L);
        when(repository.findById(id)).thenReturn(Optional.of(mockSkill));

        Optional<Skill> mockSkillResult = service.findById(id);

        assertNotNull(mockSkillResult);
        assertFalse(mockSkillResult.isEmpty());
        assertEquals("Java", mockSkillResult.get().getName());
        verify(repository, times(1)).findById(id);
    }

    @Test
    void testSaveSkillThrowsExceptionWhenInvalid(){

        Skill invalidSkill = new Skill();
        doAnswer(invocationOnMock -> {
            BindingResult result = invocationOnMock.getArgument(1);
            result.rejectValue("name", "notBlank", "El nombre no puede estar vacio");

            return null;
        }).when(validator).validate(any(Skill.class), any(BindingResult.class));

        assertThrows(ValidationException.class, () -> service.save(invalidSkill), "Debe lanzarce un validateExeption si el objeto no es valido");

        verify(repository, never()).save(any(Skill.class));
    }

    @Test
    void testSaveSkillSavesValidSkill(){

        Skill validSkill = new Skill(null, "Java", 90, "fab fa-java", 1L);
        when(repository.save(any(Skill.class))).thenReturn(validSkill);
        doNothing().when(validator).validate(any(Skill.class), any(BindingResult.class));

        Skill skillResult =  service.save(validSkill);

        assertNotNull(skillResult);
        assertEquals(validSkill, skillResult);

        verify(repository, times(1)).save(validSkill);
    }
}
