package com.jdcolorado.portafolioapp.service.impl;

import com.jdcolorado.portafolioapp.exception.ValidationException;
import com.jdcolorado.portafolioapp.model.Experience;
import com.jdcolorado.portafolioapp.repository.IExperienceRepository;
import com.jdcolorado.portafolioapp.service.IExperienceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExperienceServiceImpl implements IExperienceService {
    private final IExperienceRepository experienceRepository;
    private final Validator validator;

    @Override
    @Transactional(readOnly = true)
    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Experience> findById(Long id) {
        return experienceRepository.findById(id);
    }

    @Override
    @Transactional
    public Experience save(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Eliminando experiencia por ID: {} en el servicio...", id);
        experienceRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true  )
    public List<Experience> findExperienceByPersonalInfoId(Long personalInfoId) {
        return experienceRepository.findByPersonalInfoId(personalInfoId);
    }
}
