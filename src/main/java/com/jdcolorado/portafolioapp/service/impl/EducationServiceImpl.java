package com.jdcolorado.portafolioapp.service.impl;

import com.jdcolorado.portafolioapp.exception.ValidationException;
import com.jdcolorado.portafolioapp.model.Education;
import com.jdcolorado.portafolioapp.repository.IEducationRepository;
import com.jdcolorado.portafolioapp.service.IEducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements IEducationService {

    private final IEducationRepository educationRepository;
    private final Validator validator;

    @Override
    @Transactional(readOnly = true)
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Education> findById(Long id) {
        return educationRepository.findById(id);
    }

    @Override
    @Transactional
    public Education save(Education education) {

        if(education.getStartDate().isAfter(education.getEndDate())) {
            throw new IllegalArgumentException("La fecha de inicio de la educación no puede ser posterior a la fecha de fin.");
        }

        return educationRepository.save(education);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Education> findEducationByPersonalInfoId(Long personalInfoId) {
        return educationRepository.findByPersonalInfoId(personalInfoId);
    }
}