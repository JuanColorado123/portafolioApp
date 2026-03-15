package com.jdcolorado.portafolioapp.repository;

import com.jdcolorado.portafolioapp.model.Skill;

import java.util.List;
import java.util.Optional;

public interface IEducationRepository {
    Skill save(Skill skill);
    List<Skill> findAll();
    Optional<Skill> findById(Long id);
    void delete(Long id);
    List<Skill> findByPersonalId(Long personalInfoId);
}
