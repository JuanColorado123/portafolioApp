package com.jdcolorado.portafolioapp.repository;

import com.jdcolorado.portafolioapp.model.PersonalInfo;
import com.jdcolorado.portafolioapp.model.Project;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IPersonalInfoRepository {
    @Transactional
    PersonalInfo save(PersonalInfo personalInfo);
    Optional<PersonalInfo> findById(Long id);
    List<PersonalInfo> findAll();
    void deleteById(Long id);

    interface IProjectRepository {
        Project save(Project project);
        Optional<Project> findById(Long id);
        List<Project> findAll();
        void deleteById(Long id);
    }
}
