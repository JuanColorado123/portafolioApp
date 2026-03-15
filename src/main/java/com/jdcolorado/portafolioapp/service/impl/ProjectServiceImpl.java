package com.jdcolorado.portafolioapp.service.impl;

import com.jdcolorado.portafolioapp.model.Project;
import com.jdcolorado.portafolioapp.repository.IPersonalInfoRepository;
import com.jdcolorado.portafolioapp.service.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements IProjectService {

    private final IPersonalInfoRepository.IProjectRepository repository;

    @Override
    @Transactional
    public Project save(Project project) {
        return repository.save(project);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Project> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
