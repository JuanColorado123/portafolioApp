package com.jdcolorado.portafolioapp.service.impl;

import com.jdcolorado.portafolioapp.exception.ValidationException;
import com.jdcolorado.portafolioapp.model.PersonalInfo;
import com.jdcolorado.portafolioapp.repository.IPersonalInfoRepository;
import com.jdcolorado.portafolioapp.service.IPersonalInfoService;

import lombok.RequiredArgsConstructor;
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
public class PersonalInfoServiceImpl implements IPersonalInfoService {

    private final IPersonalInfoRepository repository;
    private final Validator validator;

    @Override
    @Transactional
    public PersonalInfo save(PersonalInfo personalInfo) {
        return repository.save(personalInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PersonalInfo> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)

    public List<PersonalInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
