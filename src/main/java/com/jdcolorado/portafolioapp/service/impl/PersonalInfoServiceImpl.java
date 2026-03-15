package com.jdcolorado.portafolioapp.service;

import com.jdcolorado.portafolioapp.model.PersonalInfo;
import com.jdcolorado.portafolioapp.repository.IPersonalInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonalInfoServiceImpl implements IPersonalInfoService{

    private final IPersonalInfoRepository repository;

    @Override
    public PersonalInfo save(PersonalInfo personalInfo) {
        return repository.save(personalInfo);
    }

    @Override
    public Optional<PersonalInfo> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<PersonalInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
