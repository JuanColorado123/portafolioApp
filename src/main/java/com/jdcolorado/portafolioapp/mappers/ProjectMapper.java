package com.jdcolorado.portafolioapp.dto.Mappers;

import com.jdcolorado.portafolioapp.dto.ProjectDTO;
import com.jdcolorado.portafolioapp.model.Project;

public class ProjectMapper {

    public static ProjectDTO toDTO(Project project){

        if(project == null){
            return null;
        }

        ProjectDTO projectDTO = new ProjectDTO();

        projectDTO.setId(project.getId());
        projectDTO.setTitle(project.getTitle());
        projectDTO.setDescription(project.getDescription());
        projectDTO.setImageUrl(project.getImageUrl());
        projectDTO.setProjectUrl(project.getProjectUrl());
        projectDTO.setPersonalInfoId(project.getPersonalInfoId());

        return projectDTO;
    }

    public static Project toProject(ProjectDTO projectDTO){

        if(projectDTO == null){
            return null;
        }

        Project project = new Project();

        project.setId(projectDTO.getId());
        project.setTitle(projectDTO.getTitle());
        project.setDescription(projectDTO.getDescription());
        project.setImageUrl(projectDTO.getImageUrl());
        project.setProjectUrl(projectDTO.getProjectUrl());
        project.setPersonalInfoId(projectDTO.getPersonalInfoId());

        return project;
    }
}
