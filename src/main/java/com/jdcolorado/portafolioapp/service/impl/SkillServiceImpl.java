package com.jdcolorado.portafolioapp.service.impl;

import com.jdcolorado.portafolioapp.model.Skill;
import com.jdcolorado.portafolioapp.repository.ISkillRepository;
import com.jdcolorado.portafolioapp.service.ISkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements ISkillService {

    private final ISkillRepository repository;
    private final Validator validator;

    @Override
    @Transactional
    public Skill save(Skill skill){
        return repository.save(skill);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Skill> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Skill> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Skill> findByPersonalId(Long personalInfoId) {
        return repository.findByPersonalId(personalInfoId);
    }
}
