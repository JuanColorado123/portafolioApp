package com.jdcolorado.portafolioapp.repository;

import com.jdcolorado.portafolioapp.model.Education;

import java.util.List;
import java.util.Optional;

public interface IEducationRepository {
    Education save(Education Education);
    List<Education> findAll();
    Optional<Education> findById(Long id);
    void deleteById(Long id);
    List<Education> findByPersonalInfoId(Long personalInfoId);
}
