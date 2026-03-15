package com.jdcolorado.portafolioapp.service;

import com.jdcolorado.portafolioapp.model.Skill;

import java.util.List;
import java.util.Optional;

public interface ISkillService {
    Skill save(Skill skill);
    List<Skill> findAll();
    Optional<Skill> findById(Long id);
    void delete(Long id);
    List<Skill> findByPersonalId(Long personalInfoId);
}
