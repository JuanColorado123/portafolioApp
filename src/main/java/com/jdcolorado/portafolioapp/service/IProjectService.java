package com.jdcolorado.portafolioapp.service;

import com.jdcolorado.portafolioapp.model.Project;

import java.util.List;
import java.util.Optional;

public interface IProjectService {
    Project save(Project project);
    Optional<Project> findById(Long id);
    List<Project> findAll();
    void deleteById(Long id);
}
